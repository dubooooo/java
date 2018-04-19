package cn.com.javafx.demo.stage;

import cn.com.javafx.common.GameFrameWork;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.springframework.stereotype.Component;

/**
 * @author dubooooo@126.com 2018-04-17
 */
@Component
public class Game02 extends GameFrameWork {

    private double width = 600;
    private double height = 450;

    private Scene scene;
    private Pane root;
    private Canvas canvas;
    private GraphicsContext gc;
    private Timeline timeline;

    private double mouse_x;
    private double mouse_y;

    private Image background;
    private Image actor;
    private Character character;

    @Override
    public void init() {
        initStage();
        initResource();
        start();
    }

    public void start() {
        drawThreadStart(60);
        updateThreadStart(60000);
    }

    public void initStage() {
        root = new Pane();
        canvas = new Canvas(width, height);
        root.getChildren().add(canvas);
        scene = new Scene(root);
        setScene(scene);
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.rgb(255, 255, 255));
        scene.setOnMouseMoved(e -> {
            mouse_x = e.getX();
            mouse_y = e.getY();
        });
        scene.setOnKeyPressed(e -> keyPressed(e));
        setResizable(false);
    }

    public void initResource() {
        background = new Image("img/background.jpg");
        actor = new Image("img/actor.png");
        character = new Character(actor, 0, 0, 35, 35);
    }

    public void keyPressed(KeyEvent e) {
        character.keyPressed(e);
    }

    @Override
    public void draw() {
        gc.drawImage(background, 0, 0, background.getWidth(), background.getHeight(), 0, 0, width, height);
        character.draw(gc);
        gc.fillText("drawfps : " + drawfps() + " updatefps : " + updatefps() + " X : " + mouse_x + " Y : " + mouse_y, 0, 20);
    }

    @Override
    protected void update() {

    }
}

