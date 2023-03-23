package hsp.chapter07.array;

import java.util.Scanner;

//数组的缩减
public class ArrayReduce {
    public static void main(String[] args) {
        //创建一个数组
        int[] arr = {1,2,3,4,5};

        Scanner myScanner = new Scanner(System.in);

        do {
            System.out.println("请输入需要减少元素的数量: ");
            int ReduceNum = myScanner.nextInt();
            if (ReduceNum >= arr.length){
                System.out.println("你所需缩减的元素过多");
                break;
            }
            //创建一个新的数组
            int[] arr2 = new int[arr.length - ReduceNum];

            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = arr[i];
            }

            //让arr数组指向arr2数组;原来的arr数组就会被垃圾回收器回收;
            arr = arr2;

            //重新遍历arr数组
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + "\t");
            }
            System.out.println("操作成功,是否需要继续减少 y/n ");
            char answer = myScanner.next().charAt(0);
            if (answer == 'n'){
                System.out.println("停止减少,程序结束!");
                break;
            } else if (arr.length == 1){
                System.out.println("该数组不能在减少了!");
                break;
            }
        } while (true);
    }
}
