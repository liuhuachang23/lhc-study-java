package hsp.chapter20.homework.homework02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/15 20:35
 * @Description: 接收端A
 */
public class ReceiverA {
    public static void main(String[] args) throws IOException {

        //1.创建一个DatagramSocket 对象，准备在接收端A的 9999端口 接收数据/发送数据
        DatagramSocket socket = new DatagramSocket(9999);

        //--------------接收数据----------------
        //创建一个字节数组，准备 接收发送端发送过来的数据
        byte[] data = new byte[1024];
        //创建一个 DatagramPacket对象，将这个数组封装到 DatagramPacket对象中
        DatagramPacket packet = new DatagramPacket(data, data.length);

        //调用接收方法，将通过网络传输的 DatagramPacket对象（发送端发送过来的）
        // 填充到 packet对象中 （这个是上面刚刚创建的 DatagramPacket对象）
        //说明：当有数据发送到 本机的9999端口时，就会接收到数据
        //      没有数据包，发送到本机的9999端口时，就会阻塞等待
        System.out.println("接收端A 等待接收数据...");
        socket.receive(packet);

        //把packet 进行拆包，取出数据
        int length = packet.getLength();
        data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);

        //------------------回复数据-------------------
        if ("四大名著是那些".equals(s)){
            //将需要回复的数据，放到一个字节数组中
            data = "四大名著是《红楼梦》...".getBytes();
            //3.将这个字节数组，封装到 DatagramPacket对象
            //  说明：DatagramPacket(data 字节数组, data.length 数组长度, 主机(ip), 端口)
            packet = new DatagramPacket(data,data.length, InetAddress.getByName("DESKTOP-9CB5SEV"), 9998);
            //发送
            socket.send(packet);

        } else {
            //将需要回复的数据，放到一个字节数组中
            data = "what?".getBytes();
            //3.将这个字节数组，封装到 DatagramPacket对象
            //  说明：DatagramPacket(data 字节数组, data.length 数组长度, 主机(ip), 端口)
            packet = new DatagramPacket(data,data.length, InetAddress.getByName("DESKTOP-9CB5SEV"), 9998);
            //发送
            socket.send(packet);
        }

        //关闭资源
        socket.close();
        System.out.println("接收端A退出...");

    }
}
