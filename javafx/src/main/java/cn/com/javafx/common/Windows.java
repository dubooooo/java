package cn.com.javafx.common;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

/**
 * @author dubooooo@126.com 2018-04-18
 */
public class Windows extends Stage {

    public <T> T load(String url) {
        try {
            return FXMLLoader.load(Thread.currentThread().getContextClassLoader().getResource(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
