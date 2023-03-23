package hsp.chapter18.homework;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.*;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/4 21:22
 * @Description:
 *  使用BufferedReader读取一个文本文件，为每行加上行号，连同内容一并输出到屏幕上
 *  增加难度: 将文件编码格式改为 ANSI 后, 在输出到屏幕上,要求不允许出现乱码
 */
public class Homework02 {
    public static void main(String[] args) throws IOException {

        String filePath = "d:\\note.txt";

        //BufferedReader br = new BufferedReader(new FileReader(filePath));
        //使用转换流 将 FileReader 转换成 InputStreamReader 指定编码格式 , 在包装成 BufferedReader 按行输出到控制台上
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"gbk"));
        String line = "";
        int lineNum = 0;
        while ((line = br.readLine()) != null){
            System.out.println(++lineNum + ") " + line);
        }
        if (line == null) {
            br.close();
        }
    }
}
