package hsp.chapter20.udp;

import java.io.IOException;
import java.net.*;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/15 18:41
 * @Description: UDP发送端（即可以发送数据，也可以接收数据）、
 * 给 UDP接收端A 发送一个数据 "hello，明天吃火锅"
 * 接收 UDP接收端A 回复的数据
 * 退出
 */
public class UDPSenderB {
    public static void main(String[] args) throws IOException {

        //1.创建 DatagramSocket 对象，准备在9998端口，接收数据/发送数据
        DatagramSocket socket = new DatagramSocket(9998);

        //------------------发送数据---------------------
        //2.将需要发送的数据 放到一个字节数组中
        byte[] data = "hello，明天吃火锅".getBytes();
        //3.将这个字节数组，封装到 DatagramPacket对象
        //说明：DatagramPacket(data 字节数组, data.length 数组长度, 主机(ip), 端口)
        DatagramPacket packet = //InetAddress.getByName("172.20.10.3")
                new DatagramPacket(data, data.length, InetAddress.getByName("DESKTOP-9CB5SEV"), 9999);
        //发送
        socket.send(packet);

        //-----------------接收从A端回复的数据--------------------
        //4.创建一个 字节数组，准备接收 接收端A 发来的数据
        byte[] buf = new byte[1024];
        //5.将这个数组，封装到 这个DatagramPacket 对象中
        packet = new DatagramPacket(buf, buf.length);
        //6.调用接收方法 将通过网络传输的 DatagramPacket对象（这个是 接收端A 发送过来的）
        //  填充到 packet1对象中 （这个是刚刚上面 第5步 创建的）
        //说明：当有数据发送到 本机的9998端口时，就会接收到数据
        //      没有数据包，发送到本机的9998端口时，就会阻塞等待
        System.out.println("发送端A，等待接收数据...");
        socket.receive(packet);
        //7.把packet1 进行 拆包，取出数据，并显示
        int length = packet.getLength();//实际接收到的长度
        data = packet.getData();//接收到的数据
        String s = new String(data,0,length);
        System.out.println(s);

        //关闭资源
        socket.close();
        System.out.println("B端退出...");

    }
}
