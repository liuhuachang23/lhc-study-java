package hsp.chapter07.classicexample;

import java.util.Scanner;

/*
* 输入数字1~7，输出对应星期几
* */
public class Test04 {
    public static void main(String[] args) {
        //提示并接收用户输入的数据
        System.out.println("请输入数字：");
        int a = new Scanner(System.in).nextInt();
        //输出对应的星期数
        if (a == 1){
            System.out.println("星期一");
        }else if (a == 2){
            System.out.println("星期二");
        }else if (a == 3){
            System.out.println("星期三");
        }else if (a == 4){
            System.out.println("星期四");
        }else if (a == 5){
            System.out.println("星期五");
        }else if (a == 6){
            System.out.println("星期六");
        }else if (a == 7){
            System.out.println("星期日");
        } else {
            System.out.println("你输入的数字不合法！");
        }
    }
}
