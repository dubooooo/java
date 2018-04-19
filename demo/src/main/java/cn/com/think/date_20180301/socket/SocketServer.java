package cn.com.think.date_20180301.socket;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author dubooooo@126.com 2018-02-27
 */
public class SocketServer {

    private ServerSocket serverSocket;
    private int port;

    public SocketServer(int port) throws IOException {
        this.port = port;
        this.serverSocket = new ServerSocket(port);
    }

    public SocketClient getSocket() throws IOException {
        return new SocketClient(serverSocket.accept());
    }

    public void close() {
        SocketCommon.close(serverSocket);
    }

}

