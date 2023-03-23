package hsp.chapter18.standard;

import java.util.Scanner;

public class InputAndOutput {
    public static void main(String[] args) {
        //System.in 表示标准输入 默认设备为键盘
        //Stream类 的 public final static InputStream in = null;
        //System.in 编译类型 InputStream
        //System.in 运行类型 BufferedInputStream
        System.out.println(System.in.getClass());

        //System.out 表示标准输出 默认设备为显示器
        //Stream类 的 public final static PrintStream out = null;
        //System.out 编译类型 PrintStream
        //System.out 运行类型 PrintStream
        System.out.println(System.out.getClass());

        //标准输出流案例:
        //传统方法: System.out.println("")方法就是使用 out对象 将数据输出到显示器
        System.out.println("吴小文~~");

        //标准输入流案例:
        //传统方法: Scanner 就是从标准输入键盘接收数据
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入内容: ");
        String next = scanner.next();
        System.out.println("next: " + next); //打印出键盘输入的内容


    }
}
