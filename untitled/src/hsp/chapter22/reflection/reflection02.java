package hsp.chapter22.reflection;

import hsp.chapter22.zoon.Cat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/20 19:25
 * @Description: 测试反射调用的性能，及优化
 */
public class reflection02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        m1();
        m2();
        m3();
    }

    //还是拿 hsp.chapter22.zoon.Cat 来演示
    //传统方法 调用 play()
    public static void m1(){
        Cat cat = new Cat();
        //统计传统方法 调用play() 900000000的时间
        long star = System.currentTimeMillis();
        for (int i = 0; i <900000000 ; i++) {
            cat.play();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统方法调用：" + (end - star));

    }

    //反射机制 调用 play()
    public static void m2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //加载类 , 返回一个 Class类型的对象
        Class cls = Class.forName("hsp.chapter22.zoon.Cat");
        //得到 加载的类 的对象实例
        Object o = cls.newInstance();
        //得到play()方法对象
        Method play = cls.getMethod("play");
        //统计执行900000000所用的时间
        long star = System.currentTimeMillis();
        for (int i = 0; i <900000000 ; i++) {
            // 方法对象.invoke(对象)
            play.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("反射机制调用：" + (end - star));

    }

    // 对反射机制 进行优化（关闭访问检查）
    public static void m3() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class cls = Class.forName("hsp.chapter22.zoon.Cat");
        Object o = cls.newInstance();
        Method play = cls.getMethod("play");
        //在反射调用方法时，取消访问检查
        play.setAccessible(true);
        long star = System.currentTimeMillis();
        for (int i = 0; i <900000000 ; i++) {
            play.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("反射机制调用：" + (end - star));

    }
}
