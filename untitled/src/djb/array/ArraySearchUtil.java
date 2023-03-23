package djb.array;
/*
* 1、数组查找工具:自己写的,不是SUN公司的
* 2、关于查找算法中的：二分法查找
* 3、二分法查找算法是基于排序的基础之上的（要先排好序）
*
* 原理如下
*   10（下标0） 11 12 13 14 15 16 17 18 19 20（下标10）
*   通过二分法查找，找出18这个元素的下标：
*
*   先找中间元素的下标：
*   （0 + 10） / 2 --> 中间元素的下标：5
*
*   拿着中间元素和要查找的元素进行比对：
*   15 < 18
*   被查找的元素18在目前中间元素15的左边
*
*   进行第二次排查
*   开始元素的下标要变成 5+1=6
*
*   再重新计算中间元素的下标：
*   开始元素下标(6) + 结束元素下标(10) / 2 --> 8
*
*   中间下标的元素和要查找的元素比较：
*   发现 相等，所以此时中间元素就是我们要查找的元素，下标即为8
* */
public class ArraySearchUtil {
    public static void main(String[] args) {
        int[] arr = {100,200,230,235,600,1000,2000,9999};

        //需求：找出数组中200所在的下标
        //调用方法
        int index = binarySearch(arr,2000);
        System.out.println(index == -1 ? "该元素不存在" : "该元素的下标为：" + index);
    }

    /**
     * 从数组中查找目标元素的下标
     * @param arr 被查找的数组
     * @param dest 目标元素
     * @return 返回值大于大于0,表示检索元素的下标.返回值为-1,表示该元素不存在
     */
    private static int binarySearch(int[] arr, int dest) {

        //开始元素下标
        int begin = 0;
        //结束元素下标
        int end = arr.length - 1;

        //将二分法代码写入while循环
        //开始元素的下标只要再结束元素下标的左边或相等 即 begin <= end，就有机会继续循环
        // 当 begin > end （此时以无法再进行二分法） 时结束循环 返回 -1 （足以判断要查找的元素不存在）
        while (begin <= end) {
            //中间元素下标
            int mid = (begin + end) / 2;
            if (arr[mid] == dest) {
                //此时的中间元素即为目标元素
                return mid;
            } else if (arr[mid] < dest) {
                //开始元素变为
                begin = mid + 1;
            } else if (arr[mid] > dest) {
                //结束元素下标变为
                end = mid - 1;
            }
        }
        return -1;
    }
}
