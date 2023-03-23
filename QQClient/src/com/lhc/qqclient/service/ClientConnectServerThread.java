package com.lhc.qqclient.service;

import com.lhc.qqcommon.Message;
import com.lhc.qqcommon.MessageType;
import com.lhc.qqcommon.User;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/16 21:20
 * @Description: 创建一个 和服务器端保持通信的 线程类 (接收服务器发送的数据,进行相应处理)
 */
public class ClientConnectServerThread extends Thread {
    //该线程需要持有 socket
    private Socket socket;


    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //线程需要在后台需要和服务器保持通信
        while (true) {
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //如果服务器没有发送message对象,线程会阻塞在这里
                Message message = (Message) ois.readObject();
                //如果接收到了服务器 发过来的 message 先判断 信息类型
                if (message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) { //信息类型为 在线用户列表
                    //取出在线用户列表 并显示
                    String[] onlineUser = message.getContent().split(" ");
                    System.out.println("\n=========当前在线用户列表==========");
                    for (int i = 0; i < onlineUser.length; i++) {
                        System.out.println("用户：" + onlineUser[i]);
                    }

                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) { //私发信息
                    //把服务器转发的 message对象，显示
                    System.out.println("\n" + message.getSender() + " 对 " + message.getGetter() + " 说 " + message.getContent());

                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) { //群发消息
                    //把服务器转发的 message对象，显示
                    System.out.println("\n" + message.getSender() + " 对大家伙说: " + message.getContent());

                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) { //文件信息
                    //提示信息
                    System.out.println("\n" + message.getSender() + " 给 " + message.getGetter() +
                            " 发送文件: " + message.getSrc() + " 到对方的电脑目录: " + message.getDest());
                    //将文件存储到 指定的位置
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(message.getDest()));
                    bos.write(message.getFileBytes());
                    bos.close();
                    System.out.println("\n保存文件成功");
                } else {
                    System.out.println("其他的信息,稍作处理");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
