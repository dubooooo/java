package cn.com.think.date_20180301.socket;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author dubooooo@126.com 2018-02-28
 */
public interface SocketCommon {

    void sent(byte[] b) throws IOException;

    default void sent(String str) throws IOException {
        sent(str.getBytes());
    }

    default void sent(Socket socket, byte[] b) throws IOException {
        sent(socket.getOutputStream(), b);
    }

    default void sent(OutputStream out, byte[] b) throws IOException {
        long length = b.length;
        System.out.println("发送数据长度：" + length);
        byte[] length_byte = Objects.long2Bytes(length);
        out.write(length_byte, 0, length_byte.length);
        out.flush();
        out.write(b);
        out.flush();
    }

    byte[] receive() throws IOException;

    default byte[] receive(Socket socket) throws IOException {
        return receive(socket.getInputStream());
    }

    default byte[] receive(InputStream in) throws IOException {
        byte[] length_byte = new byte[8];
        in.read(length_byte, 0, length_byte.length);
        Long length = Objects.bytes2Long(length_byte);
        System.out.println("接受数据长度：" + length.intValue());
        byte[] buffer = new byte[length.intValue()];
        in.read(buffer);
        return buffer;
    }

    public static void close(Closeable... closeables) {
        if (closeables != null) {
            for (Closeable closeable : closeables) {
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
