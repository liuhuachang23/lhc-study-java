package hsp.chapter20.homework.homework02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/15 20:36
 * @Description: 发送端B
 */
public class SenderB {
    public static void main(String[] args) throws IOException {

        //1.创建 DatagramSocket 对象，准备在发送端B的 9998端口，接收数据/发送数据
        DatagramSocket socket = new DatagramSocket(9998);

        //--------------发送数据---------------
        //2.将需要发送的数据 放到一个字节数组中
        byte[] data = "四大名著是那些".getBytes();
        //3.将这个字节数组，封装到 DatagramPacket对象
        //说明：DatagramPacket(data 字节数组, data.length 数组长度, 主机(ip), 端口)
        DatagramPacket packet =
                new DatagramPacket(data, data.length, InetAddress.getByName("DESKTOP-9CB5SEV"), 9999);
        //4.发送
        socket.send(packet);

        //------------------接收回复---------------------
        //创建一个字符数组，准备接收 接收端A 回复的数据
        data = new byte[1024];
        //把这个数组封装到 DatagramPacket对象中
        packet = new DatagramPacket(data, data.length);
        //调用接收方法，将通过网络传输的 DatagramPacket对象（发送端发送过来的）
        // 填充到 packet对象中 （这个是上面刚刚创建的 DatagramPacket对象）
        //说明：当有数据发送到 本机的9999端口时，就会接收到数据
        //      没有数据包，发送到本机的9999端口时，就会阻塞等待
        socket.receive(packet);

        //拆包 显示
        int length = packet.getLength();
        data = packet.getData();
        String s = new String(data, 0, data.length);
        System.out.println(s);

        //关闭资源
        socket.close();
        System.out.println("发送端A退出...");
    }
}
