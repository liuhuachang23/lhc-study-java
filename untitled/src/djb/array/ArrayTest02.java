package djb.array;
/*
*关于每个类型的默认值:
*
*   数据类型			默认值
*   ------------------------------
*	 byte             0
*    short            0
*    int              0
*    long             0L
*	 float            0.0F
*    double		      0.0
*	 boolean	      false
*	 char			  \u0000
*    引用数值类型      null
*
* 什么时候使用静态初始化方式、动态初始化方式？
*   当年创建数组的时候，确定数组中存储那些具体的元素时，采用静态初始化方式
*   当年创建数组的时候，不能确定数组中存储那些具体的元素时，采用动态初始化方式，预先分配内存空间
*
* */
public class ArrayTest02 {

    public static void main(String[] args) {
        //声明一个数组,采用动态初始化的方式创建
        //创建长度为4的int类型数组，数组中每个元素的默认值是0
        int[] a = new int[4];
        //遍历数组
        for (int i = 0; i < a.length; i++){
            System.out.println("数组中下标为 " + i + " 的元素是 " + a[1]);
        }

        //后期赋值
        a[0] = 1;
        a[1] = 22;
        a[2] = 324;
        a[3] = 393;

        //初始化一个Object类型的数组，采用动态初始化方式
        Object[] objs = new Object[3]; //3个长度，动态初始化，所以每个元素默认值是null
        for (int i = 0; i < objs.length; i++){
            System.out.println(objs[i]);
        }

        System.out.println("======================");

        //初始化一个String类型的数组，采用动态初始化方式
        String[] strs = new String[3];
        for (int i = 0; i < strs.length; i++){
            System.out.println(strs[i]);
        }

        //采用静态初始化的方式
        String[] strs2 = {"abc", "dsf", "xyz"};
        for (int i = 0; i < strs2.length; i++) {
            System.out.println(strs2[i]);
        }

        //存储Object，采用静态初始化
        //Object o1 = new Object();
        //Object o2 = new Object();
        //Object o3 = new Object();
        //Object[] objects = {o1, o2, o3};
        //四步合成一步
        Object[] objects = {new Object(),new Object(),new Object()};

        for (int i = 0; i < objects.length ; i++) {
            //Object o = objects[i];
            //System.out.println(o); //o.toString()，自动调用Object中的toString()方法
            //两步合成一步
            System.out.println(objects[i]);
        }
    }
}
