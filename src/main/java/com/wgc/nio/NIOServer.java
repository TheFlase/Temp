package com.wgc.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by Administrator on 7/5/2018.
 * desc:NIO服务器
 */
public class NIOServer {
    //通道管理器
    private Selector selector;

    public static void main(String[] args) throws IOException{
        NIOServer nioServer = new NIOServer();
        nioServer.initServer(10101);
        nioServer.listen();

    }

    /**
     * desc:获取一个ServerSocket通道,并对该通道做一些初始化操作
     * @param port 绑定的端口号
     * @throws IOException
     */
    public void initServer(int port) throws IOException {
        //获取一个SocketServer通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //设置通道为非阻塞
        serverSocketChannel.configureBlocking(false);

        //将该通道对应的ServerSocket绑定到对应的端口
        serverSocketChannel.socket().bind(new InetSocketAddress(port));

        //获得一个通道管理器
        this.selector = Selector.open();

        /**
         * 将通道管理器和该通道绑定,并为该通道注册SelectionKey.OP_ACCEPT事件,注册该事件后,
         * 当该事件到达时,selector.select()会返回。如果该事件没有到达selector.select()会一直阻塞
         */
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    /**
     * desc:采用轮询的方式监听selector上是否有需要处理的事件，如果有，则进行处理
     * @throws IOException
     */
    public void listen()throws IOException{
        System.out.println("服务器端启动成功!");
        //轮询访问selector
        while (true) {
            //当注册的事件到达时，方法返回;否则，该方法会一直阻塞
            selector.select();
            //获得selector中选中的项的迭代器,选中的项为注册事件
            Iterator<?> ite = this.selector.selectedKeys().iterator();
            while (ite.hasNext()) {
                SelectionKey key = (SelectionKey) ite.next();
                handler(key);
                //删除已选的key，以免重复处理
                ite.remove();
            }
        }
    }

    /**
     *  desc:处理请求
     * @param key
     * @throws IOException
     */
    public void handler(SelectionKey key)throws IOException{
        //客户端连接请求事件
        if(key.isAcceptable()) {
            handleAccept(key);
        }else if (key.isReadable()) {
            handlerRead(key);
        }
    }

    /**
     * desc:处理连接请求
     * @param key
     * @throws IOException
     */
    public void handleAccept(SelectionKey key)throws IOException {
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        //获得和客户端连接的通道
        SocketChannel channel = server.accept();

        //设置成非阻塞
        channel.configureBlocking(false);

        //在这里可以给客户端发送信息
        System.out.println("新的客户端连接！");

        //在和客户端连接成功之后,为了可以接收到客户端的信息,需要给通道设置读的权限
        channel.register(this.selector,SelectionKey.OP_READ);
    }

    /**
     * desc:处理读的事件
     * @param key
     * @throws IOException
     */
    public void handlerRead(SelectionKey key)throws IOException {
        //服务器可读消息:得到事件发生的Socket通道
        SocketChannel channel = (SocketChannel) key.channel();

        //创建读取的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = channel.read(buffer);
        if(read != -1){
            byte[] data = buffer.array();
            String msg = new String(data).trim();
            System.out.println("服务器端接收到的消息是:"+msg);

            //回写数据
            ByteBuffer outBuffer = ByteBuffer.wrap("好的".getBytes());
            //将消息回送给客户端
            channel.write(outBuffer);
        }else {
            System.out.println("客户端关闭!");
            key.cancel();
        }
    }

}
