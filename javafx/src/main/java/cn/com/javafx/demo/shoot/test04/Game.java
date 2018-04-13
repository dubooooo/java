package cn.com.javafx.demo.shoot.test04;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author dubooooo@126.com 2018-04-13
 */
public class Game extends Application {

    public static double WIDTH = 600;
    public static double HEIGHT = 450;

    public static void main(String[] args) {
        launch(args);
    }

    private CanvasImpl canvas = new CanvasImpl();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(new Pane(canvas), WIDTH, HEIGHT, Color.BLACK));
        stage.setResizable(false);
        stage.show();
        canvas.start(WIDTH, HEIGHT);
    }
}
