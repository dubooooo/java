package cn.com.javafx;

import cn.com.javafx.common.Javafx;
import cn.com.javafx.demo.stage.StageTest01;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dubooooo@126.com 2018-03-30
 */
@SpringBootApplication
public class JavafxApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavafxApplication.class, args);
        Javafx.launch(StageTest01.class);
    }

}
