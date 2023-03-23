package hsp.chapter18.transformation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//看一个编码问题
public class CodeQuestion {
    public static void main(String[] args) throws IOException {
        // 读取 d:\\a.txt文件到程序
        //1. 创建字符输入流 使用BufferedReader（处理流）
        //2. 使用 BufferedReader 对象读取 a.txt 文件
        //3. 默认情况下,读取文件是按照 utf-8 编码
        //4. 如果文件的编码方式不是 utf-8  就会出现乱码
        //5. 怎么解决: 使用转换流(也是一种处理流) 可以指定文件的编码格式
        String filePath = "d:\\a.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String s = bufferedReader.readLine();
        System.out.println(s);

        bufferedReader.close();
    }
}
