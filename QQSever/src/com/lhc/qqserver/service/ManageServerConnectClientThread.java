package com.lhc.qqserver.service;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/17 11:27
 * @Description: 该类用于 管理 服务端连接客户端的线程
 */
public class ManageServerConnectClientThread {

    //吧多个线程放入到HashMap集合中, key 就是用户id, value就是线程
    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

    //返回 hm
    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }

    //将某个线程加入到集合中
    public static void addServerConnectClientThread(String userId, ServerConnectClientThread serverConnectClientThread) {
        hm.put(userId, serverConnectClientThread);
    }

    //通过用户id 得到该线程
    public static ServerConnectClientThread getServerConnectClientThread(String userId) {
        return hm.get(userId);
    }

    //通过用户id 删除线程
    public static void delServerConnectClientThread(String userId) {
        hm.remove(userId);
    }

    // 编写方法，可以返回在线用户列表
    //我们把在线用户列表 做成这种形式（便于客户端拆解message 得到在线用户列表）：1001 1002 至尊宝
    public static String getOnlineUser() {
        //遍历 集合
        Iterator<String> iterator = hm.keySet().iterator();
        String onlineUser = "";
        while (iterator.hasNext()) {
            String key = iterator.next();
            onlineUser += key + " ";
        }
        return onlineUser;
    }

}
