package djb.integer;
/*
* 在JDK1.5之后，支持自动装箱和自动拆箱了
*
*   自动装箱：基本数据类型自动转换成包装类
*   自动拆箱：包装类自动转换成基本数据类型
*
* 有了自动拆箱后，Number类中的方法就用不着了
*
* 自动拆箱和自动装箱的好处：
* */
public class IntegerTest05 {
    public static void main(String[] args) {

        //自动装箱
        //int类型自动转换为Integer类型
        Integer x = 100;

        //自动拆箱
        //Integer类型自动转换为int类型
        int y = x;

        //z是一个引用，也是一个变量，z保存的是一个对象的内存地址
        Integer z = 1000; //等同于 Integer z = new Integer(1000);
        //分析为什么没有报错
        //+号两边要求是基本数据类型，z是包装类，不属于基本数据类型，这里会进行自动拆箱，将z转换成基本数据类型
        System.out.println(z + 1); //1001

        Integer a = 1000;
        Integer b = 1000;
        // == 比较的是对象的内存地址，a和b两个引用中保存的对象内存地址不同
        // == 这个运算符不会出发自动拆箱机制，只有（+ - * / 等）运算符才能
        System.out.println(a == b); //false

        //为什么下面为true
        /*java中为了提高执行效率，将[-128 ~ 127]所以的包装对象提前创建好
        放到了一个方法区的"整数型常量池"当中了，目的是只要这个区间的数据
        不需要在new对象了，直接从整数型常量池中取出*/
        //原理：c变量和d变量中保存的对象内存地址相同
        Integer c = 127;
        Integer d = 127;
        System.out.println(c == d); //true
    }
}
