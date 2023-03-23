package hsp.chapter12.exception;

import java.util.Scanner;

//如果用户输入不是一个整数,就提示他重新输入,直到输入一个整数为止
public class TryCatchExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数: ");
        int i = 0;
        while (true){

            String str = scanner.next();
            try {
                i = Integer.parseInt(str);
                break;
            } catch (Exception e) {
                System.out.println("你输入的不是一个整数,请重新输入:  ");
            }
        }
        System.out.println("你输入的整数为 " + i);
    }
}
