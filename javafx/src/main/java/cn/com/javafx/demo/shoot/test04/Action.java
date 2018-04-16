package cn.com.javafx.demo.shoot.test04;

import javafx.scene.canvas.GraphicsContext;

/**
 * @author dubooooo@126.com 2018-04-16
 */
public interface Action {

    void init(Root root);

    void action(GraphicsContext gc);

}
