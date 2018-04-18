package cn.com.javafx.demo.fxml;

import cn.com.javafx.JavafxApplication;
import cn.com.javafx.demo.stage.Game01;
import com.sun.deploy.uitoolkit.impl.fx.ui.FXMessageDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author dubooooo@126.com 2018-04-16
 */
public class Pane01 {

    @FXML
    private Button button01;
    private Parent parent;

    public void click(ActionEvent event) {
        System.out.println(button01);
        System.out.println(event);
        Test01.parentProperty.set(new Pane());
        Scene scene = new Scene(new Pane());
        Stage stage = new Stage();
        stage.setScene(scene);
        //stage.show();
        FXMessageDialog fxMessageDialog = new FXMessageDialog();
        JavafxApplication.applicationContext().getBean(Game01.class).hide();
    }
}
