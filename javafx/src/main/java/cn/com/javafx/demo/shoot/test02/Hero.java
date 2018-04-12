package cn.com.javafx.demo.shoot.test02;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * @author dubooooo@126.com 2018-04-12
 */
public class Hero extends SpriteImpl {

    Image[] images = new Image[2];
    double x;
    double y;

    public Hero() {
        images[0] = new Image("demo/shoot/hero0.png");
        images[1] = new Image("demo/shoot/hero1.png");
    }

    public void init() {
        getApplication().addMouseMovedEvent(event -> {
            x = event.getX();
            y = event.getY();
        });
    }

    @Override
    public void before() {

    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(getImage(), x, y);
    }

    int index = 0;

    private Image getImage() {
        return images[index++ % 2];
    }

    @Override
    public void after() {

    }

}
