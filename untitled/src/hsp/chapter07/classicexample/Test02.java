package hsp.chapter07.classicexample;

import java.util.Scanner;
/*
* 接收用户输入的3个整数,并将它们的最大值作为结果输出
* */
public class Test02 {
    public static void main(String[] args) {
        //在控制台上输出3个字
        System.out.println("请输入第一个数: ");
        /*Scanner a = new Scanner(System.in);
        int a1  = a.nextInt();*/
        //代码可以合并为
        int a1 = new Scanner(System.in).nextInt();

        System.out.println("请输入第二个数: ");
        Scanner b = new Scanner(System.in);
        int b1 = b.nextInt();

        System.out.println("请输入第三个数: ");
        Scanner c = new Scanner(System.in);
        int c1 = c.nextInt();

        //判断第一个数和第二个数的大小
        int i1 = a1 > b1 ? a1 : b1;
        //拿出较大的数再与第三个数进行比较，输出最大值
        int i2 = i1 > c1 ? i1 : c1;
        System.out.println("结果为: " + i2);

    }
}
