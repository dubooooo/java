package cn.com.javafx.demo.shoot.test04;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * @author dubooooo@126.com 2018-04-16
 */
public class GameAction implements Action {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    private List<Sprite> sprites = new LinkedList<>();
    private Image image = new Image("img/actor.png");
    private int time = 100;

    @Override
    public void init(Root root) {
        sprites.add(new Sprite(image, 0, 0, 35, 35));
        root.setTime(time);
        for (Sprite sprite : sprites) {
            sprite.bind(root.getGraphicsContext2D());
        }
    }

    @Override
    public void action(GraphicsContext gc) {
        before();
        draw(gc);
        after();
    }

    public void before() {
    }

    public void draw(GraphicsContext gc) {
        for (Sprite sprite : sprites) {
            sprite.before();
            //sprite.draw(gc);
            sprite.after();
        }
    }

    public void after() {
        for (Sprite sprite : sprites) {
            sprite.moveX(sprite.getSw());
            sprite.moveY(sprite.getSh());
        }
    }
}
