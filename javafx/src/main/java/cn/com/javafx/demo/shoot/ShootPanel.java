package cn.com.javafx.demo.shoot;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.util.Duration;

/**
 * @author dubooooo@126.com 2018-04-11
 */
public class ShootPanel extends Parent {

    private Group backGrounds;
    private Hero hero;
    private Group bullets;
    private Group airPlans;

    public void start() {
        showBackGround();
        showHero();
        showBullets();
        showAirPlans();
    }

    private void showAirPlans() {
        airPlans = new Group();
        getChildren().addAll(airPlans);
    }

    private void showBullets() {
        bullets = new Group();
        getChildren().addAll(bullets);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(30), e -> {
            System.out.println("bullets-size:" + bullets.getChildren().size());
            //for (Node node : bullets.getChildren()) {
            //    Bullet bullet = (Bullet) node;
            //    bullet.moveY(-1);
            //}
            Bullet bullet = new Bullet(GameConstant.bullet_url);
            bullet.move(hero.getX(), hero.getY());
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(1), event -> {
                bullet.moveY(-1);
                for (Node node : airPlans.getChildren()) {

                }
            }));
            timeline1.setCycleCount(Timeline.INDEFINITE);
            timeline1.play();
            bullets.getChildren().addAll(bullet);
        });
        timeline.getKeyFrames().addAll(keyFrame);
        timeline.play();
    }

    private void showHero() {
        hero = new Hero(GameConstant.hero_url);
        getChildren().addAll(hero);
        getScene().setOnMouseMoved(e -> {
            hero.setX(e.getX() - hero.getImgWeigth() / 2).setY(e.getY() - hero.getImgHeight() / 2);
        });
    }

    private void showBackGround() {
        backGrounds = new Group();
        BackGround backGround0 = new BackGround(GameConstant.back_ground_url);
        BackGround backGround1 = new BackGround(GameConstant.back_ground_url);
        backGrounds.getChildren().addAll(backGround0, backGround1);
        getChildren().addAll(backGrounds);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyFrame keyFrame = new KeyFrame(Duration.ONE, e -> {
            if (backGround0.getY() >= 0) {
                backGround0.setY(-GameConstant.windows_height);
                backGround1.setY(0);
            } else {
                backGround0.moveY(0.01);
                backGround1.moveY(0.01);
            }
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

}
