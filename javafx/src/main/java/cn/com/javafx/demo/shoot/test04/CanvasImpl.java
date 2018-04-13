package cn.com.javafx.demo.shoot.test04;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dubooooo@126.com 2018-04-13
 */
public class CanvasImpl extends Canvas {

    private GraphicsContext context;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    private ImageView imageView = new ImageView("img/actor.png");

    public void start(double width, double height) {
        initScreenSize(width, height);
        initGraphicsContext();
        initTimeline();
    }

    public void initScreenSize(double width, double height) {
        setWidth(width);
        setHeight(height);
    }

    public void initTimeline() {
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(1000), e -> action()));
        timeline.play();
    }

    int p_w = 33, p_h = 35;

    public void action() {

        try {
            System.out.println(dateFormat.format(new Date()));
            context.save();
            for (int y = 0; y < 8; y++) {
                for (int x = 0; x < 12; x++) {
                    context.drawImage(imageView.getImage(), x * p_w, y * p_h, p_w, p_h, x * p_w, y * p_h, p_w, p_h);
                }
            }
            context.restore();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initGraphicsContext() {
        context = getGraphicsContext2D();
    }

}
