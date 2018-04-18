package cn.com.javafx;

import cn.com.javafx.demo.stage.Game01;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author dubooooo@126.com 2018-03-30
 */
@SpringBootApplication
public class JavafxApplication extends Application implements ApplicationContextAware {

    private static ApplicationContext AC;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        SpringApplication.run(JavafxApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        applicationContext().getBean(Game01.class).show();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        JavafxApplication.AC = applicationContext;
    }

    public static ApplicationContext applicationContext() throws BeansException {
        return AC;
    }
}
