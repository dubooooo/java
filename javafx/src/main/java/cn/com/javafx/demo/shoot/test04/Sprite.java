package cn.com.javafx.demo.shoot.test04;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

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

    public void bind(GraphicsContext context) {
        gc.set(context);
        img.addListener(e -> {
            draw(gc.get());
        });
        sx.addListener(e -> {
            draw(gc.get());
        });
        sy.addListener(e -> {
            draw(gc.get());
        });
        sw.addListener(e -> {
            draw(gc.get());
        });
        sh.addListener(e -> {
            draw(gc.get());
        });
        dx.addListener(e -> {
            draw(gc.get());
        });
        dy.addListener(e -> {
            draw(gc.get());
        });
        dw.addListener(e -> {
            draw(gc.get());
        });
        dy.addListener(e -> {
            draw(gc.get());
        });
    }

    public void before() {
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(getImg(), getSx(), getSy(), getSw(), getSh(), getDx(), getDy(), getDw(), getDh());
    }

    public void after() {
    }

    public void moveX(double x) {
        setDx(getDx() + x);
    }

    public void moveY(double y) {
        setDy(getDy() + y);
    }

    public double getSx() {
        return sx.get();
    }

    public void setSx(double sx) {
        this.sx.set(sx);
    }

    public double getSy() {
        return sy.get();
    }

    public void setSy(double sy) {
        this.sy.set(sy);
    }

    public double getSw() {
        return sw.get();
    }

    public void setSw(double sw) {
        this.sw.set(sw);
    }

    public double getSh() {
        return sh.get();
    }

    public void setSh(double sh) {
        this.sh.set(sh);
    }

    public double getDx() {
        return dx.get();
    }

    public void setDx(double dx) {
        this.dx.set(dx);
    }

    public double getDy() {
        return dy.get();
    }

    public void setDy(double dy) {
        this.dy.set(dy);
    }

    public double getDw() {
        return dw.get();
    }

    public void setDw(double dw) {
        this.dw.set(dw);
    }

    public double getDh() {
        return dh.get();
    }

    public void setDh(double dh) {
        this.dh.set(dh);
    }

    public Image getImg() {
        return img.get();
    }

    public void setImg(Image img) {
        this.img.set(img);
    }
}
