package cn.com.think.date_20180301.socket;

import java.io.IOException;
import java.net.Socket;

/**
 * @author dubooooo@126.com 2018-02-27
 */
public class SocketClient implements SocketCommon {

    private String host;
    private int port;
    private Socket socket;

    public SocketClient(String host, int port) throws IOException {
            this.host = host;
            this.port = port;
            socket = new Socket(host, port);
    }

    public SocketClient(Socket socket) {
        this.socket = socket;
        this.host = socket.getInetAddress().getHostAddress();
        this.port = socket.getPort();
    }

    @Override
    public byte[] receive() throws IOException {
        return receive(socket);
    }

    @Override
    public void sent(byte[] b) throws IOException {
        sent(socket, b);
    }

    public void close() {
        SocketCommon.close(socket);
    }

}
