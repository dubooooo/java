package cn.com.javafx.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author dubooooo@126.com 2018-04-17
 */
@Component
public class ApplicationContext implements ApplicationContextAware {

    public static org.springframework.context.ApplicationContext me;

    @Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws BeansException {
        me = applicationContext;
    }
}
