package hsp.chapter08.homework;
//编写A03，实现数组的复制功能copyArr，输入旧数组，返回一个新数组，元素和旧数组一样
public class Homework04 {
    public static void main(String[] args) {
        //静态初始化一个数组
        int[] arr = {10, 58, 7, 65, 90, 83, 35};
        //创建一个新的对象
        int[] nweArr = new int[arr.length];

        //创建对象
        A03 a = new A03();

        int[] newArr1 = a.copyArr(arr,nweArr);
        for (int i = 0; i <newArr1.length ; i++) {
            System.out.print(newArr1[i] + " ");
        }
    }
}

class A03{
    public int[] copyArr(int[] arr,int[] newArr){
        for (int i = 0; i <arr.length ; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
}
