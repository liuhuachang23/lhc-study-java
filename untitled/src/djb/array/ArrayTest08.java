package djb.array;

/*
* 关于一维数组的扩容。
*
* 在java数组长度一旦确定不可变，那么数组满了怎么办？
*   数组满了，需要扩容。
*   java中对数组的扩容是：
*       先建立一个大容量数组，然后将小容量中的数组拷贝到了里面去
*
* 结论：数组扩容效率低，因为涉及到拷贝的问题，所以在以后的开发中请注意，尽可能少的进行数组的拷贝。
*       可以在创建数组对象的时候预估一下多长合适，最好预估准确，这样可以减少数组的扩容，提高效率
* */
public class ArrayTest08 {
    public static void main(String[] args) {
        //java中的数组怎么拷贝的呢？
        //System.arraycopy(5个参数);

        //拷贝源（从这个数组中拷贝）
        int[] arc = {1,11,45,24};

        //拷贝目标（拷贝到这个目标数组上）
        //动态初始化一个长度为10的数组
        int[] dest = new int[10];

        //调用JDK System类中的arraycopy方法，来完成数组拷贝
        System.arraycopy(arc,1,dest,3,2);


        //遍历目标函数
        for (int i = 0; i <dest.length ; i++) {
            System.out.println(dest[i]);
        }

        System.arraycopy(arc,0,dest,0,arc.length);
        for (int i = 0; i <dest.length ; i++) {
            System.out.println(dest[i]);
        }

        System.out.println("-----------------------------------------------------");

        //当数组中存储的元素是引用
        String[] strs = {"hello","word","study","java","oracle","mysql","jdbc"};
        String[] newstrs = new String[10];

        System.arraycopy(strs,0,newstrs,0,strs.length);
        for (int i = 0; i <newstrs.length ; i++) {
            System.out.println(newstrs[i]);
        }

        System.out.println("-----------------------------------------------------");

        Object[] objs = {new Object(),new Object(),new Object(),new Object()};
        Object[] newObjs = new Object[10];

        System.arraycopy(objs,0,newObjs,0,objs.length);
        for (int i = 0; i <newObjs.length ; i++) {
            System.out.println(newObjs[i]);
        }

    }
}
