package cn.com.javafx.demo.game;

import javafx.beans.InvalidationListener;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.stream.Stream;

/**
 * @author dubooooo@126.com 2018-04-13
 */
public abstract class Sprite {

    public DoubleProperty sx, sy, sw, sh, dx, dy, dw, dh;
    public ObjectProperty<Image> img;
    public ObjectProperty<GraphicsContext> gc = new SimpleObjectProperty();

    public Sprite(Image img) {
        this(img, 0, 0, img.getWidth(), img.getHeight(), 0, 0, img.getWidth(), img.getHeight());
    }

    public Sprite(Image img, double sx, double sy, double sw, double sh) {
        this(img, 0, 0, sw, sh, 0, 0, sw, sh);
    }

    public Sprite(Image img, double sx, double sy, double sw, double sh, double dx, double dy, double dw, double dh) {
        this.img = new SimpleObjectProperty(img);
        this.sx = new SimpleDoubleProperty(sx);
        this.sy = new SimpleDoubleProperty(sy);
        this.sw = new SimpleDoubleProperty(sw);
        this.sh = new SimpleDoubleProperty(sh);
        this.dx = new SimpleDoubleProperty(dx);
        this.dy = new SimpleDoubleProperty(dy);
        this.dw = new SimpleDoubleProperty(dw);
        this.dh = new SimpleDoubleProperty(dh);
    }

    public void bind(GraphicsContext gc) {
        this.gc.addListener(e -> {
            addlistener(listener -> {
                draw(this.gc.get());
            });
        });
        this.gc.set(gc);
    }

    public void addlistener(InvalidationListener listener) {
        Stream.of(img, sx, sy, sw, sh, dx, dy, dw, dh).forEach(e -> e.addListener(listener));
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(img.get(), sx.get(), sy.get(), sw.get(), sh.get(), dx.get(), dy.get(), dw.get(), dh.get());
    }

    public abstract void update();

    public void move(double x, double y) {
        if (x != 0) {
            dx.set(dx.get() + x);
        }
        if (y != 0) {
            dy.set(dy.get() + y);
        }
    }

    @Override
    public String toString() {
        return "Sprite{" + "img=" + img.get() + ", sx=" + sx.get() + ", sy=" + sy.get() + ", sw=" + sw.get() + ", sh=" + sh.get() + ", dx=" + dx.get() + ", dy=" + dy.get() + ", dw=" + dw.get() + ", dh=" + dh.get() + ", gc=" + gc.get() + '}';
    }
}
