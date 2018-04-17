package cn.com.javafx.demo.cleanmaven;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * @author dubooooo@126.com 2018-04-17
 */
public class CleanController {

    @FXML
    private Button clean_maven_button;

    public void clean_maven(ActionEvent event) {
        try {
            clean_maven_button.setDisable(true);

        } finally {
            clean_maven_button.setDisable(false);
        }
    }
}
