package hsp.chapter07.circulation;

import java.util.Scanner;

//打印出空心菱形（加强版）
public class Stars04 {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.print("需要打印出的空闲菱形层数为：");
        int totalLevel = myScanner.nextInt();

        //上半部分
        for (int i = 1; i <= (totalLevel + 1)/2; i++) {

            //打印每层金字塔之前的空格(层数-层号)
            for (int j = 1; j <= (totalLevel + 1)/2-i; j++) {
                System.out.print(" ");
            }
            //打印每层金字塔的*数(层数*2-1)
            for (int j = 1; j <= i*2-1 ; j++) {
                //创建空心金字塔
                //除最底层外,每层只保留最前面和最后面的*,其他全部挖空
                if (j == 1 || j == i*2-1){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        //下半部分
        for (int i = totalLevel/2; i >= 0 ; i--) {

            //打印每层金字塔之前的空格(层数-层号)
            for (int j = 1; j <= (totalLevel + 1)/2-i; j++) {
                System.out.print(" ");
            }
            //打印每层金字塔的*数(层数*2-1)
            for (int j = i*2-1; j >= 0; j--) {
                //创建空心金字塔
                //除最底层外,每层只保留最前面和最后面的*,其他全部挖空
                if (j == 1 || j == i*2-1){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}
