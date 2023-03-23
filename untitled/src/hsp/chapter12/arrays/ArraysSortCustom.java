package hsp.chapter12.arrays;

import java.util.Arrays;
import java.util.Comparator;
//模拟 ArraysMethod01 中的,定制排序
public class ArraysSortCustom {
    public static void main(String[] args) {
        int[] arr = {1, 20, 4, 3, 16};

        System.out.println("排序后的情况");

        bubble02(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer) o1;
                int i2 = (Integer) o2;
                return i2 - i1;
            }
        });

        System.out.println(Arrays.toString(arr));

    }

    //使用冒泡排序
    public static void bubble01(int[] arr) {

        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //从小到大
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //定制排序(综合冒泡+定制)
    public static void bubble02(int[] arr, Comparator c) {

        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //c.compare(arr[j],arr[j+1]) > 0)会动态绑定到 main() 中的 compare()，
                // 返回一个值（return i2 - i1;）
                //数组的排序,由这个返回的值 来决定
                if (c.compare(arr[j],arr[j+1]) > 0) { //大于0就交换
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
