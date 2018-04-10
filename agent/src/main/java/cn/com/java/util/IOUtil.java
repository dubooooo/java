package cn.com.java.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author dubooooo@126.com 2018-03-08
 */
public class IOUtil {

    public static void save(String filePath, byte[] b) throws IOException {
        File file = new File(filePath);
        save(file, b);
    }

    public static void save(File file, byte[] b) throws IOException {
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        try (FileOutputStream out = new FileOutputStream(file)) {
            out.write(b);
            out.flush();
        }
    }

}
