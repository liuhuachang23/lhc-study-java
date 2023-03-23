package hsp.chapter20.socket.socket1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/14 19:57
 * @Description: 客户端 （使用字节读写）
 * 客户端链接到服务器端，发送 "hello，server"，然后退出
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        //1.连接服务器（ip、端口），连接成功后，生成Socket
        //解读：链接 主机(InetAddress.getLocalHost())，端口（9999）
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket = " + socket.getClass());
        //2.通过socket.getOutputStream()，得到和 socket 关联的数据通道 (得到一个输出流)
        OutputStream outputStream = socket.getOutputStream();
        //3.通过输出流，写入数据到 数据通道
        outputStream.write("hello，server".getBytes());
        //4.关闭 相关的流 和 socket
        outputStream.close();
        socket.close();
        System.out.println("客户端退出...");


    }
}
