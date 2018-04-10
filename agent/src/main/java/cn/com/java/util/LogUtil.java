package cn.com.java.util;

import java.io.FileWriter;

/**
 * @author dubooooo@126.com 2018-04-09
 */
public class LogUtil {

    static FileWriter out;

    static {
        try {
            out = new FileWriter("D:/JavaSoft/Jetbrains/idea/log/idea-system-out-print.log", true);
        } catch (Exception e) {
            out = null;
            e.printStackTrace();
        }
    }

    public static void info(String msg) {
        //        try {
        //            out.write(msg);
        //            out.flush();
        //        } catch (Exception e) {
        //            e.printStackTrace();
        //        }

    }

    public static void main(String[] args) {
        info("123");
        info("123");
        info("123");
    }

}
