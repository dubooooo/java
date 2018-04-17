package cn.com.javafx.demo.stage;

import cn.com.javafx.common.JavafxUtil;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author dubooooo@126.com 2018-04-17
 */
@Component
@Lazy
public class StageTest01 extends Stage {

    @Value("${stage.width}")
    private double width;
    @Value("${stage.height}")
    private double height;

    private Pane root;
    private Canvas canvas;

    @PostConstruct
    public void init() {
        canvas = new Canvas(width, height);
        root = JavafxUtil.load("demo/fxml/StageTest01.fxml");
        root.getChildren().add(canvas);
        setScene(new Scene(root));
    }

}
