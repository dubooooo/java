package cn.com.javafx.demo.test01;/**
 * @author dubooooo@126.com 2018-04-09
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        stage.setScene(scene);
        stage.show();
        Button button = new Button("button");
        button.setOnAction(e -> {
            Stage stage1 = new Stage();
            Scene scene01 = new Scene(new Button("button01"), 800, 600);
            stage1.setScene(scene01);
            stage1.show();
        });
        group.getChildren().add(button);
    }
}
