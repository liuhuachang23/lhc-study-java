package com.lhc.qqcommon;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/16 20:16
 * @Description: 信息类型
 */
public interface MessageType {
    //解读
    //1.接口中定义了一些常量
    //2.不同常量的值,表示不同的信息类型
    String MESSAGE_LOGIN_SUCCEED = "1"; //表示登入成功
    String MESSAGE_LOGIN_FAIL = "2"; //表示登入失败
    String MESSAGE_COMM_MES = "3"; //私发信息
    String MESSAGE_GET_ONLINE_FRIEND = "4"; // 要求返回在线用户列表
    String MESSAGE_RET_ONLINE_FRIEND = "5"; // 在线用户列表
    String MESSAGE_CLIENT_EXIT = "6"; //客户端请求退出
    String MESSAGE_TO_ALL_MES = "7"; //群发消息
    String MESSAGE_FILE_MES = "8"; //发送文件的信息


}
