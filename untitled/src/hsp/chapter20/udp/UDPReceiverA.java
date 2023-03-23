package hsp.chapter20.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/15 18:41
 * @Description: UDP接收端（即是可以接收数据，也可以发送数据）
 * 接收 UDP发送端B 传来的数据，并显示
 * 给 UDP发送端B 回复 "好的，明天见"
 * 退出
 */
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {

        //1.创建一个DatagramSocket 对象，准备在9999端口 接收数据/发送数据
        DatagramSocket socket = new DatagramSocket(9999);

        //------------------接收数据-------------------
        //2.创建一个数组，准备接收数据
        //  UDP协议 数据包最大 64k （64 * 1024）
        byte[] buf = new byte[1024];
        //3.创建一个 DatagramPacket 对象，将这个数组 封装到 DatagramPacket对象中
        DatagramPacket packet = new DatagramPacket(buf, buf.length); //buf字节数组，buf.length数组长度

        //4.调用接收方法，将通过网络传输的 DatagramPacket对象（这个是发送端发送过来的）
        //填充到 packet对象（这个是刚刚上面 第3步 创建的）
        //说明：当有数据发送到 本机的9999端口时，就会接收到数据
        //      没有数据包，发送到本机的9999端口时，就会阻塞等待
        System.out.println("接收端A 等待接收数据...");
        socket.receive(packet);

        //5.把packet 进行 拆包，取出数据，并显示
        int length = packet.getLength(); //实际接收到的长度
        byte[] data = packet.getData(); //接收到的数据
        String s = new String(data, 0, length);
        System.out.println(s);

        //--------------回复数据给B端----------------------
        //6.将需要发送的数据 放到一个字节数组中
        data = "好的，明天见".getBytes();
        //3.将这个字节数组，封装到 DatagramPacket对象
        //  说明：DatagramPacket(data字节数组, data.length数组长度, 主机(ip), 端口)
        packet =
                new DatagramPacket(data,data.length, InetAddress.getByName("DESKTOP-9CB5SEV"),9998);
        //发送
        socket.send(packet);

        //关闭资源
        socket.close();
        System.out.println("A端退出...");
    }
}
