package cn.com.javafx.demo.test;/**
 * @author dubooooo@126.com 2018-04-10
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Test01 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ImageView image = new ImageView("https://csdnimg.cn/pubfooter/images/csdn_cs_qr.png");
        Circle circle = new Circle(0, 0, 30);
        //Group group = new Group();
        //group.setAutoSizeChildren(true);
        //group.getChildren().add(image);
        Pane pane = new Pane();
        pane.setOnMouseMoved(e -> {
            System.out.println(e);
            double x = e.getX();
            double y = e.getY();
            //image.setImage(new Image("https://www.baidu.com/s?usm=1&wd=padding&ie=utf-8&rsv_cq=img&rsv_dl=0_right_recommends_merge_21180&euri=ad2b700bab564200b516c012805915d8"));
            //image.setLayoutX(x);
            //image.setLayoutY(y);
            circle.setLayoutX(x);
            circle.setLayoutY(y);
        });
        pane.getChildren().add(circle);
        Scene scene = new Scene(pane, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
