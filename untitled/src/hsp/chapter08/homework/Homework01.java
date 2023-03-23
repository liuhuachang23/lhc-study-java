package hsp.chapter08.homework;
//编写A01类，定义方法max，实现求某个double数组的最大值，并返回
// 注意: 此题涉及到包装类,以及它的自动装箱/装箱
public class Homework01 {
    public static void main(String[] args) {
        //静态初始化一个double数组
        double[] arr = {22.1,14.0,59.0,33.9};
        //创建对象
        A01 a = new A01();
        //返回一个包装类的对象Double,这个可以接收null,接收double时会完成自动装箱/拆箱
        Double res = a.max(arr);
        if (res != null){
            System.out.println("输入的最大值为: " + res);
        } else {
            System.out.println("输入有误!");
        }
    }
}

class A01{
    //返回值为Double是double的包装类,是一种引用数据类型
    public Double max(double[] arr){
        //先判断转入的数组是否为空,或者数组长度是否大于0
        if (arr != null && arr.length > 0) {
            //假设数组中第一个数为最大值
            Double max = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
            return max;
        } else {
            return null;
        }
    }
}
