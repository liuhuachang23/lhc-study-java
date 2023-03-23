package hsp.chapter18.transformation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/4 17:07
 * @Description: 演示OutputStreamWriter的使用
 * 把 FileOutputStream（字节流） 转换成 OutputStreamWriter（字符流）
 * 指定编码格式 gbk/utf-8 （用来设置文件的编码格式）
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String charset = "gbk";
        String filePath = "d:\\a.txt";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath),charset);
        osw.write("wwl是猪");

        osw.close();
        System.out.println("保存文件成功");
    }
}
