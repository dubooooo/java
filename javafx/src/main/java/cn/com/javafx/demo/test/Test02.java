package cn.com.javafx.demo.test;/**
 * @author dubooooo@126.com 2018-04-11
 */

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Test02 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(0, 0, 30);
    }

    public void move(Node node) {
        node.setLayoutX(Math.random());
    }
}
