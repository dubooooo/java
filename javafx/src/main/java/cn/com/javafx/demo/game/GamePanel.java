package cn.com.javafx.demo.game;

import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * @author dubooooo@126.com 2018-03-30
 */
public class GamePanel extends Parent {

    private Sprite sprite;

    public GamePanel() {
    }

    public void init() {
        this.sprite = new Sprite(50, 50, 32, 32, "img/actor.png");
        getChildren().add(this.sprite);
        getScene().setOnKeyPressed(event -> onKeyPressed(event));
        getScene().setOnMouseMoved(event -> onMouseMoved(event));
    }

    public void onMouseMoved(MouseEvent event) {
        System.out.println(event);
    }

    public void onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.LEFT) {
            this.sprite.moveLeft();
        } else if (event.getCode() == KeyCode.RIGHT) {
            this.sprite.moveRight();
        } else if (event.getCode() == KeyCode.UP) {
            this.sprite.moveUp();
        } else if (event.getCode() == KeyCode.DOWN) {
            this.sprite.moveDown();
        }
    }

    public void update(long now) {

    }
}
