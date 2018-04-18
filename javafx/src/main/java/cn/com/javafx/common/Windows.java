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
    private double timeInterval;

    public <T> T load(String url) {
        try {
            return FXMLLoader.load(Thread.currentThread().getContextClassLoader().getResource(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Timeline timeline(int fps) {
        timeInterval = 1000 / (double) fps;
        log.info("" + timeInterval);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.ONE, e -> fpsControl(e)));
        timeline.play();
        return timeline;
    }

    public void fpsControl(ActionEvent e) {
        double startTime = System.currentTimeMillis();
        action(e);
        double endTime = System.currentTimeMillis();
        double time = endTime - startTime - timeInterval;
        log.info("" + time);
        if (time < 0) {
            try {
                Thread.sleep((long) -time);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    public void action(ActionEvent e) {
        log.info(e.toString());
    }

}
