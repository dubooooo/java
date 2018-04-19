package cn.com.think.date_20180301;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dubooooo@126.com 2018-03-02
 */
public class DownLoad {

    final static private ExecutorService executorService = Executors.newFixedThreadPool(10);
    private String fileSavePath;

    public DownLoad(String folder) {
        this.fileSavePath = folder;
        File file = new File(fileSavePath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public void addUrl(String url) {
        while (true) {
            try {
                executorService.execute(new DownLoadWork(url, fileSavePath));
                break;
            } catch (Throwable t) {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

class DownLoadWork implements Runnable {

    private String url;
    private String fileSavePath;

    public DownLoadWork(String url, String folder) {
        this.url = url;
        this.fileSavePath = folder;
    }

    @Override
    public void run() {
        try {
            startDownload(url, fileSavePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startDownload(String httpUrl, String fileSavePath) throws IOException {
        System.out.println("download start -> " + httpUrl);
        URL url = new URL(httpUrl);
        URLConnection connection = url.openConnection();
        InputStream in = connection.getInputStream();
        String fullFilePath = getFullFileSavePath(httpUrl, fileSavePath);
        FileOutputStream out = new FileOutputStream(fullFilePath);
        byte[] buffer = new byte[1024 * 1024];
        int index;
        while ((index = in.read(buffer)) != -1) {
            out.write(buffer, 0, index);
        }
        System.out.println("download over  -> " + fullFilePath);
        out.close();
        in.close();
    }

    private String getFullFileSavePath(String httpUrl, String fileSavePath) {
        int startIndex = httpUrl.lastIndexOf("/");
        if (fileSavePath.endsWith("/")) {
            startIndex++;
        }
        return fileSavePath + httpUrl.substring(startIndex, httpUrl.length());
    }
}