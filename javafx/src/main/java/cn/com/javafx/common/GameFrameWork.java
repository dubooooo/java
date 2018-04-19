package cn.com.javafx.common;

import javafx.application.Platform;

import java.text.DecimalFormat;

/**
 * @author dubooooo@126.com 2018-04-19
 */
public abstract class GameFrameWork extends AbstractStage {

    private Thread drawThread;
    private Thread updateThread;

    private double drawStartTime;
    private double updateStartTime;

    private double drawfps;
    private double updatefps;

    private String drawfpsstr;
    private String updatefpsstr;

    public void drawThreadStart(int nfps) {
        DecimalFormat df = new DecimalFormat("######0.00");
        drawThread = new Thread(() -> {
            drawStartTime = System.currentTimeMillis();
            double totalFPS = 0;
            long sleeptime = nfps <= 0 ? Integer.MAX_VALUE : 1000 / nfps;
            while (true) {
                try {
                    Platform.runLater(() -> {
                        draw();
                    });
                    drawfps = totalFPS++ / (System.currentTimeMillis() - drawStartTime) * 1000;
                    drawfpsstr = df.format(drawfps);
                    if (drawfps > nfps) {
                        sleeptime++;
                    } else if (drawfps < nfps) {
                        sleeptime--;
                    }
                    if (sleeptime < 1) {
                        sleeptime = 1;
                    }
                    Thread.sleep(sleeptime);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        drawThread.setDaemon(true);
        drawThread.start();
    }

    public abstract void draw();

    public String drawfps() {
        return drawfpsstr;
    }

    public String updatefps() {
        return updatefpsstr;
    }

    public void updateThreadStart(int nfps) {
        DecimalFormat df = new DecimalFormat("######0.00");
        updateThread = new Thread(() -> {
            updateStartTime = System.currentTimeMillis();
            double totalFPS = 0;
            long sleeptime = nfps <= 0 ? Integer.MAX_VALUE : 1000 / nfps;
            while (true) {
                try {
                    update();
                    updatefps = totalFPS++ / (System.currentTimeMillis() - updateStartTime) * 1000;
                    updatefpsstr = df.format(updatefps);
                    if (updatefps > nfps) {
                        sleeptime++;
                    } else if (updatefps < nfps) {
                        sleeptime--;
                    }
                    if (sleeptime < 1) {
                        sleeptime = 1;
                    }
                    Thread.sleep(sleeptime);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        updateThread.setDaemon(true);
        updateThread.start();
    }

    protected abstract void update();

}
