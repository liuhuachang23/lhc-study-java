package hsp.chapter07.array;

import java.util.Scanner;
/*
* 数组扩容
*   要求:实现动态的给数组添加元素效果,实现对数组扩容
* */
public class ArrayAdd {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        //定义一个数组
        int[] arr = {1,2,3};
        do {
            //创建一个新的数组
            int[] arr2 = new int[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                arr2[i] = arr[i];
            }
            System.out.println("请输入你要添加的元素: ");
            int addNum = myScanner.nextInt();
            //给数组最后一个元素赋值
            arr2[arr2.length - 1] = addNum;
            //让arr数组指向arr2数组;原来的arr数组就会被垃圾回收器回收;
            arr = arr2;
            //遍历新的arr数组
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + "\t");
            }
            //s是否继续添加
            System.out.println("添加成功,是否继续添加 y/n");
            char answer = myScanner.next().charAt(0);
            if (answer == 'n'){
                System.out.println("停止添加,程序终止!");
                break;
            }
        } while (true);
    }
}
