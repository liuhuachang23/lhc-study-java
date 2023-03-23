package com.lhc.qqserver.service;

import com.lhc.qqcommon.Message;
import com.lhc.qqcommon.MessageType;
import com.lhc.qqcommon.User;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/17 10:17
 * @Description: 这是服务端，在监听9999端口，等待客户端的连接并保持通信
 */
public class QQServer {

    private ServerSocket ss = null;

    //创建一个HashMap集合,存放一些合法的用户
    //HashMap 没有处理线程安全，因此在多线程情况下是不安全
    //也可以使用 ConcurrentHashMap，可以处理并发的集合，不会出现线程安全问题
    //private static HashMap<String, User> validUsers = new HashMap<>();
    private static ConcurrentHashMap<String, User> validUsers = new ConcurrentHashMap<>();
    //创建一个集合 用于存储 离线留言
    private static ConcurrentHashMap<String, ArrayList<Message>> offLineDb = new ConcurrentHashMap<>();

    public static ConcurrentHashMap<String, ArrayList<Message>> getOffLineDb() {
        return offLineDb;
    }

    static { //在静态代码块,初始化 validUsers
        validUsers.put("刘华昌", new User("刘华昌","123456"));
        validUsers.put("吴小文", new User("吴小文","123456"));
        validUsers.put("猪八戒", new User("猪八戒","123456"));
        validUsers.put("嫦娥", new User("嫦娥","123456"));
        validUsers.put("紫霞仙子", new User("紫霞仙子","123456"));
        validUsers.put("至尊宝", new User("至尊宝","123456"));
    }

    //验证用户是否合法
    private boolean checkUser(String userId, String pwd){

        User user = validUsers.get(userId);
        if (user == null || !(user.getPassword().equals(pwd))){
            //用户id不存在, 或者 用户的密码不正确 ,则用户不合法
            return false;
        }
        return true;
    }

    public QQServer() {

        try {
            //创建一个ServerSocket （端口可以写在配置文件中）
            ss = new ServerSocket(9999);
            System.out.println("服务器在9999端口监听...");

            //启动推送新闻的线程
            new Thread(new SendNewsToAllService()).start();

            while (true) { //当和某个客户端建立连接后，会得到一个socket对象，并继续保持监听，因此使用循环

                Socket socket = ss.accept(); //当没有客户端连接,就会阻塞在此
                //得到一个 和 socket关联的 数据通道(得到一个输入流)
                InputStream inputStream = socket.getInputStream();
                //通过输入流，读取 客户端发送到该数据通道的 数据(User对象)
                ObjectInputStream ois = new ObjectInputStream(inputStream);
                User u = (User) ois.readObject();

                //创建一个message对象
                Message message = new Message();
                //创建一个输出流，用于下面验证完成后，将 对应的message对象发送给 客户端
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                //验证该用户是否合法（到数据库去验证，这里使用集合代替）
                if (checkUser(u.getUserId(),u.getPassword())) {

                    //该用户合法，向客户端回复一个 代表登录成功的 Message对象
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    oos.writeObject(message);
                    //创建一个线程(将正在与服务器端通信的 客户端用户id 和 socket放到该线程中)，用于和客户端保持通信 --> 创建 serverConnectClientThread 类
                    ServerConnectClientThread serverConnectClientThread =
                            new ServerConnectClientThread(socket, u.getUserId());
                    //启动线程
                    serverConnectClientThread.start();
                    //便于管理，将线程放入集合中  --> 创建一个 管理线程的 ManageServerConnectClientThread 集合类
                    ManageServerConnectClientThread.addServerConnectClientThread(u.getUserId(), serverConnectClientThread);
                    // 调用方法 显示 离线信息

                } else {
                    //该用户不合法
                    System.out.println("用户 id=" + u.getUserId() + " pwd=" + u.getPassword() + " 验证失败");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    //关闭socket
                    socket.close();
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //当退出 while 循环时,表示服务器端停止监听,关闭ServerSocket
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
