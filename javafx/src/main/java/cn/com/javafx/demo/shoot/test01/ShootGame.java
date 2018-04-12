package cn.com.javafx.demo.shoot.test01;/**
 * @author dubooooo@126.com 2018-04-11
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ShootGame extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ShootPanel shootPanel = new ShootPanel();
        primaryStage.setScene(new Scene(shootPanel, GameConstant.windows_weight, GameConstant.windows_height));
        primaryStage.setResizable(false);
        primaryStage.show();
        shootPanel.start();
    }
}
