package cn.com.javafx.demo.stage;

import cn.com.javafx.common.JavaFX;
import cn.com.javafx.common.Sprite;
import cn.com.javafx.common.Windows;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

/**
 * @author dubooooo@126.com 2018-04-17
 */
@JavaFX
public class Game01 extends Windows {

    @Value("${stage.width}")
    private double width;
    @Value("${stage.height}")
    private double height;

    private Scene scene;
    private Pane root;
    private Canvas canvas;
    private GraphicsContext gc;
    private Timeline timeline;

    private double mouse_x;
    private double mouse_y;
    private double startTime;
    private double totalFPS;

    private Image background;
    private Image actor;
    private Character character;

    @PostConstruct
    public void init() {
        initStage();
        initResource();
    }

    public void initStage() {
        startTime = System.currentTimeMillis();
        root = new Pane();
        canvas = new Canvas(width, height);
        root.getChildren().add(canvas);
        scene = new Scene(root);
        setScene(scene);
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.rgb(255, 255, 255));
        timeline = timeline(10);
        scene.setOnMouseMoved(e -> {
            mouse_x = e.getX();
            mouse_y = e.getY();
        });
        setResizable(false);
    }

    public void initResource() {
        background = new Image("img/background.jpg");
        actor = new Image("img/actor.png");
        character = new Character(actor, 0, 0, 35, 35);
    }

    @Override
    public void action(ActionEvent e) {
        backGroundAction();
        characterAction();
        infoAction();
    }

    public void characterAction() {
        character.moveTo(mouse_x, mouse_y);
        character.draw(gc);
    }

    public void backGroundAction() {
        gc.clearRect(0, 0, width, height);
        gc.drawImage(background, 0, 0, background.getWidth(), background.getHeight(), 0, 0, width, height);
    }

    public void infoAction() {
        gc.fillText("FPS : " + fps() + " X : " + mouse_x + " Y : " + mouse_y, 0, 20);
    }

    public double fps() {
        totalFPS++;
        return totalFPS / (System.currentTimeMillis() - startTime) * 1000;
    }

}

class Character extends Sprite {

    public Character(Image img, double sx, double sy, double sw, double sh) {
        super(img, sx, sy, sw, sh);
    }

    @Override
    public void update() {

    }
}