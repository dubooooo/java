package spring;

import org.apache.catalina.core.StandardWrapper;
import org.apache.catalina.core.StandardWrapperFacade;
import org.junit.Test;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletConfig;
import java.util.List;
import java.util.Optional;

/**
 * @author dubooooo@126.com 2018-03-08
 */
public class Test01 {

    @Test
    public void test02() {
        try {
            StandardWrapper standardWrapper = new StandardWrapper();
            ServletConfig servletConfig = new StandardWrapperFacade(standardWrapper);
            DispatcherServlet servlet = new DispatcherServlet();
            servlet.init(servletConfig);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test03() {
        int i = 1;
        test04(i);
        System.out.println(i);
    }

    public void test04(int i) {
        i++;
    }

    @Test
    public void test05() {
        List list = null;
        Optional.ofNullable(list).map(e -> e.get(0)).ifPresent(e -> System.out.println(e));
    }



}
