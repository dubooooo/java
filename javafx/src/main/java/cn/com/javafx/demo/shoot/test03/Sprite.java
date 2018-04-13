package cn.com.javafx.demo.shoot.test03;

import javafx.scene.canvas.GraphicsContext;

/**
 * @author dubooooo@126.com 2018-04-12
 */
public interface Sprite {

    public void init(GraphicsApplication application);

    public void before();

    public void draw(GraphicsContext gc);

    public void after();

}
