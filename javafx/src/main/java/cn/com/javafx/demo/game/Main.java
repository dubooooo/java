package cn.com.javafx.demo.game;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author dubooooo@126.com 2018-03-30
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        new Game(new GameAction(), 450, 700);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
