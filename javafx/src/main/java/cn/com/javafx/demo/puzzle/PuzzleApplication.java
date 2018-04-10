package cn.com.javafx.demo.puzzle;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author dubooooo@126.com 2018-03-30
 */
@Component
public class PuzzleApplication extends Application {

    public static void main(String[] args) {
        new PuzzleApplication().app();
    }

    @PostConstruct
    public void app() {
        Application.launch(null);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(this.createParent()));
        stage.show();
    }

    private Parent createParent() {
        return new VBox();
    }
}
