package djb.exercise.untitled.src.circulation;

import java.util.Scanner;

public class Stars {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("需要打印的金字塔层数为: ");
        int totalLevel = myScanner.nextInt();

        int i = totalLevel;
        int j = 0;
        for (; i > 0 ; i--) {
            for (; j < i ; j++) {
                System.out.print(" ");
            }
            if (i == j){
                System.out.println("*");
            }
        }
    }
}
