package hsp.chapter20;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/14 18:58
 * @Description: 演示 INetAddress 类的使用
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {

        //1. getLocalHost：获取 本机 InetAddress对象（本机名/ip地址）
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost); // DESKTOP-9CB5SEV/172.20.10.3

        //2. getByName：指定 主机名/域名 获取 ip地址对象（主机名/ip地址 或者 域名/IP地址）

        //  2.1指定主机名
        InetAddress host1 = InetAddress.getByName("DESKTOP-9CB5SEV");
        System.out.println(host1); //DESKTOP-9CB5SEV/172.20.10.3
        //  2.2指定域名
        InetAddress host2 = InetAddress.getByName("www.baidu.com"); //指定域名
        System.out.println(host2); //www.baidu.com/14.215.177.38

        //3. getHostAddress() : 通过 InetAddress对象，获取主机对应的ip地址
        String hostAddress = host2.getHostAddress();
        System.out.println(hostAddress); //14.215.177.38

        //4. getHostName() : 通过 InetAddress对象，获取对应的 主机名/域名
        String hostName = host2.getHostName();
        System.out.println(hostName); //www.baidu.com

    }
}
