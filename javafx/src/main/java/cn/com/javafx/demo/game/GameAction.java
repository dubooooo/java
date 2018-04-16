package cn.com.javafx.demo.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * @author dubooooo@126.com 2018-04-16
 */
public class GameAction implements Game.Action {

    private BackGround backGround = new BackGround(new Image("demo/shoot/background.png"));
    private Hero hero = new Hero();

    @Override
    public void init(Game game) {
        backGround.bind(game.getGraphicsContext());
        game.getRoot().setOnMouseMoved(e -> hero.move(e.getX(), e.getY()));
    }

    @Override
    public void action(GraphicsContext gc) {
        hero.draw(gc);
        hero.update();
        //backGround.update();
    }

}
