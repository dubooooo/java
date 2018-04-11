package cn.com.javafx.demo.shoot;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author dubooooo@126.com 2018-04-11
 */
public abstract class FlyObject extends Parent {

    private int imgX;
    private int imgY;
    private int imgWeigth;
    private int imgHeight;
    private ImageView imageView;

    private DoubleProperty x = new SimpleDoubleProperty();
    private DoubleProperty y = new SimpleDoubleProperty();
    private ObjectProperty<Image> imgProperty = new SimpleObjectProperty();
    private ObjectProperty<Rectangle2D> rectangle2DProperty = new SimpleObjectProperty();

    public FlyObject(String imageUrl) {
        this(new Image(imageUrl));
    }

    private FlyObject(Image image) {
        this(0, 0, (int) image.getWidth(), (int) image.getHeight(), image);
    }

    private FlyObject(int imgX, int imgY, int imgWeigth, int imgHeight, Image image) {
        try {
            this.imgX = imgX;
            this.imgY = imgY;
            this.imgWeigth = imgWeigth;
            this.imgHeight = imgHeight;
            this.imgProperty.set(image);
            this.imageView = new ImageView(image);
            imageView.imageProperty().bindBidirectional(imgProperty);
            imageView.viewportProperty().bindBidirectional(rectangle2DProperty);
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

    public int getImgWeigth() {
        return imgWeigth;
    }

    public void setImgWeigth(int imgWeigth) {
        this.imgWeigth = imgWeigth;
    }

    public int getImgHeight() {
        return imgHeight;
    }

    public void setImgHeight(int imgHeight) {
        this.imgHeight = imgHeight;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public void setImage(Image image) {
        this.imgProperty.set(image);
    }

    public Rectangle2D getRectangle2D() {
        return rectangle2DProperty.get();
    }

    public void setRectangle2D(int imgX, int imgY, int imgWeigth, int imgHeight) {
        this.rectangle2DProperty.set(new Rectangle2D(imgX, imgY, imgWeigth, imgHeight));
    }
}
