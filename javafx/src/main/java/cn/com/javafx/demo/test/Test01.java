package cn.com.javafx.demo.test;/**
 * @author dubooooo@126.com 2018-04-10
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Test01 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ImageView image = new ImageView("https://csdnimg.cn/pubfooter/images/csdn_cs_qr.png");
        //Group group = new Group();
        //group.setAutoSizeChildren(true);
        //group.getChildren().add(image);
        Pane pane = new Pane();
        pane.setOnMouseMoved(e -> {
            System.out.println(e);
            double x = e.getX();
            double y = e.getY();
            image.setLayoutX(x);
            image.setLayoutY(y);
        });
        pane.getChildren().add(image);
        Scene scene = new Scene(pane, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
