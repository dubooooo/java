package spring;

import org.junit.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author dubooooo@126.com 2018-03-30
 */
public class ResourceLoaderTest {

    @Test
    public void test01() throws Exception {
        DefaultResourceLoader loader = new DefaultResourceLoader();
        Resource resource = loader.getResource("META-INF/spring.factories");
        System.out.println(resource.exists());
        System.out.println(resource.contentLength());
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
        br.lines().forEach(System.out::println);
    }

}
