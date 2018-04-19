package cn.com.demo.date_20180301.beanProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

/**
 * @author dubooooo@126.com 2018-03-26
 */
//@Component
public class DemoBeanFactoryProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Arrays.stream(beanFactory.getBeanNamesForAnnotation(ComponentScan.class)).forEach(System.out::println);
    }
}
