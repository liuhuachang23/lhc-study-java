package hsp.chapter20.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/15 12:02
 * @Description: 文件上传的服务端
 * 服务器端在 8888端口监听
 * 服务器端接收到客户端发送的图片，保存到 src下
 * 发送 "收到图片" 到客户端，在退出
 *
 */
public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {
        //1.在本机的 8888端口监听
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器端 在8888端口监听，等待链接...");

        //2.当没有客户端链接8888端口时，程序会 阻塞，等待链接
        //  如果有客户端链接，则会返回 Socket对象，程序继续
        Socket socket = serverSocket.accept();

        //--------------------接收数据--------------------
        //3.通过socket.getInputStream()，得到和 socket 关联的通道（得到一个输入流）
        InputStream inputStream = socket.getInputStream();
        //4.通过输入流，读取 客户端写入数据通道的字节数组，先存放到服务器端的字节数组中
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //5. 将得到 bytes 数组，写入到指定的路径，就得到一个文件了
        String destFilePath = "src\\wwl.jpg";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);
        //关闭bos流
        bos.close();

        //--------------------回复数据-----------------------------
        //6.通过socket.getOutputStream() 得到和 socket 关联的通道（得到一个输出流）
        OutputStream outputStream = socket.getOutputStream();
        //7.向客户端回复 "收到图片"
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("收到图片");
        //刷新内容到数据通道
        bw.flush();
        //设置写入结束标记 (代表写入结束，也意味着这个s后面不能使用socket.getOutputStream())
        socket.shutdownOutput();

        //关闭相关流 和 socket
        bis.close();
        bw.close();
        serverSocket.close();
        socket.close();

        System.out.println("服务器端退出...");




    }
}
