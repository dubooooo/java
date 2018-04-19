package cn.com.javafx.common;

import javafx.scene.canvas.GraphicsContext;

/**
 * @author dubooooo@126.com 2018-04-19
 */
public interface Action {

    void init();

    void draw(GraphicsContext gc);

    void update();
}
