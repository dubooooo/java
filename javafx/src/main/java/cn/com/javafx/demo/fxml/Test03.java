package cn.com.javafx.demo.fxml;

import cn.com.javafx.common.AbstractStage;
import org.springframework.stereotype.Component;

/**
 * @author dubooooo@126.com 2018-04-19
 */
@Component
public class Test03 extends AbstractStage {

    @Override
    public void init() {
        System.out.println("success");
    }

}
