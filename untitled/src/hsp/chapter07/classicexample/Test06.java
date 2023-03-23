package hsp.chapter07.classicexample;

import java.util.Scanner;

/*
* 求指定两个数的最大公约数和最小公倍数
* */
public class Test06 {
    public static void main(String[] args) {

        //用户输入两个数字
        System.out.println("请输入两个数：");
        int a = new Scanner(System.in).nextInt();
        int b = new Scanner(System.in).nextInt();
        //调用求最大公约数的方法
        int x = zdgys(a,b);
        //调用求最小公倍数的方法
        long y = zxgbs(a,b);

        //输出结果
        System.out.println(a + "与" + b + "的最大公约数是：" + x);
        System.out.println(a + "与" + b + "的最小公倍数是：" + y);

    }
    //计算最大公约数的方法
    public static int zdgys(int a, int b){
        //取更小的那个数
        int min = a < b ? a : b;
        //求最大公约数
        for (int i = min ; i >= 1 ; i--) {
            if (a % i == 0 && b % i == 0){
                return i;
            }
        }
        //程序不可能执行到这里，只是为了不让程序报错
        return 0;
    }

    //计算最小公倍数的方法
    public static long zxgbs(int a,int b){
        //取更大的哪一个数
        int max = a > b ? a : b;
        //求最小公倍数
        for (long i = max; ; i++){
            if (i % a == 0 && i % b == 0 ){
                return i;
            }
        }
    }
}
