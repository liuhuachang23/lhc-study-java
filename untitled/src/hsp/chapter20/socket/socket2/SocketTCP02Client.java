package hsp.chapter20.socket.socket2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/15 09:07
 * @Description: 客户端 （使用字节读写）
 * 客户端链接到服务器端，
 * 向服务器端发送 "hello，server"
 * 再接收到服务器端发送的信息，输出
 * 然后退出
 */
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        //1.连接服务器（ip、端口），连接成功后，生成Socket
        //解读：链接 主机(InetAddress.getLocalHost())，端口（9999）
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //2.socket.getOutputStream()，得到和 socket 关联的通道(得到一个输出流)
        OutputStream outputStream = socket.getOutputStream();
        //3.通过输出流，写入数据到 数据通道
        outputStream.write("hello，server".getBytes());
        //4.设置写入结束标记(代表写入结束，也意味着这个s后面不能使用socket.getOutputStream())
        socket.shutdownOutput();
        //---------------接收数据----------------------------
        //5.socket.getInputStream() 得到和 socket 关联的数据通道(得到一个输入流)
        InputStream inputStream = socket.getInputStream();
        //6.读取服务器端 写入到 数据通道 中的数据，显示
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));
        }

        //7. 关闭 相关流 和 socket
        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端退出...");


    }
}
