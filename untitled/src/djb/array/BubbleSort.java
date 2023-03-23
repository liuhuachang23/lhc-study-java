package djb.array;
/*
* 冒泡排序算法
*
* */
public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = {6, 2, 5, 7, 3, 1};
        int count = 0;

        for (int i = arr.length-1; i > 0 ; i--) {
            for (int j = 0; j <i ; j++) {
                //判断大小，交换位置
                if (arr[j] > arr[j+1]){
                    int temp;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    //记录交换的次数
                    count++;
                }
            }
        }

        //排序之后的顺序
        for (int i = 0; i <arr.length; i++) {
            System.out.println(arr[i]);
        }

        //交换次数
        System.out.println("交换的次数--> " + count);
    }
}
