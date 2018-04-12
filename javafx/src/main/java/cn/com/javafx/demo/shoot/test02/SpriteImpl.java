package cn.com.javafx.demo.shoot.test02;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author dubooooo@126.com 2018-04-12
 */
public abstract class SpriteImpl implements Sprite {

    final static private Logger log = LoggerFactory.getLogger(SpriteImpl.class);

    private GraphicsApplication application;

    @Override
    final public void init(GraphicsApplication application) {
        this.application = application;
        init();
    }

    public void init() {
    }

    @Override
    public void before() {
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(getImage(), getX(), getY());
    }

    @Override
    public void after() {
    }

    public Timeline timeline(int millis, EventHandler<ActionEvent> action) {
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(millis), action));
        timeline.play();
        return timeline;
    }

    public GraphicsApplication getApplication() {
        return application;
    }

    public void remove() {
        getApplication().removeSprite(this);
    }

    public Image loadImage(String url) {
        log.debug("load image from : {}", url);
        return new Image(url);
    }

    public abstract double getX();

    public abstract double getY();

    public abstract double getWidth();

    public abstract double getHeight();

    public abstract Image getImage();

}
