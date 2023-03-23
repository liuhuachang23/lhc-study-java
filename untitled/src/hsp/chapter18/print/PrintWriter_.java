package hsp.chapter18.print;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/4 18:44
 * @Description: 演示 PrintWriter (字符打印流)
 */
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {

        //在默认情况下，PrintWriter 输出数据的位置是：标准输出（显示器）
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.print("hi, 北京你好~"); //在显示器输出

        //我们可以去修改打印流输出的位置/设备
        PrintWriter printWriter1 = new PrintWriter(new FileWriter("d:\\f2.txt"));
        printWriter1.print("hi, 北京你好~"); //在 d:\\f2.txt 文件中输出

        //Writer类 一定要记得关闭流 才会输出数据
        //close里面才是真正写数据的！！！
        printWriter.close(); //flush + 关闭流
        printWriter1.close();

    }
}
