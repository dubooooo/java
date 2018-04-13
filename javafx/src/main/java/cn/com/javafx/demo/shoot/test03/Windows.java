package cn.com.javafx.demo.shoot.test03;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author dubooooo@126.com 2018-04-13
 */
public class Windows {

    private ApplicationImpl application;
    private Stage stage;

    public Windows(ApplicationImpl application, Stage stage) {
        this.stage = stage;
        this.application = application;
    }

    public void start() {
        GraphicsApplication application = new GraphicsApplication(Constant.WIDTH, Constant.HEIGHT);
        stage.setScene(new Scene(new Pane(application), Constant.WIDTH, Constant.HEIGHT, Color.BLACK));
        stage.show();
        application.init();
        application.getTimeline().play();
        application.addSprite(new BackGround(), new Hero());
    }

}
