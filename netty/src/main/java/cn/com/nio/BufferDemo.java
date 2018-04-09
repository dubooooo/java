package cn.com.nio;

import java.nio.CharBuffer;

/**
 * @author dubooooo@126.com 2018-04-08
 */
public class BufferDemo {

    public static void main(String[] args) {
        BufferDemo bufferDemo = new BufferDemo();
        bufferDemo.test01();
    }

    public void test01() {
        CharBuffer charBuffer = CharBuffer.allocate(10);
        charBuffer.hasRemaining();
        charBuffer.append("a");
        charBuffer.append("b");
        charBuffer.append("c");
        charBuffer.put("d");
        charBuffer.flip();
        System.out.println(charBuffer.get());
        charBuffer.compact();
        charBuffer.flip();
        charBuffer.append("e");
        System.out.println(charBuffer.get());
        System.out.println(charBuffer.get());

        System.out.println(charBuffer.array());
    }

}
