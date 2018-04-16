package cn.com.javafx.demo.shoot.test05;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author dubooooo@126.com 2018-03-30
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        new Game(450, 700);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
