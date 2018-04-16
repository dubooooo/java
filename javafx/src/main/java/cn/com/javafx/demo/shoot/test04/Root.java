package cn.com.javafx.demo.shoot.test04;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.util.Duration;

/**
 * @author dubooooo@126.com 2018-04-13
 */
public class Root extends Canvas {

    private Action action;
    private int time = 10;

    public Root(double width, double height) {
        super(width, height);
    }

    public void start(Action action) {
        initAction(action);
        initTimeline();
    }

    public void initAction(Action action) {
        this.action = action;
        action.init(this);
    }

    public void initScreenSize(double width, double height) {
        setWidth(width);
        setHeight(height);
    }

    public void initTimeline() {
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(getTime()), e -> action()));
        timeline.play();
    }

    public void action() {
        action.action(getGraphicsContext2D());
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
