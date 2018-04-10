package cn.com.java.agent;

import cn.com.java.util.LogUtil;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java-agent主类
 *
 * @author dubooooo@126.com 2018-02-02
 */
public class Agent {

    public static Instrumentation instrumentation;

    public static void premain(String args, Instrumentation instrumentation) {
        try {
            LogUtil.info(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " java agent start...");
            Agent.instrumentation = instrumentation;
            instrumentation.addTransformer(new ClassTransformer());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class ClassTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        try {
            if (className != null && className.startsWith("com/seventh7/widget/iedis")) {
                LogUtil.info(className);
            }
        } catch (Throwable t) {
            LogUtil.info("transform error:[" + t.getMessage() + "] class name:" + className);
            t.printStackTrace();
        }
        return null;
    }
}