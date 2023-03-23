package hsp.chapter20.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/15 12:02
 * @Description: 文件上床的客户端
 * 客户端连接到服务器端，发送一张图片 d:\\qie.png
 * 客户端接收到服务器端发送的 "收到图片"，在退出
 * 该程序要求使用 StreamUtils.java
 */
public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {
        //1.连接服务器（ip、端口），连接成功后，生成Socket
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        //2.将磁盘中的图片(d:\\wwl.jpg) 读入 到客户端的 字节数组中
        String filePath = "d:\\wwl.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        //bytes 就是filePath对应的字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //-------------发送数据---------------
        //3.通过socket.getOutputStream()，得到和 socket 关联的通道 （得到一个输出流）
        OutputStream outputStream = socket.getOutputStream();
        //5.通过输出流，将这个字节数组 写入到 数据通道
        BufferedOutputStream bos = new BufferedOutputStream(outputStream);
        bos.write(bytes);
        //关闭bis流
        bis.close();
        //设置写入结束标记 (代表写入结束，也意味着这个s后面不能使用socket.getOutputStream() )
        socket.shutdownOutput();

        //----------------接收回复-----------------
        //6.通过 socket.getInputStream() 得到和 socket 关联的通道（得到一个输入流）
        InputStream inputStream = socket.getInputStream();
        //7.使用StreamUtils 的方法，直接将 通道中的内容 转成字符串
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);

        //关闭相关流 和 socket
        inputStream.close();
        bos.close();
        socket.close();

        System.out.println("客户端退出...");




    }
}