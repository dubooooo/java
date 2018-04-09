package cn.com.javafx.demo;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

/**
 * @author dubooooo@126.com 2018-03-30
 */
public class AccordionApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(this.create()));
        primaryStage.show();
    }

    private Parent create() {
        Accordion accordion = new Accordion();
        for (int i = 0; i < 10; i++) {
            accordion.getPanes().addAll(new TitledPane("title", new Button("press")), new TitledPane());
        }
        return accordion;
    }
}
