package cn.com.javafx.demo.fxml;

import cn.com.javafx.common.AbstractStage;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;

/**
 * @author dubooooo@126.com 2018-04-19
 */
public class WebView extends AbstractStage {

    private javafx.scene.web.WebView webView;
    private WebEngine webEngine;

    @Override
    public void init() {
        System.out.println("init");
        webView = new javafx.scene.web.WebView();
        webEngine = webView.getEngine();
        webEngine.load("https://www.baidu.com");
        this.setScene(new Scene(webView, 800, 600));
    }

}
