package hsp.chapter20.homework.homework01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/15 19:59
 * @Description: 服务器端 （使用字符流的方式）
 *
 */
public class Homework01Server {
    public static void main(String[] args) throws IOException {
        //1.在本机的 9999端口监听
        ServerSocket serverSocket = new ServerSocket(9999);
        //2.当没有客户端链接9999端口时，程序会 阻塞，等待链接
        //  如果有客户端链接，则会返回 Socket对象，程序继续
        System.out.println("服务器端，在9999端口监听，等待链接...");
        Socket socket = serverSocket.accept();

        //-----------------接收数据-----------------------
        //socket.getInputStream() 得到 和 socket 关联的数据通道（得到一个输入流）
        InputStream inputStream = socket.getInputStream();
        //通过输入流(转化为字符流) 读取客户端 写入到 数据通道的数据，显示
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();
        System.out.println(s);

        //------------------回复数据--------------------
        OutputStream outputStream = null;
        BufferedWriter bw = null;
        if ("name".equals(s)){
            //socket.getOutputStream() 得到 和 socket 关联的数据通道(得到一个输出流)
            outputStream = socket.getOutputStream();
            //通过输出流（转换为字符流），发送数据到 数据通道
            bw = new BufferedWriter(new OutputStreamWriter(outputStream));
            bw.write("我是 nova");
            //刷新
            bw.flush();
            //设置写入结束标记
            socket.shutdownOutput();
        } else if ("hobby".equals(s)) {
            //socket.getOutputStream() 得到 和 socket 关联的数据通道(得到一个输出流)
            outputStream = socket.getOutputStream();
            //通过输出流（转换为字符流），发送数据到 数据通道
            bw = new BufferedWriter(new OutputStreamWriter(outputStream));
            bw.write("编写java程序");
            //刷新
            bw.flush();
            //设置写入结束标记
            socket.shutdownOutput();
        } else {
            //socket.getOutputStream() 得到 和 socket 关联的数据通道(得到一个输出流)
            outputStream = socket.getOutputStream();
            //通过输出流（转换为字符流），发送数据到 数据通道
            bw = new BufferedWriter(new OutputStreamWriter(outputStream));
            bw.write("你说啥呢");
            //刷新
            bw.flush();
            //设置写入结束标记
            socket.shutdownOutput();
        }

        //关闭相应的流和socket
        br.close();
        bw.close();
        serverSocket.close();
        socket.close();

    }
}
