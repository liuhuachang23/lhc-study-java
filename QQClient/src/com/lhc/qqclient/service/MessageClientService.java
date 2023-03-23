package com.lhc.qqclient.service;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

import com.lhc.qqcommon.Message;
import com.lhc.qqcommon.MessageType;
import com.lhc.qqcommon.User;

import java.net.Socket;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/18 19:05
 * @Description: 该类提供 消息（私聊，群聊，消息推送） 相关的服务
 */
public class MessageClientService {

    /**
     * 向指定用户 发送私聊消息
     *
     * @param content  内容
     * @param senderId 发送用户id
     * @param getterId 接收用户id
     */
    public void sendMessageToOne(String content, String senderId, String getterId) {
        try {
            //创建 message对象
            Message message = new Message();
            message.setContent(content);
            message.setSender(senderId);
            message.setGetter(getterId);
            message.setSendTime(new Date().toString());
            message.setMesType(MessageType.MESSAGE_COMM_MES);

            //向服务器发送 message对象
            System.out.println(senderId + " 对 " + getterId + " 说 " + content);
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendMessageToAll(String pubContent, String senderId) {

        try {
            //创建message对象,将信息封装到里面
            Message message = new Message();
            message.setSendTime(new Date().toString());
            message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
            message.setSender(senderId);
            message.setContent(pubContent);

            //向服务器发送 message
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
