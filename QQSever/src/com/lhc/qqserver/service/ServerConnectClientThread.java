package com.lhc.qqserver.service;

import com.lhc.qqcommon.Message;
import com.lhc.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/17 11:01
 * @Description: 创建一个 和客户端端保持通信的 线程类
 */
public class ServerConnectClientThread extends Thread {
    //该线程持有 socket对象
    private Socket socket;
    //连接到服务端的用户id
    private String userId;


    ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;

    }

    @Override
    public void run() { //线程处于运行状态，可以 发送/接收 信息

        //向 在线用户发送 离线信息
        ConcurrentHashMap<String, ArrayList<Message>> offLineDb = QQServer.getOffLineDb();
        if (offLineDb.get(userId) != null){
            Iterator<Message> iterator = offLineDb.get(userId).iterator();
            while (iterator.hasNext()){
                try {
                    Message message = iterator.next();
                    ObjectOutputStream oos =
                            new ObjectOutputStream(ManageServerConnectClientThread.getServerConnectClientThread(userId).getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


        while (true) {

            try {

                System.out.println("服务端和客户端 " + userId + " 保持通信，读取数据");
                //得到一个输入流, 读取 客户端 发送过来 的数据
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();

                //得到客户端 发来的 message 对象 后 先判断 信息类型
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {//信息类型为:要求返回在线用户列表

                    System.out.println(message.getSender() + " 要在线用户列表");
                    //调用 管理线程集合 中的 getOnlineUser()方法 得到在线用户列表
                    String onlineUser = ManageServerConnectClientThread.getOnlineUser();
                    //创建一个 message 对象，将信息 封装到里面，回送给客户端
                    Message message2 = new Message();
                    message2.setContent(onlineUser);
                    message2.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message2.setGetter(message.getSender());
                    //返回给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message2);

                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) { //信息类型:退出系统
                    System.out.println(message.getSender() + " 退出");

                    //删除 线程集合中 该用户对应的线程
                    ManageServerConnectClientThread.delServerConnectClientThread(message.getSender());
                    //关闭 客户端与 该用户通信 的socket
                    socket.close();
                    //退出 while() 循环
                    break;

                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) { //信息类型: 私发消息
                    // 根据message 获取 getter
                    String getter = message.getGetter();
                    //判断该用户是否在线(判断用户线程是否存在)
                    if (ManageServerConnectClientThread.getServerConnectClientThread(getter) != null) {
                        // 根据getter 获取 对;应的 线程 及持有的socket对象
                        Socket socket = ManageServerConnectClientThread.getServerConnectClientThread(getter).getSocket();
                        //根据socket 得到 关联的输出流
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        //转发信息到 私聊对象的客户端
                        oos.writeObject(message);
                    } else { //该用户不在线
                        //将此message 暂存于 OffLineDb集合 的 ArrayList<Message>中
                        if (QQServer.getOffLineDb().get(getter) == null){
                            ArrayList<Message> messages = new ArrayList<>();
                            messages.add(message);
                            QQServer.getOffLineDb().put(getter,messages);
                        } else {
                            QQServer.getOffLineDb().get(getter).add(message);
                        }

                    }


                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) { //群发消息
                    //得到 在线用户的 线程集合
                    HashMap<String, ServerConnectClientThread> hm = ManageServerConnectClientThread.getHm();
                    //遍历线程集合
                    Iterator<String> iterator = hm.keySet().iterator();
                    while (iterator.hasNext()) {
                        String onlineUserId = iterator.next();
                        if (onlineUserId != message.getSender()) { //得到(除发送者本身以外) 客户端 对应的输出流
                            ObjectOutputStream oos =
                                    new ObjectOutputStream(hm.get(onlineUserId).getSocket().getOutputStream());
                            //发送消息
                            oos.writeObject(message);
                        }

                    }
                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) { //文件信息
                    // 拆解message, 得到文件传输的目标用户,并获得该用户的线程 进行文件转发
                    ObjectOutputStream oos =
                            new ObjectOutputStream(ManageServerConnectClientThread.getServerConnectClientThread(message.getGetter()).getSocket().getOutputStream());
                    oos.writeObject(message);

                } else {
                    System.out.println("其他信息类型,暂不处理....");
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
