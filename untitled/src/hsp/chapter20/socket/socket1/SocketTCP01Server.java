package hsp.chapter20.socket.socket1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/14 19:56
 * @Description: 服务器端 （使用字节读写）
 * 服务器端在9999端口监听
 * 服务器端接收到客户端发送的信息，输出，然后退出
 */
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {

        //1.在本机的 9999端口监听，等待连接
        //  细节：要求在本机没有其他服务器在监听9999
        //  细节：这个 serverSocket 可以通过 accept() 返回多个 Socket
        //       （供多个客户端链接服务器的并发，这里只演示一个客户端和服务器链接）
        ServerSocket serverSocket = new ServerSocket(9999);

        //2.当没有客户端链接9999端口时，程序会 阻塞，等待链接
        //  如果有客户端链接，则会返回 Socket对象，程序继续
        System.out.println("服务器端，在9999端口监听，等待链接...");
        Socket socket = serverSocket.accept();
        System.out.println("服务器端 socket() = " + socket.getClass());

        //3.通过socket.getInputStream() 得到和 socket 关联的数据通道 (得到一个输入流)
        InputStream inputStream = socket.getInputStream();
        //4.读取客户端 写入到 数据通道的数据，显示
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1){
            System.out.println(new String(buf,0,readLen));
        }
        //关闭 相关流 和 socket
        inputStream.close();
        serverSocket.close();
        socket.close();

    }
}
