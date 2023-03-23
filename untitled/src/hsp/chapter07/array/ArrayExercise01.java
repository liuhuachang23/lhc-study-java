package hsp.chapter07.array;
//求出一个数组int[]的最大值{4,-1,9,10,23},并取得对应的下标
public class ArrayExercise01 {
    public static void main(String[] args) {

        int[] arr = {4,-1,9,10,23};
        //假设起始值为最大值
        int max = arr[0];
        //最大值的下标
        int maxIndex = 0;
        for (int i = 0; i <arr.length ; i++) {
            //判断什么情况下发生交换
            if (arr[i] > max){
                //进行交换
                max = arr[i];
                //下标交换
                maxIndex = i;
            }
        }

        System.out.println("max = " + max + "  maxIndex = " + maxIndex);

    }
}
