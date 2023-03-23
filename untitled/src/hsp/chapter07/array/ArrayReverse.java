package hsp.chapter07.array;
//数组翻转
public class ArrayReverse {
    public static void main(String[] args) {
        //定义一个数组
        int[] arr = {11,22,33,44,55,66};
        //创建一个新的数组
        int[] arr2 = new int[arr.length];

        //实现数组翻转
        /*for (int i = arr.length-1; i >= 0 ; i--) {
            for (int j = arr2.length-i-1; j <arr2.length ; j++) {
                arr2[j] = arr[i];
            }
        }*/
        //优化代码
        for (int i = arr.length-1, j = 0; i >= 0 ; i--, j++) {
            arr2[j] = arr[i];
        }

        //遍历arr2
        for (int i = 0; i <arr2.length ; i++) {
            System.out.print(arr2[i] + "\t");
        }
    }
}
