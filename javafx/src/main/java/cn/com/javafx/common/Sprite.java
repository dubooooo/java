package cn.com.javafx.common;

import javafx.beans.InvalidationListener;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

import java.util.stream.Stream;

/**
 * @author dubooooo@126.com 2018-04-13
 */
public class Sprite {

    private ObjectProperty<Image> img = new SimpleObjectProperty();
    private DoubleProperty sx = new SimpleDoubleProperty(0);
    private DoubleProperty sy = new SimpleDoubleProperty(0);
    private DoubleProperty sw = new SimpleDoubleProperty(0);
    private DoubleProperty sh = new SimpleDoubleProperty(0);
    private DoubleProperty dx = new SimpleDoubleProperty(0);
    private DoubleProperty dy = new SimpleDoubleProperty(0);
    private DoubleProperty dw = new SimpleDoubleProperty(0);
    private DoubleProperty dh = new SimpleDoubleProperty(0);

    private ObjectProperty<GraphicsContext> gc = new SimpleObjectProperty();

    public Sprite(Image img) {
        this(img, 0, 0, img.getWidth(), img.getHeight(), 0, 0, img.getWidth(), img.getHeight());
    }

    public Sprite(Image img, double sx, double sy, double sw, double sh) {
        this(img, 0, 0, sw, sh, 0, 0, sw, sh);
    }

    public Sprite(Image img, double sx, double sy, double sw, double sh, double dx, double dy, double dw, double dh) {
        this.img.set(img);
        this.sx.set(sx);
        this.sy.set(sy);
        this.sw.set(sw);
        this.sh.set(sh);
        this.dx.set(dx);
        this.dy.set(dy);
        this.dw.set(dw);
        this.dh.set(dh);
    }

    public void bind(GraphicsContext gc) {
        this.gc.addListener(e -> addlistener(listener -> draw(this.gc.get())));
        this.gc.set(gc);
    }

    public void addlistener(InvalidationListener listener) {
        Stream.of(img, sx, sy, sw, sh, dx, dy, dw, dh).forEach(e -> e.addListener(listener));
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(img().get(), sx().get(), sy().get(), sw().get(), sh().get(), dx().get(), dy().get(), dw().get(), dh().get());
    }

    public void update() {
    }

    public void keyPressed(KeyEvent e) {
        System.out.println(e);
        switch (e.getCode()) {
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
        }
    }

    public void moveLeft() {
    }

    public void moveRight() {
    }

    public void moveUp() {
    }

    public void moveDown() {
    }

    public void moveToXY(double x, double y) {
        dx().set(x);
        dy().set(y);
    }

    public void moveXY(double x, double y) {
        moveX(x);
        moveY(y);
    }

    public void moveX(double x) {
        dx.set(dx.get() + x);
    }

    public void moveY(double y) {
        dy.set(dy.get() + y);
    }

    public ObjectProperty<Image> img() {
        return img;
    }

    public DoubleProperty sx() {
        return sx;
    }

    public DoubleProperty sy() {
        return sy;
    }

    public DoubleProperty sw() {
        return sw;
    }

    public DoubleProperty sh() {
        return sh;
    }

    public DoubleProperty dx() {
        return dx;
    }

    public DoubleProperty dy() {
        return dy;
    }

    public DoubleProperty dw() {
        return dw;
    }

    public DoubleProperty dh() {
        return dh;
    }

    public ObjectProperty<GraphicsContext> gc() {
        return gc;
    }

    @Override
    public String toString() {
        return "Sprite{" + "img=" + img + ", sx=" + sx + ", sy=" + sy + ", sw=" + sw + ", sh=" + sh + ", dx=" + dx + ", dy=" + dy + ", dw=" + dw + ", dh=" + dh + ", gc=" + gc + '}';
    }
}
