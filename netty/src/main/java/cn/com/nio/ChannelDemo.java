package cn.com.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

/**
 * @author dubooooo@126.com 2018-04-08
 */
public class ChannelDemo {

    public static void main(String[] args) throws Exception {
        ChannelDemo demoChannel = new ChannelDemo();
        demoChannel.test01();
    }

    public void test02() throws Exception {
        Selector selector = Selector.open();

    }

    public void test01() throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("f:/nio-test", "rw");
        Channel channel = randomAccessFile.getChannel();
        System.out.println(((FileChannel) channel).size());
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int read = ((FileChannel) channel).read(byteBuffer);
        System.out.println(read);
        byteBuffer.compact();
        read = ((FileChannel) channel).read(byteBuffer);
        System.out.println(read);
    }

}
