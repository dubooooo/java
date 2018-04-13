package cn.com.javafx.demo.shoot.test04;

import javafx.scene.image.Image;

/**
 * @author dubooooo@126.com 2018-04-13
 */
public class Sprite {

    private double sx;
    private double sy;
    private double sw;
    private double sh;
    private double dx;
    private double dy;
    private double dw;
    private double dh;
    private Image img;

    public Sprite(Image img) {
        this.img = img;
    }

    public Sprite(Image img, double sx, double sy, double sw, double sh, double dx, double dy, double dw, double dh) {
        this.img = img;
        this.sx = sx;
        this.sy = sy;
        this.sw = sw;
        this.sh = sh;
        this.dx = dx;
        this.dy = dy;
        this.dw = dw;
        this.dh = dh;
    }

    public double getSx() {
        return sx;
    }

    public void setSx(double sx) {
        this.sx = sx;
    }

    public double getSy() {
        return sy;
    }

    public void setSy(double sy) {
        this.sy = sy;
    }

    public double getSw() {
        return sw;
    }

    public void setSw(double sw) {
        this.sw = sw;
    }

    public double getSh() {
        return sh;
    }

    public void setSh(double sh) {
        this.sh = sh;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public double getDw() {
        return dw;
    }

    public void setDw(double dw) {
        this.dw = dw;
    }

    public double getDh() {
        return dh;
    }

    public void setDh(double dh) {
        this.dh = dh;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}
