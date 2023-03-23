package hsp.chapter20.socket.socket3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/15 09:56
 * @Description: 服务器端 （使用字符读写）
 *
 */
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        //1.在本机的 9999端口监听
        ServerSocket serverSocket = new ServerSocket(9999);
        //2.当没有客户端链接9999端口时，程序会 阻塞，等待链接
        //  如果有客户端链接，则会返回 Socket对象，程序继续
        System.out.println("服务器端，在9999端口监听，等待链接...");
        Socket socket = serverSocket.accept();

        //-------------------发送数据-------------------------
        //3.通过socket.getInputStream()，得到 和 socket 关联的通道（得到一个输入流）
        InputStream inputStream = socket.getInputStream();
        //3.通过输入流（转化为字符流）读取客户端 写入到 数据通道的数据，显示
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println(br.readLine());

        //-------------回复数据------------------------
        // 通过socket.getOutputStream()（得到一个输出流）
        OutputStream outputStream = socket.getOutputStream();
        //4.通过输出流，转换为字符流，写入数据到 数据通道
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("hello，client");
        //刷新
        bw.flush();
        //5.设置写入结束标记(代表写入结束，也意味着这个s后面不能使用socket.getOutputStream())
        socket.shutdownOutput();
        //6.关闭 相关流 和 socket
        br.close();
        bw.close();
        serverSocket.close();
        socket.close();
        System.out.println("服务器端退出...");

    }
}

