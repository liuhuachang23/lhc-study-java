package com.lhc.qqserver.service;

import com.lhc.qqcommon.Message;
import com.lhc.qqcommon.MessageType;
import com.lhc.utils.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/19 15:36
 * @Description:
 */
public class SendNewsToAllService implements Runnable {


    @Override
    public void run() {
        //为了可以多次推送,使用while循环
        while (true) {
            System.out.println("请输入服务器要推送的新闻/消息[输入 exit 表示退出推送服务]");
            String news = Utility.readString(1000);
            if ("exit".equals(news)){
                break;
            }
            // 创建message对象
            Message message = new Message();
            message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
            message.setContent(news);
            message.setSender("服务器");
            message.setSendTime(new Date().toString());
            System.out.println("服务器推送消息给所有人 说: " + news);
            //得到所有在线用户的线程,群发消息
            HashMap<String, ServerConnectClientThread> hm = ManageServerConnectClientThread.getHm();
            Iterator<String> iterator = hm.keySet().iterator();
            while (iterator.hasNext()) {
                try {
                    String onlineUserId = iterator.next();
                    ObjectOutputStream oos =
                            new ObjectOutputStream(hm.get(onlineUserId).getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
