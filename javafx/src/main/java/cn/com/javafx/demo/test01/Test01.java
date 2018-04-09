package cn.com.javafx.demo.test01;/**
 * @author dubooooo@126.com 2018-04-09
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test01 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Group group = new Group();

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(group, 800, 600);
        stage.setResizable(false);
        stage.show();
        new Thread(new GroupRunnable(group)).start();
    }
}
