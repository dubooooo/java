package cn.com.javafx.common;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dubooooo@126.com 2018-04-18
 */
public class Windows extends Stage {

    final static Logger log = LoggerFactory.getLogger(Windows.class);
    private int timeInterval;
    private double startTime;
    private double totalFPS;
    private double fps;

    public Windows() {
        startTime = System.currentTimeMillis();
    }

    public <T> T load(String url) {
        try {
            return FXMLLoader.load(Thread.currentThread().getContextClassLoader().getResource(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Timeline timeline(int millis) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.ONE, e -> timelinePlay(e)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        return timeline;
    }

    public void timelinePlay(ActionEvent e) {
        action(e);
        fps = totalFPS++ / (System.currentTimeMillis() - startTime) * 1000;
        System.out.println(fps);
    }

    public double fps() {
        return fps;
    }

    public void fpsControl(Timeline timeline, int fps) {
        Thread thread = new Thread(new FPSControl(this, timeline, 60));
        thread.setDaemon(true);
        thread.start();
    }

    public void action(ActionEvent e) {
        log.info(e.toString());
    }

}

class FPSControl implements Runnable {

    private Windows windows;
    private Timeline timeline;
    private KeyFrame keyFrame;
    private int fps;

    public FPSControl(Windows windows, Timeline timeline, int fps) {
        this.windows = windows;
        this.timeline = timeline;
        this.fps = fps;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (windows.fps() > fps) {
                    System.out.println("FPS--");
                    timeline.getKeyFrames().forEach(keyFrame -> {
                        keyFrame.getTime().add(Duration.millis(keyFrame.getTime().toMillis() + 1));
                    });
                } else if (windows.fps() < fps) {
                    System.out.println("FPS++");
                    timeline.getKeyFrames().forEach(keyFrame -> {
                        keyFrame.getTime().add(Duration.millis(keyFrame.getTime().toMillis() - 1));
                    });
                }
                Thread.sleep(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}