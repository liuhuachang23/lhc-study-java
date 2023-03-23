package hsp.chapter20.homework.homework01;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/15 19:59
 * @Description: 客户端（使用字符流的方式）
 */
public class Homework01Client {
    public static void main(String[] args) throws IOException {
        //1.连接服务器（ip、端口），连接成功后，生成Socket
        //解读：链接 主机(InetAddress.getLocalHost())，端口（9999）
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);

        //---------------------发送数据----------------
        //socket.getOutputStream() 得到和 socket 关联的数据通道（得到一个输出流）
        OutputStream outputStream = socket.getOutputStream();
        //通过输出流（转换为字符流），发送数据到 数据通道
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("hobby");
        //刷新
        bw.flush();
        //设置写入结束标记
        socket.shutdownOutput();

        //-----------------读取回复--------------------
        //socket.getInputStream() 得到 和 socket 关联的数据通道（得到一个输入流）
        InputStream inputStream = socket.getInputStream();
        //通过输入流(转化为字符流) 读取客户端 写入到 数据通道的数据，输出
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();
        System.out.println(s);
        //关闭相关流和socket
        br.close();
        bw.close();
        socket.close();

    }
}
