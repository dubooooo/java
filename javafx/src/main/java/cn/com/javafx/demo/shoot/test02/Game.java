package cn.com.javafx.demo.shoot.test02;/**
 * @author dubooooo@126.com 2018-04-12
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GraphicsApplication application = new GraphicsApplication(Constant.WIDTH, Constant.HEIGHT);
        primaryStage.setScene(new Scene(new Pane(application), Constant.WIDTH, Constant.HEIGHT, Color.BLACK));
        primaryStage.show();
        application.init();
        application.getTimeline().play();
        application.addSprite(new BackGround(), new Hero());
    }
}
