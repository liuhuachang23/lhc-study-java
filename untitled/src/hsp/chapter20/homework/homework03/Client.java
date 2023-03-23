package hsp.chapter20.homework.homework03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/16 14:58
 * @Description:
 */
public class Client {
    public static void main(String[] args) throws Exception {
        //1.连接服务器（ip、端口），连接成功后，生成Socket
        //  解读：链接 主机(InetAddress.getLocalHost())，端口（9999）
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        //----------------------发送数据-----------------------
        //socket.getOutputStream() 得到一个和 socket 关联的数据通道（得到一个输出流）
        OutputStream outputStream = socket.getOutputStream();
        //通过输出流，写入数据 到数据通道
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        String fileName = "高山流水";
        bw.write(fileName);
        bw.flush();
        socket.shutdownOutput();

        //------------------接收回复----------------------
        //socket.getInputStream() 得到 一个和 socket 关联的数据通道（得到一个输入流）
        InputStream inputStream = socket.getInputStream();
        //通过输入流，读取 客户端写入数据通道的字节数组，先存放到 客户端的字节数组中
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        byte[] data = StreamUtils.streamToByteArray(bis);

        //接收 回复过来的文件名

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = br.readLine();
        System.out.println(s);
        String destFilePath = null;
        if (fileName.equals(s)) {
            destFilePath = "src\\hsp\\chapter20\\homework\\homework03\\" + fileName + ".mp3";
        } else {
            destFilePath = "src\\hsp\\chapter20\\homework\\homework03\\无名.mp3";
        }
        // 将得到 data 字节数组，写入到指定的路径，就得到一个文件了
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(data);
        //关闭资源
        bw.close();
        bis.close();
        bos.close();
        socket.close();
        System.out.println("客户端下载完毕，退出...");
    }
}
