package cn.com.javafx.demo.game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dubooooo@126.com 2018-03-30
 */
public class Game {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    DoubleProperty widthProperty = new SimpleDoubleProperty(0);
    DoubleProperty heightProperty = new SimpleDoubleProperty(0);
    DoubleProperty timeProperty = new SimpleDoubleProperty(1);
    private Canvas canvas = new Canvas();
    private Parent root = new Pane(canvas);
    private Scene scene;
    private Stage stage = new Stage();
    private Timeline timeline = new Timeline();
    private Action action;

    public Game(Action action, double width, double height) {
        scene = new Scene(root, width, height);
        stage.setScene(scene);
        stage.show();
        widthProperty.set(width);
        heightProperty.set(height);
        canvas.widthProperty().bindBidirectional(widthProperty);
        canvas.heightProperty().bindBidirectional(heightProperty);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(timeProperty.get()), e -> cycle()));
        timeline.play();
        this.action = action;
        action.init(this);
    }

    public GraphicsContext getGraphicsContext() {
        return canvas.getGraphicsContext2D();
    }

    public Parent getRoot() {
        return root;
    }

    public void cycle() {
        System.out.println(dateFormat.format(new Date()));
        action.action(canvas.getGraphicsContext2D());
    }

    public static interface Action {

        void init(Game game);

        void action(GraphicsContext gc);
    }

}
