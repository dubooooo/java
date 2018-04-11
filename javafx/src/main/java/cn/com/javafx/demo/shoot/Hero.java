package cn.com.javafx.demo.shoot;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.util.Duration;

/**
 * @author dubooooo@126.com 2018-04-11
 */
public class Hero extends FlyObject {

    private int index = 0;
    private Image image01 = new Image(GameConstant.hero_url[0]);
    private Image image02 = new Image(GameConstant.hero_url[1]);

    public Hero(String... imageUrl) {
        super(imageUrl[0]);
        changeSelf();
    }

    public void changeSelf() {
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(300), e -> {
            if (index++ % 2 == 0) {
                setImage(image01);
            } else {
                setImage(image02);
            }
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

}
