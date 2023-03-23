package hsp.chapter20.socket.socket3;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/15 09:55
 * @Description: 客户端（使用字符读写）
 *
 */
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        //1.连接服务器（ip、端口），连接成功后，生成Socket
        //解读：链接 主机(InetAddress.getLocalHost())，端口（9999）
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        //2.socket.getOutputStream()，得到和 socket 关联的数据通道（得到一个输出流）
        OutputStream outputStream = socket.getOutputStream();

        //3.通过输出流（转换为字符流）写入数据到 数据通道
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("hello，server");
        //刷新
        bw.flush();

        //4.设置写入结束标记
        socket.shutdownOutput();
        //5.socket.getInputStream() 得到和 socket 关联的数据通道（得到一个输入流）
        InputStream inputStream = socket.getInputStream();
        //6. 通过输入流，转换为字符流，读取服务器端写入到 数据通道的数据，显示
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println(br.readLine());

        //6. 关闭 相关流 和 socket
        bw.close();
        br.close();
        socket.close();
        System.out.println("客户端退出...");
    }
}
