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

    public <T> T load(String url) {
        try {
            return FXMLLoader.load(Thread.currentThread().getContextClassLoader().getResource(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Timeline timeline(int millis) {
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(millis), e -> action(e)));
        timeline.play();
        return timeline;
    }

    public void action(ActionEvent e) {
        log.info(e.toString());
    }

}
