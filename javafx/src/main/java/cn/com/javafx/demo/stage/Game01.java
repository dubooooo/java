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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import javax.annotation.PostConstruct;

/**
 * @author dubooooo@126.com 2018-04-17
 */
@JavaFX
public class Game01 extends Windows {

    private double width = 600;
    private double height = 450;

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
        scene.setOnKeyPressed(e -> keyPressed(e));
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

    public void keyPressed(KeyEvent e) {
        character.keyPressed(e);
    }

    public void characterAction() {
        character.draw(gc);
    }

    public void backGroundAction() {
        //gc.clearRect(0, 0, width, height);
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

    private int index;
    private int speed = 4;

    final private int up = 0;
    final private int down = 1;
    final private int left = 2;
    final private int right = 3;
    private int direction = 0;

    public Character(Image img, double sx, double sy, double sw, double sh) {
        super(img, sx, sy, sw, sh);
        dx().set(300);
        dy().set(300);
    }

    @Override
    public void draw(GraphicsContext gc) {
        super.draw(gc);
    }

    @Override
    public void update() {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getCode()) {
            case W:
                moveUp();
                break;
            case S:
                moveDown();
                break;
            case A:
                moveLeft();
                break;
            case D:
                moveRight();
                break;
        }
    }

    @Override
    public void moveUp() {
        checkDirection(up);
        sy().set(3 * sh().get());
        sx().set(index++ / speed % 3 * sw().get());
        dy().set(dy().get() - speed);
    }

    @Override
    public void moveDown() {
        checkDirection(down);
        sy().set(0 * sh().get());
        sx().set(index++ / speed % 3 * sw().get());
        dy().set(dy().get() + speed);
    }

    @Override
    public void moveLeft() {
        checkDirection(left);
        sy().set(1 * sh().get());
        sx().set(index++ / speed % 3 * sw().get());
        dx().set(dx().get() - speed);
    }

    @Override
    public void moveRight() {
        checkDirection(right);
        sy().set(2 * sh().get());
        sx().set(index++ / speed % 3 * sw().get());
        dx().set(dx().get() + speed);
    }

    public void checkDirection(int newDirection) {
        if (direction != newDirection) {
            sy().set(0);
            sx().set(0);
        }
        direction = newDirection;
    }
}