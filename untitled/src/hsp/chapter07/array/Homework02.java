package hsp.chapter07.array;
//随机生成10个整数(1~100)保存到数组,并倒序打印以及求平均值,求最大值及最大值的下标,并查找是否有8
public class Homework02 {
    public static void main(String[] args) {
        //创建一个长度为10的数组
        int[] arr = new int[10];
        //给数组赋值
        for (int i = 0; i < arr.length; i++) {
            //随机生成整数:
            //(int)(Math.djb.random() * 100) + 1
            arr[i] = (int)(Math.random() * 100) + 1;
        }

        System.out.println("======arr的元素情况========");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("======arr的元素情况(倒序)========");
        //定义一个变量便于求元素总和及平均值
        double mad = 0;
        for (int i = arr.length - 1; i >= 0 ; i--) {
            System.out.print(arr[i] + " ");
            mad += arr[i];
        }
        System.out.println();
        //求数组元素的平均值
        System.out.println("average = " + mad / 10);
        
        //求数组中的最大值及最大值的下标
        //假设数组中第一个元素为最大值
        int max = arr[0];
        //最大值下标为
        int maxIndex = 0;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i] > max){
                max = arr[i];
                maxIndex = i;
            }
        }
        System.out.println("max = " + max + "  maxIndex = " + maxIndex);
        
        //判断数组元素中是否有8
        //可以定义一个变量
        int k = -1;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i] == 8){
                System.out.println("数组中存在8 " + "其下标为 " + i);
                k++;
                break;
            }
        }
        //如果 k == -1 则可以表示数组中没有8这个元素
        if (k == -1){
            System.out.println("数组中没有8这个元素");
        }
    }
}
