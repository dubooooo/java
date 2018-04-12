package cn.com.javafx.demo.shoot.test02;

import javafx.scene.image.Image;

/**
 * @author dubooooo@126.com 2018-04-12
 */
public class Hero extends SpriteImpl {

    Image[] images = new Image[6];
    Image image;
    int index = 0;
    double x;
    double y;

    public Hero() {
        for (int i = 0; i < images.length; i++) {
            images[i] = loadImage("demo/shoot/hero" + i + ".png");
        }
        image = (images[0]);
    }

    @Override
    public void init() {
        getApplication().addMouseMovedEvent(event -> {
            x = event.getX() - getWidth() / 2;
            y = event.getY() - getHeight() / 2;
            if (y > event.getY() / 2) {
                getApplication().pause();
            }
            if (y < event.getY() / 2) {
                getApplication().restart();
            }
        });
        timeline(200, e -> {
            int i = index++ % 6;
            //image = images[index++ % 2];
            image = (images[i]);
            //image.set(images[i]);
        });
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public void after() {

    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getWidth() {
        return image.getWidth();
    }

    @Override
    public double getHeight() {
        return image.getHeight();
    }

}
