package hsp.chapter22.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/22 16:44
 * @Description: 演示通过反射创建对象
 * 1）通过public无参构造器
 * 1）通过public有参构造器
 * 1）通过private有参构造器
 */
public class ReflectionCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //先获取到User类的Class对象
        Class<?> userClass = Class.forName("hsp.chapter22.reflection.User");
        //1) 通过public的无参构造器创建实例：userClass.newInstance()
        Object o1 = userClass.newInstance();
        System.out.println(o1);
        //2) 通过public的有参构造器创建实例
        //2.1) 先得到 这个构造器：userClass.getConstructor(形参的Class对象)
        Constructor<?> constructor = userClass.getConstructor(String.class);
        //2.2）再使用这个构造器 去创建对象：constructor.newInstance(实参)
        Object o2 = constructor.newInstance("刘华昌");
        System.out.println(o2);

        //3） 通过非public的有参构造器创建实例
        //3.1）先得到 这个构造器：userClass.getDeclaredConstructor(形参的Class对象)
        Constructor<?> declaredConstructor = userClass.getDeclaredConstructor(int.class, String.class);
        //3.2） 爆破，使用反射可以访问private构造器/方法/属性
        declaredConstructor.setAccessible(true);
        //3.3） 再使用这个构造器 去创建对象：declaredConstructor.newInstance(实参)
        Object o3 = declaredConstructor.newInstance(20, "吴文丽");
        System.out.println(o3);

    }
}

class User {

    private int age = 10;
    private String name = "吴小文";

    //public 无参构造器
    public User() {

    }

    //public 有参构造器
    public User(String name) {
        this.name = name;
    }

    //private 有参构造器
    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [age=" + age + "，name=" + name + "]";
    }
}