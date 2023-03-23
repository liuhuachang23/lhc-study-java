package hsp.chapter12.arrays;

import java.util.Arrays;
import java.util.Comparator;

//Arrays类常见方法
public class ArraysMethod01 {
    public static void main(String[] args) {

        //1. Array.toString(),显示数组信息
        Integer[] ig = {1, 30, 70, 34, 57};
        System.out.println(Arrays.toString(ig));

        //2.默认排序 Array.sort()
        Arrays.sort(ig);
        System.out.println("===排序后输出===");
        System.out.println(Arrays.toString(ig));

        //3.定制排序: sort重载的,也可以通过传入一个接口 Comparator 实现定制排序
        //  调用定制排序 时,传入两个参数 (1)排序的数组 (2)实现了Comparator接口的匿名内部类,实现compare方法
        //分析:
        //(1)首先进入 Arrays.sort(ig, new Comparator()
        //(2)最终 执行到binarySort方法代码,会根据动态绑定机制,c.compare()执行我们传入的传入的匿名内部类
        //      while (left < right) {
        //          int mid = (left + right) >>> 1;
        //          if (c.compare(pivot, a[mid]) < 0)
        //              right = mid;
        //          else
        //              left = mid + 1;
        //      }
        //(3)   new Comparator() {
        //          @Override
        //          public int compare(Object o1, Object o2) {
        //              Integer i1 = (Integer) o1;
        //              Integer i2 = (Integer) o2;
        //
        //              return i1 - i2;
        //          }
        //      }
        //(4) public int compare(Object o1, Object o2) 返回的值 >0 还是 <0 会影响排序的方式
        //这充分体现了 接口编程+动态绑定+匿名内部类 的综合使用
        Arrays.sort(ig, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //将传入的值(o1,o2)转为Integer类型
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;

                return i2 - i1;
            }
        });
        System.out.println(Arrays.toString(ig));
    }
}
