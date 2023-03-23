package com.lhc.qqclient.service;

import com.lhc.qqcommon.Message;
import com.lhc.qqcommon.MessageType;
import com.lhc.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/16 20:56
 * @Description:
 *  该类完成：
 *  用户 登录验证/注册
 *  拉取在线列表
 *  退出系统
 */
public class UserClientService {
    //将User 做成一个属性,方便下面使用
    private User u = new User();
    //将socket 也做成一个属性，方便使用
    private Socket socket;

    //根据 userId 和 pwd, 到服务器端验证该用户是否合法
    public boolean checkUser(String userId, String pwd) {
        //定义一个属性 用于返回
        boolean b = false;

        u.setUserId(userId);
        u.setPassword(pwd);

        try {
            //连接服务器，发送 u对象
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            //得到ObjectOutputStream对象，将 u对象 传到 和socket 关联的数据通道 中
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);

            //读取从服务端 回复的 Message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();

            //判断 Message的类型
            if (ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) { //登录成功
                //创建一个服务器端保持通信的线程(将socket放到该线程中) --> 需要去创建一个线程类 ClientConnectServerThread
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                //启动客户端线程
                clientConnectServerThread.start();
                //这里为了以后客户端的扩展,将线程放到集合中
                ManageClientConnectServerThread.addClientConnectServerThread(userId, clientConnectServerThread);
                //将返回值改为true
                b = true;
            } else { //登录失败
                //我们就不能启动和服务器通信的线程,关闭socket
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return b;
    }

    //向服务器端发送请求,要求返回在线用户列表
    public void onlineFriendList() {
        try {
            //发送一个类型为:要求返回在线用户列表 的message
            Message message = new Message();
            message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
            message.setSender(u.getUserId()); //设置信息发送者

            //到 管理线程的集合中, 通过用户id 找到 这个线程对象
            ClientConnectServerThread clientConnectServerThread =
                    ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId());
            //再得到 该线程 持有的 socket对象
            Socket socket = clientConnectServerThread.getSocket();
            //获取一个输出流,将message对象 发送给服务器端
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //向服务器 发送请求，退出系统，并结束 客户端进程（进程关闭，则该用户下线）
    public void logout() {
        try {
            //创建message对象
            Message message = new Message();
            //指定消息类型
            message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
            //指定 信息的发送者
            message.setSender(u.getUserId());
            //获取 该用户对应的 socket对象，在通过这个socket对象，获取输出流
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            //将message 发送给服务器端
            oos.writeObject(message);
            //结束 进程
            System.exit(0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
