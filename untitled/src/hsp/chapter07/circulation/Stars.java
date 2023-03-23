package hsp.chapter07.circulation;

import java.util.Scanner;
//金字塔
public class Stars {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.print("需要打印的金字塔层数为: ");
        int totalLevel = myScanner.nextInt();

        int i = totalLevel;
        int count = 1;
        while (i > 0) {
            int j = 1;
            for (; j <= i ; j++) {
                if (j < i){
                    System.out.print(" ");
                }
                if (i == j){
                    for (int k = 0; k <count ; k++) {
                        System.out.print("*");
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
