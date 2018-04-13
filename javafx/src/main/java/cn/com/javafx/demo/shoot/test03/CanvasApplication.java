package cn.com.javafx.demo.shoot.test03;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author dubooooo@126.com 2018-04-13
 */
public class CanvasApplication extends Canvas {

    public static void launch(Stage stage, String[] args) {
        stage.setScene(new Scene(new Pane(new CanvasApplication())));
    }

}
