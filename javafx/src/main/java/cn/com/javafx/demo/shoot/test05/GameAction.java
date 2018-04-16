package cn.com.javafx.demo.shoot.test05;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * @author dubooooo@126.com 2018-04-16
 */
public class GameAction implements Game.Action {

    private BackGround backGround = new BackGround(new Image("demo/shoot/background.png"));

    @Override
    public void init(GraphicsContext gc) {
        backGround.bind(gc);
    }

    @Override
    public void action(GraphicsContext gc) {
        backGround.update();
    }

}
