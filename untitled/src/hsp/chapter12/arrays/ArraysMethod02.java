package hsp.chapter12.arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysMethod02 {
    public static void main(String[] args) {

        Integer[] arr = {1, 2, 56, 88, 90};
        //1. binarySearch() 通过二分法搜索进行查找
        //1)使用binarySearch 查找,要求数组必须排序好
        //2)如果数组中存在该元素，就返回其索引
        //2)如果数组中没有该元素,就返回:它应该在的位置加1，并且取反 return -(row +1);
        int index = Arrays.binarySearch(arr, 30);// -(2+1)
        System.out.println(index); //-3

        //2. copyOf 数组元素的复制
        //底层调用的是System.arraycopy()
        //1)如果拷贝的长度 > 原数组的长度 就在新数组后面加 null
        //2)如果拷贝的长度 < 0 就抛出异常:NegativeArraySizeException
        Integer[] newArr = Arrays.copyOf(arr, 3);
        System.out.println(Arrays.toString(newArr)); //[1, 2, 56]
        Integer[] newArr2 = Arrays.copyOf(arr, arr.length + 1);
        System.out.println(Arrays.toString(newArr2)); //[1, 2, 56, 88, 90, null]

        //3. fill 数组元素的填充
        Integer[] num = {9, 3, 4};
        //使用99去替换 num数组 原来的元素
        Arrays.fill(num, 99);
        System.out.println(Arrays.toString(num)); //[99, 99, 99]

        //4 equals 比较两个数组元素内容是否完全一致
        Integer[] arr1 = {1, 2, 4, 5, 3};
        Integer[] arr2 = {1, 2, 4, 5, 3};
        System.out.println(Arrays.equals(arr1,arr2)); //true

        //5. asList 将一组值,转换成list
        //1) asList方法,会将(1, 2, 4, 6, 5, 3) 数据转换成一个List集合
        //2) 返回的 asList 编译类型: List(接口)
        //   asList 运行类型: java.util.Arrays$ArrayList
        List asList = Arrays.asList(1, 2, 4, 6, 5, 3);
        System.out.println("asList= " + asList);
        System.out.println("asList的运行类型: " + asList.getClass());
    }
}
