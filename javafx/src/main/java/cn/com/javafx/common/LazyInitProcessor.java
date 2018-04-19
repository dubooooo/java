package cn.com.javafx.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author dubooooo@126.com 2018-04-19
 */
@Component
public class LazyInitProcessor implements BeanFactoryPostProcessor {

    final static private Logger log = LoggerFactory.getLogger(LazyInitProcessor.class);

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Arrays.stream(beanFactory.getBeanDefinitionNames()).forEach(e -> {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(e);
            beanDefinition.setLazyInit(true);
            log.info(beanDefinition.toString());
        });
        Arrays.stream(beanFactory.getBeanNamesForAnnotation(SpringBootApplication.class)).forEach(e -> {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(e);
            beanDefinition.setLazyInit(false);
            log.info(beanDefinition.toString());
        });
    }
}
