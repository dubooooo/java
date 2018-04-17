package cn.com.javafx.demo.cleanmaven;/**
 * @author dubooooo@126.com 2018-04-17
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CleanMaven extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Thread.currentThread().getContextClassLoader().getResource("demo/fxml/cleanmaven.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
