package hsp.chapter07.array;

import java.util.Scanner;

/*
已知有一个升序的数组,要求插入一个元素,该数组顺序依然是升序,
比如: [10,12,45,90],添加23后,数组为[10,12,23,45,90]
*/
public class Homework01 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        //创建一个数组
        int[] arr = {10,12,45,90};
        do {
            //创建一个新的数组
            int[] arr2 = new int[arr.length + 1];

            System.out.println("请输入需要添加的元素: ");
            int addNum = myScanner.nextInt();

            //这里我们选择将新的元素添加到数组中的第一个元素的位置上
            arr2[0] = addNum;
            //将原arr数组中的元素拷贝到arr2中
            for (int i = 0; i < arr.length; i++) {
                arr2[i + 1] = arr[i];
            }
            //让arr数组指向arr2数组;原来的arr数组就会被垃圾回收器回收;完成数组的添加
            arr = arr2;
            //排序
            //考虑用第一个元素与后面的元素比较,前面的更大就交换位置,否则位置不变
            //定义一个变量,便于后面的元素交换
            int temp;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }

            //遍历
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            //是否需要继续添加
            System.out.println("是否需要继续添加: y/n");
            char answer = myScanner.next().charAt(0);
            if (answer != 'y'){
                System.out.println("没有继续添加,程序结束!");
                break;
            }
        } while (true);
    }
}
