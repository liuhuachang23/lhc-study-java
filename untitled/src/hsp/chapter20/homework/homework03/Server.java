package hsp.chapter20.homework.homework03;

import hsp.chapter20.upload.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/16 14:58
 * @Description:
 */
public class Server {
    public static void main(String[] args) throws Exception {
        //1.在本机的 端口监听
        ServerSocket serverSocket = new ServerSocket(9999);
        //2.当没有客户端连接到9999端口，就会阻塞，等待连接
        // 当有客户端连接时，就会返回一个 socket 对象，程序继续
        System.out.println("服务器端 在9999端口监听，等待链接...");
        Socket socket = serverSocket.accept();

        //-----------------接收数据---------------
        //socket.getInputStream() 得到一个 和 socket关联的数据通道（获得一个输入流）
        InputStream inputStream = socket.getInputStream();
        //通过输入流 读取 客户端写入数据通道的数据，显示
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();
        System.out.println(s);

        //-----------------回复数据---------------------
        String filePath = "d:\\" + s + ".mp3";
        OutputStream outputStream = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        File file = new File(filePath);
        if (file.exists()) { //说明这个文件存在
            //将磁盘中的文件 读入 到服务器端的 字节数组中
            bis = new BufferedInputStream(new FileInputStream(filePath));
            byte[] data = StreamUtils.streamToByteArray(bis);
            //socket.getOutputStream() 得到一个 和 socket关联的数据通道（获得一个输出流）
            outputStream = socket.getOutputStream();
            //通过输出流 将这个字节数组 输出到 数据通道中
            bos = new BufferedOutputStream(outputStream);
            bos.write(data);
            bos.flush();
            socket.shutdownOutput();
        } else {
            //没有客户端要的文件
            //返回一个默认的音乐即可
            filePath = "d:\\无名.mp3";
            //将磁盘中的文件 读入 到服务器端的 字节数组中
            bis = new BufferedInputStream(new FileInputStream(filePath));
            byte[] data = StreamUtils.streamToByteArray(bis);
            //socket.getOutputStream() 得到一个 和 socket关联的数据通道（获得一个输出流）
            outputStream = socket.getOutputStream();
            //通过输出流 将这个字节数组 输出到 数据通道中
            bos = new BufferedOutputStream(outputStream);
            bos.write(data);
            bos.flush();
            socket.shutdownOutput();
        }

        //再 回复 发送文件的文件名
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write(s);
        socket.shutdownOutput();

        //关闭资源
        bw.close();
        br.close();
        bis.close();
        bos.close();
        serverSocket.close();
        socket.close();
        System.out.println("服务端 传输完毕，退出...");

    }
}
