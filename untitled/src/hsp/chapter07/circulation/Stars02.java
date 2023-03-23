package hsp.chapter07.circulation;

import java.util.Scanner;
//空心金字塔
public class Stars02 {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.print("需要打印的金字塔层数为: ");
        int totalLevel = myScanner.nextInt();

        int i = totalLevel;
        int count = -1;
        while (i > 0) {
            int j = 1;
            for (; j <= i ; j++) {
                //打印空格
                if (j < i){
                    System.out.print(" ");
                }
                //建立金字塔
                if (i == j){
                    //打印每层第一个*
                    System.out.print("*");
                    //打印金字塔里面的空格
                    if (i != 1) {
                        for (int k = 0; k < count; k++) {
                            System.out.print(" ");
                        }
                        //打印每层的最后一个*
                        if (i != totalLevel) {
                            System.out.print("*");
                        }
                    } else {
                        //打印金字塔底层
                        for (int k = 0; k <count+1 ; k++) {
                            System.out.print("*");
                        }
                    }
                }
            }
            //循环完一层后换行
            System.out.println();

            i -= 1;
            //记录每一层所需打印的*数
            count += 2;
        }
    }
}

