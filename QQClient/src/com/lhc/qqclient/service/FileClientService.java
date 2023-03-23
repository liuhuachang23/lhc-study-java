package com.lhc.qqclient.service;

import com.lhc.qqcommon.Message;
import com.lhc.qqcommon.MessageType;
import com.lhc.qqcommon.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/19 14:29
 * @Description: 该类完成 文件传输
 */
public class FileClientService {

    /**
     * @param src      源文件路径
     * @param dest     目标路径
     * @param sendId   发送者用户id
     * @param getterId 接收者用户id
     */
    public void sendFileToOne(String src, String dest, String sendId, String getterId) {
        //读取 src 文件 ----> message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_FILE_MES);
        message.setSender(sendId);
        message.setGetter(getterId);
        message.setSrc(src);
        message.setDest(dest);

        FileInputStream fileInputStream = null;
        //创建一个字节数组(大小长度和 源文件大小一样)
        byte[] fileBytes = new byte[(int) new File(src).length()];
        try {
            //读取磁盘中的文件到 程序的fileByte数组中
            fileInputStream = new FileInputStream(src);
            fileInputStream.read(fileBytes); //将src文件读入到 程序的字节数组中

            //将这个数组,封装到message对象中
            message.setFileBytes(fileBytes);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //提示信息
            System.out.println("\n" + sendId + " 给 " + getterId + " 发送文件: " + src + " 到对方的电脑目录: " + dest);

            //发送
            try {
                ObjectOutputStream oos =
                        new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(sendId).getSocket().getOutputStream());
                oos.writeObject(message);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
