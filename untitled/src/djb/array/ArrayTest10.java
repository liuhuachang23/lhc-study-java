package djb.array;
/*
* 关于二维数组中元素的，读、改
* */
public class ArrayTest10 {
    public static void main(String[] args) {
        //二维数组
        int[][] a = {
                {24,23,4},
                {23,4,111,333},
                {0,11,345,77},
                {92}
        };

        //读

        //请取出以上二维数组上的第1个一维数组,中的第1个元素
        int[] a0 = a[0];
        int a00 = a0[0];
        System.out.println(a00); //24
        //合并
        System.out.println(a[0][0]); //24

        //请取出以上二维数组中第3个一维数组，中的第2个元素
        System.out.println(a[2][1]);

        //改

        //请将以上二维数组上的第2个一维数组,中的第3个元素改为999
        a[1][2] = 999;
        System.out.println(a[1][2]);
    }
}
