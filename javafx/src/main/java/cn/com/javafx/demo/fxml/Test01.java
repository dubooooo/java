package cn.com.javafx.demo.fxml;

import cn.com.javafx.common.JavafxUtil;
import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author dubooooo@126.com 2018-04-16
 */
public class Test01 extends Application {

    public static Test01 me;

    public static void main(String[] args) {
        Test01 test02 = new Test01();
        test02.launch(args);
        System.out.println(test02);
    }

    public static ObjectProperty<Parent> parentProperty = new SimpleObjectProperty<>();
    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        me = this;
        System.out.println(me);
        Pane pane = JavafxUtil.load("demo/fxml/test01.fxml");
        parentProperty.set(pane);
        Scene scene = new Scene(pane);
        scene.rootProperty().bindBidirectional(parentProperty);
        stage.setScene(scene);
        stage.show();
        Test01.stage = stage;
        //ScenicView.show(scene);
    }
}
