package cn.com.javafx.demo.test;/**
 * @author dubooooo@126.com 2018-04-10
 */

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Test01 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Timeline timeline;

    @Override
    public void start(Stage primaryStage) {
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(200), e -> {
            System.out.println(e);
        }));
        timeline.play();
        Circle circle = new Circle(0, 0, 30);
        Pane root = new Pane();
        root.setOnMouseMoved(e -> {
            //System.out.println(e);
            double x = e.getX();
            double y = e.getY();
            circle.setLayoutX(x);
            circle.setLayoutY(y);
        });
        root.getChildren().add(circle);
        Scene scene = new Scene(root, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public KeyFrame createFrames() {
        KeyFrame keyFrame = new KeyFrame(Duration.millis(200), e -> {
            System.out.println(e);
        });
        return keyFrame;
    }
}
