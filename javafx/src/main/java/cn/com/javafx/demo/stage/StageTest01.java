package cn.com.javafx.demo.stage;

import cn.com.javafx.common.JavaFX;
import cn.com.javafx.common.Windows;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

/**
 * @author dubooooo@126.com 2018-04-17
 */
@JavaFX
public class StageTest01 extends Windows {

    @Value("${stage.width}")
    private double width;
    @Value("${stage.height}")
    private double height;

    private Scene scene;
    private Pane root;
    private Canvas canvas;

    @PostConstruct
    public void init() {
        root = load("demo/fxml/StageTest01.fxml");
        canvas = new Canvas(width, height);
        root.getChildren().add(canvas);
        scene = new Scene(root);
        setScene(scene);
    }

}
