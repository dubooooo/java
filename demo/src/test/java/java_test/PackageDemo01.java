package java_test;

import org.junit.Test;

import java.lang.annotation.Annotation;

/**
 * @author dubooooo@126.com 2018-03-29
 */
public class PackageDemo01 {

    @Test
    public void test01() {
        Package aPackage = PackageDemo01.class.getPackage();
        System.out.println(aPackage);
        System.out.println(aPackage.getName());
        Annotation[] annotations = aPackage.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

    }

}
