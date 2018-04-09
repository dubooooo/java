package cn.com.javafx.demo.game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author dubooooo@126.com 2018-03-30
 */
public class Game extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GamePanel mPanel = new GamePanel();
        final Scene scene = new Scene(mPanel, 800, 600);
        mPanel.load();
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.setTitle("Game");
        stage.show();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        launch(Game.class, args);
    }
}
