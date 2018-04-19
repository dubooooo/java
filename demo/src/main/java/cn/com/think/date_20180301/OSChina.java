package cn.com.think.date_20180301;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author dubooooo@126.com 2018-02-24
 */
public class OSChina {

    private static String base_url = "https://www.oschina.net/tweets?lastLogId=";
    private static String newline = "\n";
    private static int index = 1000000;

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        while (true) {
            try {
                index += 30;
                System.out.println("index  " + index + "  url  " + base_url + index);
                Document doc = OSChinaHttp.me().get(base_url + index);
                Elements elements = doc.getAllElements();
                elements.stream().filter(e -> "ti-uname".equals(e.className()) || "publish-time".equals(e.className()) || "inner-content wrap".equals(e.className())).forEach(e -> {
                    if ("ti-uname".equals(e.className())) {
                        sb.append("姓名  " + e.text() + newline);
                    } else if ("publish-time".equals(e.className())) {
                        sb.append("时间  " + e.text() + newline);
                    } else {
                        sb.append("内容  " + e.text() + newline);
                    }
                });
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }

}

class OSChinaHttp {

    private final static OSChinaHttp ME = new OSChinaHttp();

    public static OSChinaHttp me() {
        return ME;
    }

    public Document get(String url) throws IOException {
        return Jsoup.connect(url).get();
    }

}