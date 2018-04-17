package cn.com.javafx.common;

import javafx.fxml.FXMLLoader;

/**
 * @author dubooooo@126.com 2018-04-17
 */
public class JavafxUtil {

    public static <T> T load(String url) {
        try {
            return FXMLLoader.load(Thread.currentThread().getContextClassLoader().getResource(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
