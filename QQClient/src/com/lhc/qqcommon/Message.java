package com.lhc.qqcommon;

import java.io.Serializable;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/16 20:11
 * @Description: 表示 客户端 和 服务器端 通信时的信息对象
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private String sender; //发送者
    private String getter; //接收者
    private String content; //信息内容
    private String sendTime; //发送时间
    private String mesType; //信息类型 [可以在接口定义信息类型]

    //扩展 和文件相关的成员
    private byte[] fileBytes; //存储文件的 字节数组
    private int fileLen = 0;  // 文件的大小(长度)
    private String src; //源文件路径
    private String dest; //将文件传输的目标路径


    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    public int getFileLen() {
        return fileLen;
    }

    public void setFileLen(int fileLen) {
        this.fileLen = fileLen;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }
}
