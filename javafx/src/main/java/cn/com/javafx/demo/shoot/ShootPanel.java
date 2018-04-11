package cn.com.javafx.demo.shoot;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * @author dubooooo@126.com 2018-04-11
 */
public class ShootPanel extends Parent {

    private BackGround[] backGrounds;
    private Hero hero;

    public void start() {
        showBackGround();
        //showHero();
        showHero01();
    }

    private void showHero01() {
        hero = new Hero(GameConstant.hero_url);
        getChildren().addAll(hero);
        System.out.println("shootPanel:" + getChildren());
        getScene().setOnMouseMoved(e -> {
            hero.setX(e.getX()).setY(e.getY());
        });
    }

    private void showHero() {
        ImageView imageView = new ImageView(GameConstant.hero_url[0]);
        double img_weigth = imageView.getImage().getWidth();
        double img_heigth = imageView.getImage().getHeight();
        imageView.setLayoutY(GameConstant.windows_height - GameConstant.windows_height / 5);
        imageView.setLayoutX(GameConstant.windows_weight / 2 - img_weigth / 2);
        getScene().setOnMouseMoved(e -> {
            System.out.println(e);
            double x = e.getX();
            double y = e.getY();
            imageView.setLayoutX(x - img_weigth / 2);
            imageView.setLayoutY(y - img_heigth / 2);
        });
        final int[] index = {0};
        Timeline timeline = new Timeline(Timeline.INDEFINITE, new KeyFrame(Duration.millis(300), e -> {
            System.out.println("change");
            imageView.setImage(new Image(GameConstant.hero_url[index[0]++]));
            if (index[0] > GameConstant.hero_url.length) {
                index[0] = 0;
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        getChildren().add(imageView);
    }

    private void showBackGround() {
        backGrounds = new BackGround[2];
        backGrounds[0] = new BackGround(GameConstant.back_ground_url);
        backGrounds[1] = new BackGround(GameConstant.back_ground_url);
        getChildren().addAll(backGrounds[0], backGrounds[1]);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyFrame keyFrame = new KeyFrame(Duration.ONE, e -> {
            if (backGrounds[0].getY() >= 0) {
                backGrounds[0].setY(-GameConstant.windows_height);
                backGrounds[1].setY(0);
            } else {
                backGrounds[0].moveY(0.01);
                backGrounds[1].moveY(0.01);
            }
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

}
