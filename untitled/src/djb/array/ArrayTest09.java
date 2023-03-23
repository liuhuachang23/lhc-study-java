package djb.array;
/*
* 关于java中的二维数组
*   1、二维数组其实是一个特殊的一维数组，特殊在在这个一维数组中的每一个元素都是一个一维数组。
*   2、
* */
public class ArrayTest09 {
    public static void main(String[] args) {
        //一维数组
        int[] array = {100,233,431};

        //二维数组
        int[][] a = {
                {1,1,3,5,22},
                {4,6,33,66},
                {23}
        };
        System.out.println(a.length); //3

        System.out.println(a[0].length); //5
        System.out.println(a[1].length); //4

        //
    }
}
