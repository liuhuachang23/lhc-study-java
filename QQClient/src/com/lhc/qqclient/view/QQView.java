package com.lhc.qqclient.view;

import com.lhc.qqclient.service.FileClientService;
import com.lhc.qqclient.service.MessageClientService;
import com.lhc.qqclient.service.UserClientService;
import com.lhc.qqclient.utils.Utility;


/**
 * @Auther: 刘华昌
 * @Date: 2022/4/16 20:22
 * @Description: 客户端 菜单界面
 */
public class QQView {
    private boolean loop = true; //用来控制是否显示菜单
    private String key = ""; //接收用户输入
    private UserClientService userClientServer = new UserClientService(); //对象是用于提供 登录/注册服务
    private MessageClientService messageClientService = new MessageClientService(); //用于提供 消息 服务
    private FileClientService fileClientService = new FileClientService(); //用于提供 文件 服务
    public static void main(String[] args) {
        new QQView().maimMenu();
        System.out.println("客户端退出系统");
    }

    //显示主菜单
    private void maimMenu() {
        while (loop) {

            System.out.println("===========欢迎登录网络登入系统===========");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.print("请输入您的选择: ");
            key = Utility.readString(1);

            //根据用户的输入,来处理不同的逻辑
            switch (key) {
                case "1":
                    System.out.print("请输入用户号: ");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密  码: ");
                    String pwd = Utility.readString(50);

                    //这里就需要发送到服务端,去验证该用户是否合法
                    //...我们这里编写一个类 UserClientServer[用户登录/注册]
                    if (userClientServer.checkUser(userId, pwd)) {
                        System.out.println("===========欢迎 (用户 " + userId + " 登录成功)===========");
                        //进入到二级菜单
                        while (loop) {
                            System.out.println("===========网络通信系统二级菜单(用户 " + userId + " )===========");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");

                            System.out.print("请输入您的选择: ");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    //在UserClientService类 中编写一个方法,去和服务器端通信,要求返回在线用户列表
                                    userClientServer.onlineFriendList();
                                    break;
                                case "2":
                                    System.out.println("请输入想对大家说的话: ");
                                    String pubContent = Utility.readString(100);
                                    //调用一个方法, 将信息发送给服务器
                                    messageClientService.sendMessageToAll(pubContent, userId);
                                    break;
                                case "3":
                                    System.out.println("请输入想聊天的用户id（在线）：");
                                    String getterId = Utility.readString(50);
                                    System.out.println("请输入想说的话：");
                                    String content = Utility.readString(100);
                                    //在UserClientService类 中编写一个方法，连接服务器，发送给服务器
                                    messageClientService.sendMessageToOne(content, userId, getterId);
                                    break;
                                case "4":
                                    System.out.println("请输入想发送的用户id(在线): ");
                                    getterId = Utility.readString(50);
                                    System.out.println("请输入想发送的源文件路径(形式: d:\\xx.jpg): ");
                                    String src = Utility.readString(50);
                                    System.out.println("请输入想发送文件到对方的位置(形式: d:\\xx.jpg): ");
                                    String dest = Utility.readString(50);
                                    //创建一个FileClientService 类,用于完成文件传输
                                    fileClientService.sendFileToOne(src,dest,userId,getterId);
                                    break;
                                case "9":
                                    //调用方法，给服务器发送一个退出系统的message，并关闭客户端进程
                                    userClientServer.logout();
                                    loop = false;
                                    break;
                            }
                        }
                    } else {

                        System.out.println("登录失败....");
                    }
                    break;
                case "9":
                    loop = false;
                    break;
            }
        }
    }
}
