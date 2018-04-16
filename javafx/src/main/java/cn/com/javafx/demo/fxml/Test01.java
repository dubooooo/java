package cn.com.javafx.demo.fxml;

import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author dubooooo@126.com 2018-04-16
 */
public class Test01 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public static ObjectProperty<Parent> parentProperty = new SimpleObjectProperty<>();
    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = FXMLLoader.load(Thread.currentThread().getContextClassLoader().getResource("demo/fxml/test01.fxml"));
        parentProperty.set(pane);
        Scene scene = new Scene(pane);
        scene.rootProperty().bindBidirectional(parentProperty);
        stage.setScene(scene);
        stage.show();
        Test01.stage = stage;
    }
}
