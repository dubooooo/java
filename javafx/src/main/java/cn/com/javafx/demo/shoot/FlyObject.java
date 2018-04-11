package cn.com.javafx.demo.shoot;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author dubooooo@126.com 2018-04-11
 */
public abstract class FlyObject extends Parent {

    private int img_x;
    private int img_y;
    private int weigth;
    private int height;
    private ImageView imageView;

    DoubleProperty x = new SimpleDoubleProperty();
    DoubleProperty y = new SimpleDoubleProperty();

    public FlyObject(String imageUrl) {
        this(new Image(imageUrl));
    }

    private FlyObject(Image image) {
        this(0, 0, (int) image.getWidth(), (int) image.getHeight(), image);
    }

    public FlyObject(int img_x, int img_y, int weigth, int height, Image image) {
        try {
            this.img_x = img_x;
            this.img_y = img_y;
            this.weigth = weigth;
            this.height = height;
            this.imageView = new ImageView(image);
            this.imageView.setViewport(new Rectangle2D(img_x, img_y, weigth, height));
            this.layoutXProperty().bindBidirectional(this.x);
            this.layoutYProperty().bindBidirectional(this.y);
            getChildren().add(this.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FlyObject move(double x, double y) {
        moveX(x);
        moveY(y);
        return this;
    }

    public FlyObject moveX(double x) {
        this.x.set(getX() + x);
        return this;
    }

    public FlyObject moveY(double y) {
        this.y.set(getY() + y);
        return this;
    }

    public double getX() {
        return this.x.get();
    }

    public FlyObject setX(double x) {
        this.x.set(x);
        return this;
    }

    public double getY() {
        return this.y.get();
    }

    public FlyObject setY(double y) {
        this.y.set(y);
        return this;
    }
}
