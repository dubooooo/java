package cn.com.demo.date_20180301.beanProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author dubooooo@126.com 2018-03-16
 */
//@Order(0)
//@Component
public class DemoBeanProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("之前 bean:" + bean + " beanName:" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("之后 bean:" + bean + " beanName:" + beanName);
        return bean;
    }

}
