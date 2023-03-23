package hsp.chapter18.print;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/4 17:36
 * @Description: 演示 PrintStream（字节打印流）
 *
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        //在默认情况下，PrintStream 输出数据的位置是：标准输出（显示器）
        /* print() 源码：
            public void print(String s) {
                if (s == null) {
                    s = "null";
                }
                write(s);
            }
         */
        out.print("wwl，hello"); //在显示器输出
        //由源码可知，print底层使用的是write，所以我们也可以直接调用write进行打印/输出
        //如果传入的是字符串，需要将字符串转换为 byte[] (PrintStream 为字节流)
        out.write("wwl，hello".getBytes()); //在显示器输出
        out.close();

        //我们可以去修改打印流输出的位置/设备
        //修改成d:\f1.txt
        /*  setOut底层:
            public static void setOut(PrintStream out) {
                checkIO();
                setOut0(out); //这是一个native方法(底层是c++) 修改了out
            }
         */
        System.setOut(new PrintStream("d:\\f1.txt"));
        System.out.println("hello wwl"); //输出到修改后的位置：d:\f1.tx

        out.close();

    }
}
