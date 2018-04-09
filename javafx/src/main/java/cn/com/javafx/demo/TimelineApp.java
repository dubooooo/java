package cn.com.javafx.demo;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author dubooooo@126.com 2018-03-30
 */
public class TimelineApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Timeline timeline = new Timeline();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(this.parent()));
        primaryStage.show();
    }

    private Parent parent() {
        Pane pane = new Pane();
        pane.setPrefSize(300, 100);

        Circle circle = new Circle(25, 25, 20, Color.web("1c89f4"));
        circle.setEffect(new Lighting());

        this.timeline.setCycleCount(Timeline.INDEFINITE);
        this.timeline.setAutoReverse(true);
        this.timeline.getKeyFrames().addAll(new KeyFrame(Duration.ZERO, new KeyValue(circle.translateXProperty(), 0)), new KeyFrame(new Duration(4000), new KeyValue(circle.translateXProperty(), 205)));

        pane.getChildren().addAll(this.createNavigation(), circle);

        return pane;
    }

    private VBox createNavigation() {
        Button buttonStart = new Button("Start");
        buttonStart.setOnAction(event -> this.timeline.play());
        return null;
    }
}
