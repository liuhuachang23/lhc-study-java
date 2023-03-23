package djb.random;

import java.util.Random;

/*
* 编写程序，生成5个不重复的随机数，重复的话重新生成
* 最终生产的5个随机数放到数组当中
*
* */
public class RandomTest02 {
    public static void main(String[] args) {

        //创建Random对象
        Random random = new Random();
        //准备一个数组
        int[] arr = new int[5];
        //将数组赋值,都赋值为-1吧
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = -1;
        }
        //声明一个下标变量
        int index = 0;
        while (arr[4] == -1) {
            int num = random.nextInt(55);
            //判断arr数组中有没有这个num
            //如果没有就放进去
            if (!contains(arr, num)){
                arr[index] =num;
                index += 1;
            }
        }

        //重新遍历
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }


    //单独写一个方法,这个方法专门用来判断数组中是否包含某个元素
    /**
     *
     * @param arr 数组
     * @param key 元素
     * @return 返回true表示包含,false表示不包含
     */
    public static boolean contains(int[] arr, int key){
        /*
        这个方法有bug.排序会打乱的下标
        //对数组进行排序
        Arrays.sort(arr);
        //进行二分法查找
        Arrays.binarySearch(arr,key);
        //二分法查找的结果>=0说明这个元素找到了,表示存在
        return Arrays.binarySearch(arr,key) > 0;
        */
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i] == key){
                return true;
            }
        } return false;
    }
}
