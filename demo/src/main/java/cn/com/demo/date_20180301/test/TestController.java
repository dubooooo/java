package cn.com.demo.date_20180301.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author dubooooo@126.com 2018-02-28
 */
@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("/test01")
    public String test01() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().toString());
        HashMap<Object, Object> map = new HashMap<>();
        map.put(null, null);
        return UUID.randomUUID().toString();
    }

}
