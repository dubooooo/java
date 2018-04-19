package cn.com.think.date_20180301;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author dubooooo@126.com 2018-02-24
 */
public class BaiDu implements Runnable {

    public static void main(String[] args) {
        int threadSize = 1;
        if (args.length != 0) {
            threadSize = Integer.valueOf(args[0]);
        }
        DownLoad downLoad = new DownLoad(args[1]);
        for (int i = 0; i < threadSize; i++) {
            new Thread(new BaiDu().setDownLoad(downLoad)).start();
        }
    }

    private static String base_url = "http://tieba.baidu.com/p/";
    private static String tieba_404 = "贴吧404";
    private static String newline = "\n";

    private StringBuffer sb = new StringBuffer();
    private Random random = new Random();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private DownLoad downLoad;

    public BaiDu setDownLoad(DownLoad downLoad) {
        this.downLoad = downLoad;
        return this;
    }

    public int getIndex() {
        return this.random.nextInt(Integer.MAX_VALUE);
    }

    @Override
    public void run() {
        while (true) {
            try {
                int index = this.getIndex();
                Document doc = BaiDuHttp.me().get(base_url + index);
                String title = doc.title();
                if (!tieba_404.equals(title)) {
                    this.sb.append(this.sdf.format(new Date()));
                    this.sb.append("  " + Thread.currentThread().getName());
                    this.sb.append("  " + index);
                    this.sb.append("\t\t" + title);
                    Elements elements = doc.getAllElements();
                    elements.stream().filter(e -> "img".equals(e.tagName())).forEach(e -> {
                        String href = e.attr("src");
                        if (href != null && href.startsWith("http") && href.endsWith(".jpg")) {
                            //System.out.println(href);
                            downLoad.addUrl(href);
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.sb.length() > 0) {
                System.out.println(this.sb);
                this.sb.setLength(0);
            }
        }
    }
}

class BaiDuHttp {

    private final static BaiDuHttp ME = new BaiDuHttp();

    public static BaiDuHttp me() {
        return ME;
    }

    public Document get(String url) throws IOException {
        return Jsoup.connect(url).get();
    }

}