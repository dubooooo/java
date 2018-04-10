package cn.com.java.agent;

import java.io.*;

/**
 * 文件操作
 *
 * @author dubooooo@126.com 2018-02-02
 */
public class FileIO {

    String filePath;

    BufferedWriter bw;

    public FileIO(String filePath) {
        this.filePath = filePath;
        init();
    }

    public void init() {
        try {
            this.bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.filePath, true), "UTF-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public void append(String str) {
        try {
            this.bw.write(str);
            this.bw.newLine();
            this.bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
