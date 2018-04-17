package cn.com.javafx.common;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author dubooooo@126.com 2018-04-17
 */
public class Javafx extends Application {

    private static Class<? extends Stage> stageClass;

    public static void launch(Class<? extends Stage> stageClass) {
        Javafx.stageClass = stageClass;
        launch(Javafx.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ((Stage) ApplicationContext.me.getBean(stageClass)).show();
    }

}
