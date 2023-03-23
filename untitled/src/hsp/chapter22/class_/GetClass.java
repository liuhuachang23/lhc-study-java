package hsp.chapter22.class_;

import hsp.chapter22.zoon.Car;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/21 10:45
 * @Description: 演示得到 Class对象 的几种方式
 */
public class GetClass {
    public static void main(String[] args) throws ClassNotFoundException {

        //1. Class.forName
        //通过读取配置文件，得到类的全路径(这里就不演示如何从配置文件读取了,直接使用类的 全路径)
        String classAllPath = "hsp.chapter22.zoon.Car";
        Class<?> cls1 = Class.forName(classAllPath);
        System.out.println(cls1);

        //2. 类名.class
        //应用场景：用于参数传递
        Class cls2 = Car.class;
        System.out.println(cls2);

        //3. 对象.getClass()
        //应用场景：有对象实例
        Car car = new Car();
        Class cls3 = car.getClass();
        System.out.println(cls3);

        //4. 通过类加载[4种] 获取到Class对象
        //(1) 先得到类加载器
        ClassLoader classLoader = car.getClass().getClassLoader();
        //(2) 通过类加载器得到Class对象
        Class cls4 = classLoader.loadClass(classAllPath);
        System.out.println(cls4);

        //上面 cls1、cls2、cls3、cls4 都是同一个类对象（一个类只有一个Class对象）

        //5. 基本数据 (int, char,boolean,float,double,byte,long,short） 按如下方式得到Class类对象
        Class<Integer> integerClass = int.class;
        System.out.println(integerClass); //int
        //6. 基本数据类型对应的包装类，可以通过.TYPE 得到Class类对象
        Class<Integer> type = Integer.TYPE;
        System.out.println(type); //int

        // integerClass 和 type 是同一个类对象（底层都会自动装箱）
        System.out.println(integerClass == type); //true



    }
}
