package hsp.chapter07.classicexample;

import java.util.Scanner;

/*
* 接收用户输入的数据，判断是奇数还是偶数
* */
public class Test03 {
    public static void main(String[] args) {
        //接收用户输入
        System.out.println("请输入想要判断的数字: ");
        int a = new Scanner(System.in).nextInt();
        //判断奇偶
        if (a % 2 == 0){
            System.out.println(a + " 为偶数");
        } else {
            System.out.println(a + " 为奇数");
        }
    }
}
