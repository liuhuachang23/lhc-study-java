package hsp.chapter20.socket.socket2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/15 09:07
 * @Description: 服务器端 （使用字节读写）
 * 服务器端在9999端口监听
 * 服务器端接收到客户端发送的信息，输出
 * 再向客户端发送 "hello，client"
 * 然后退出
 */
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        //1.在本机的 9999端口监听，等待连接
        ServerSocket serverSocket = new ServerSocket(9999);
        //2.当没有客户端链接9999端口时，程序会 阻塞，等待链接
        //  如果有客户端链接，则会返回 Socket对象，程序继续
        System.out.println("服务器端，在9999端口监听，等待链接...");
        Socket socket = serverSocket.accept();

        //3.socket.getInputStream() 获取和 socket关联的数据通道 (得到一个输入流)
        InputStream inputStream = socket.getInputStream();
        //4.读取客户端 写入到 数据通道的数据，显示
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));
        }

        //5.socket.getOutputStream() 获取 和 socket 关联的数据通道 (得到一个输出流)
        OutputStream outputStream = socket.getOutputStream();
        //通过输入流 写入数据到 数据通道
        outputStream.write("hello，client".getBytes());

        //5.设置写入结束标记 (代表写入结束，也意味着这个s后面不能使用socket.getOutputStream())
        socket.shutdownOutput();
        //6.关闭 相关流 和 socket
        inputStream.close();
        outputStream.close();
        serverSocket.close();
        socket.close();
        System.out.println("服务器端退出...");



    }
}
