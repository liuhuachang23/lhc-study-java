package hsp.chapter22.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/22 19:02
 * @Description: 演示通过反射操作方法
 */
public class ReflectionAccessMethod {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //得到Boss类对应的Class对象
        Class<?> bossClass = Class.forName("hsp.chapter22.reflection.Boss");
        //创建对象
        Object o = bossClass.newInstance();
        //1.通过反射，调用public方法
        //1.1 得到hi方法对象
        Method hi = bossClass.getMethod("hi", String.class);
        //1.2 调用
        hi.invoke(o, "吴小文是猪...");

        //2.通过反射，调用private方法
        //2.1 得到say方法
        Method say = bossClass.getDeclaredMethod("say", int.class, String.class, char.class);
        //2.2 爆破
        say.setAccessible(true);
        //2.3 调用
        System.out.println(say.invoke(o, 16, "吴小文", '猪'));
        //因为 say 是一个静态方法，故 o 可以替换为 null
        System.out.println(say.invoke(null, 18, "吴文丽", '猪'));

        //3.在反射中，如果方法有返回值，统一返回Object，但其运行类型 还是对应的方法的返回值类型
        Object reVal = say.invoke(null, 5, "刘华昌", '男');
        System.out.println("reVal 的运行类型= " + reVal.getClass());

    }

}

class Boss {
    public int age;
    private static String name;

    public Boss() {
    }

    private static String say(int n, String s, char c) {
        return n + " " + s + " " + c;
    }

    public void hi(String s) {
        System.out.println("hi " + s);
    }
}