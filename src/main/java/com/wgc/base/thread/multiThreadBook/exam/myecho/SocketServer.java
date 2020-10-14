package com.wgc.base.thread.multiThreadBook.exam.myecho;

/**
 * @program: com.io.socket.server
 * @description: Socket服务端启动类
 * @author: liujinghui
 * @create: 2019-02-16 10:39
 **/
public class SocketServer {

    public static void main(String[] args) throws Exception{
        SocketServerListenHandler socketServerListenHandler = new SocketServerListenHandler(6666);
        socketServerListenHandler.listenClientConnect();
    }
}
