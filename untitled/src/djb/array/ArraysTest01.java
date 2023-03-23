package djb.array;
/*
*SUN公司已经为我们程序员写好了一个数组工具类:
*   java.util.Arrays;
*
*   工具类有哪些方法，我们开发的时候要参考API帮助文档，不需要死记硬背
* */
import java.util.Arrays;

public class ArraysTest01 {
    public static void main(String[] args) {

        int[] arr = {3,6,5,12,1,2,32,5,5};
        //排序
        Arrays.sort(arr);
        //输出
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }

        //二分法查找
        int index =  Arrays.binarySearch(arr,32);
        System.out.println(index == -1 ? "该元素不存在" : "该元素下标为：" + index);
    }
}
