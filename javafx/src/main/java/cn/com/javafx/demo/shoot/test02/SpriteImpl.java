package cn.com.javafx.demo.shoot.test02;

import javafx.scene.canvas.GraphicsContext;

/**
 * @author dubooooo@126.com 2018-04-12
 */
public abstract class SpriteImpl implements Sprite {

    private GraphicsApplication application;

    @Override
    final public void init(GraphicsApplication application) {
        this.application = application;
        init();
    }

    protected void init() {
    }

    @Override
    public void before() {
    }

    public void draw(GraphicsContext gc) {
    }

    @Override
    public void after() {
    }

    public GraphicsApplication getApplication() {
        return application;
    }

    public void setApplication(GraphicsApplication application) {
        this.application = application;
    }
}
