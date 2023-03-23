package com.lhc.qqclient.service;

import java.util.HashMap;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/16 23:40
 * @Description: 该类 管理客户端链接到服务器端的线程
 */
public class ManageClientConnectServerThread {
    //吧多个线程放入到HashMap集合中, key 就是用户id, value就是线程
    private static HashMap<String, ClientConnectServerThread> hm = new HashMap<>();

    //将某个线程加入到集合中
    public static void addClientConnectServerThread(String userId, ClientConnectServerThread clientConnectServerThread){
        hm.put(userId, clientConnectServerThread);
    }

    //通过userId可以获得 对应的线程
    public static ClientConnectServerThread getClientConnectServerThread(String userId){
        return hm.get(userId);
    }


}
