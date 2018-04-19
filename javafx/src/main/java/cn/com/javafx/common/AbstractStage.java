package cn.com.javafx.common;

import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.annotation.PostConstruct;

/**
 * @author dubooooo@126.com 2018-04-19
 */
public abstract class AbstractStage extends Stage {

    final static private Image ICON = new Image("img/javafx-icon.jpg");

    public AbstractStage() {
        getIcons().add(ICON);
    }

    @PostConstruct
    public abstract void init();

}
