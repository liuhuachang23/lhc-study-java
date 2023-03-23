package hsp.chapter18.buffered;

import java.io.*;
/*
* 字节处理流拷贝文件
* 使用 BufferedInputStream 和 BufferedOutputStream
* 注意: 字节流可以操作一切数据，包括 二进制文件、文本文件
* */
public class BufferedCopy02 {
    public static void main(String[] args) {
        String srcFilePath = "d:\\wwl.jpg";
        String destFilePath = "d:\\wwlCopy.jpg";

        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(srcFilePath));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFilePath));
            byte[] buff = new byte[1024];
            int readLen;
            while ((readLen = bufferedInputStream.read(buff)) != -1){
                bufferedOutputStream.write(buff,0,readLen);
            }
            System.out.println("拷贝成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedInputStream.close();
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
