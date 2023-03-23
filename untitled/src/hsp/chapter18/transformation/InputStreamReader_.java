package hsp.chapter18.transformation;

import java.io.*;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/4 16:51
 * @Description: 使用 InputStreamReader 转换流解决中文乱码问题
 * 将字节流 FileInputStream（字节流） 转换成 InputStreamReader（字符流）
 * 指定编码 gbk/utf-8 (要求指定和待读取文件一样的编码格式)
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "d:\\a.txt";
        //1. 把FileInputStream 转成 InputStreamReader
        //2. 指定编码
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath),"gbk");
        //3. 把 InputStreamReader 传入 BufferedReader
        BufferedReader br = new BufferedReader(isr);
        //4. 读取
        String s = br.readLine();
        //5. 输出
        System.out.println(s);
        br.close();


    }
}
