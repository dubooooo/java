package cn.com.think.date_20180301;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author dubooooo@126.com 2018-02-23
 */
public class MyClassLoder extends ClassLoader {

    final static public MyClassLoder me = new MyClassLoder();

    @Override
    protected Class<?> findClass(String name) {
        try {
            System.out.println("自定义类加载器：" + name);
            byte[] b = this.getClassByte(name);
            return this.defineClass(name, b, 0, b.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private byte[] getClassByte(String name) throws IOException {
        File classfile = new File("F:\\DemoApplication.class");
        byte[] b = new byte[(int) classfile.length()];
        new FileInputStream(classfile).read(b, 0, b.length);
        return b;
    }
}
