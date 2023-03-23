package hsp.chapter07.circulation;

import java.util.Scanner;

/*
    判断一个整数是否为水仙花数
        水仙花数指的是:一个三位数,其中各个位置上数字立方和等于其本身
        例如:153 = 1*1*1 + 5*5*5 + 3*3*3
*/
public class Homework02 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输入一个三位数: ");
        int i = myScanner.nextInt();
        int i1 = i / 100;
        int i2 = i / 10 - i1*10;
        int i3 = i - (i/10)*10;
        if (i == i1*i1*i1 + i2*i2*i2 + i3*i3*i3){
            System.out.println("这个数是水仙花数");
        } else{
            System.out.println("这个数不是水仙花数");
        }
    }
}
