package hsp.chapter12.system;


import java.util.Arrays;

public class System_ {
    public static void main(String[] args) {
        //1、System.exit 退出当前程序
        /*System.out.println("ok1~");
        //exit(0),中 0 表示程序退出的状态(正常退出)
        System.exit(0);
        System.out.println("ok2~");*/

        //2、System.arraycopy()
        int[] arc = {1,2,3};
        int[] dest = new int[3];
        //这五个参数代表：
        //arc：源数组
        //srcPos：从源数组的那个索引位置开始拷贝
        //dest：目标数组
        //destPos：把源数组拷贝到目标数组的位置（从那个位置开始被拷贝）
        //length：从源数组拷贝多少个元素
        System.arraycopy(arc, 0, dest, 0, 3);
        System.out.println(Arrays.toString(dest));

        //3、System.currentTimeMillis()：返回当前时间离 1970-1-1 的毫秒数
        System.out.println(System.currentTimeMillis());

        //4、System.gc()：运行垃圾回收机制
        System.gc();

    }
}
