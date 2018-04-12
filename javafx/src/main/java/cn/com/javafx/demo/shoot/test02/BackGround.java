package cn.com.javafx.demo.shoot.test02;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * @author dubooooo@126.com 2018-04-12
 */
public class BackGround extends SpriteImpl {

    Image image;
    double y01 = -Constant.HEIGHT;
    double y02 = 0;

    @Override
    public void init() {
        super.init();
        image = new Image("demo/shoot/background.png");
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.fillRect(0, 0, Constant.WIDTH, Constant.HEIGHT);
        gc.drawImage(image, 0, y01);
        gc.drawImage(image, 0, y02);
    }

    @Override
    public void after() {
        y01 += 0.1;
        y02 += 0.1;
        if (y01 >= 0) {
            y01 = -Constant.HEIGHT;
            y02 = 0;
        }
    }

    @Override
    public double getX() {
        return 0;
    }

    @Override
    public double getY() {
        return 0;
    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    @Override
    public Image getImage() {
        return null;
    }
}
