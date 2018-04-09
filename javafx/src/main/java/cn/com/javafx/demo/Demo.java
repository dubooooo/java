package cn.com.javafx.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author dubooooo@126.com 2018-03-30
 */
public class Demo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private FXMLLoader loader = new FXMLLoader();
    private Resource fxml = new ClassPathResource("demo/demo.fxml");

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(this.loader.load(this.fxml.getInputStream())));
        primaryStage.show();
    }
}
