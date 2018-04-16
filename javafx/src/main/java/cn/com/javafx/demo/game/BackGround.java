package cn.com.javafx.demo.game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * @author dubooooo@126.com 2018-04-16
 */
public class BackGround extends Sprite {

    public BackGround(Image img) {
        super(img);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(img.get(), dx.get(), dy.get() - sh.get());
        gc.drawImage(img.get(), dx.get(), dy.get());
    }

    @Override
    public void update() {
        if (dy.get() - sh.get() >= 0) {
            dy.set(0);
        }
        move(0, 0.3);
    }
}
