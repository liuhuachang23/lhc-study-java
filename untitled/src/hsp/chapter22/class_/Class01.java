package hsp.chapter22.class_;

import hsp.chapter22.zoon.Cat;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/20 19:43
 * @Description: 对 Class类的梳理
 */
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //看看Class类图
        //1.Class也是类，因此继承Object类

        //2.Class类对象不是new出来的，而是系统创建的
        //（1） 传统new对象
        /* ClassLoader类
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
         */
        Cat cat = new Cat();

        //（2）反射方式
        /*  ClassLoader类，仍然是通过 ClassLoader类加载Cat类的 Class对象
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
         */
        Class cls1 = Class.forName("hsp.chapter22.zoon.Cat");

        //3.对于某个类的Class类对象，在内存中只有一份，因为类只加载一次
        //在加载一个Cat类对象，发现和前面的一样
        Class cls2 = Class.forName("hsp.chapter22.zoon.Cat");
        System.out.println(cls1.hashCode() == cls2.hashCode()); //true

        //4.每个类的实例都会记得自己是由哪个 Class 实例所生成
        //5.通过Class可以完整地得到一个类的完整结构，通过一系列API

        //6.Class对象是存放在堆的
        //7.类的字节码：二进制数据，是放在方法区的，有的地方称为类的元数据(包括 方法代码，变量名，方法名，访问权限等等）
        //  理解：当类加载器（ClassLoader）加载完类 会在 堆中生成一个 Class类对象，同时在 方法区 生成 类的字节码二进制数据，
        //       这个方法区会引用到 Class类对象




    }
}


