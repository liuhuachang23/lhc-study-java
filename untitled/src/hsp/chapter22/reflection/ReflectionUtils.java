package hsp.chapter22.reflection;


import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/22 10:08
 * @Description: 通过反射获取类的结构信息
 */
public class ReflectionUtils {
    public static void main(String[] args) {

    }

    //第一组：
    @Test
    public void api_01() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        //得到Class对象
        Class<?> personCls = Class.forName("hsp.chapter22.reflection.Person");

        //1） getName:获取全类名
        System.out.println("全类名：" + personCls.getName());
        //2） getSimpleName:获取简单类名
        System.out.println("简单类名：" + personCls.getSimpleName());

        //3） getFields:获取所有public修饰的属性，包含本类以及父类的
        System.out.print("本类及父类public修饰的属性名：");
        Field[] fields = personCls.getFields();
        for (Field field : fields) {
            System.out.print(field.getName() + " ");
        }
        //4） getDeclaredFields:获取本类中所有属性
        System.out.print("\n本类所有属性：");
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.print(field.getName() + " ");
        }

        //5） getMethods:获取所有public修饰的方法，包含本类以及父类的
        System.out.print("\n本类及父类public修饰的方法：");
        Method[] methods = personCls.getMethods();
        for (Method method : methods) {
            System.out.print(method.getName() + "() ");
        }
        //6） getDeclaredMethods:获取本类中所有方法
        System.out.print("\n本类所有方法：");
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.print(method.getName() + "() ");
        }

        //7） getConstructors：获取本类public修饰的构造器
        System.out.println();
        Constructor<?>[] constructors = personCls.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("本类public修饰的构造器：" + constructor.getName());
        }
        //8） getDeclaredConstructors:获取本类中所有构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            System.out.println("本类所有的构造器：" + constructor.getName());
        }

        //9） getPackage:以Package形式返回 包信息
        System.out.println("包信息：" + personCls.getPackage());
        //10）getSuperClass:以Class形式返回父类信息
        System.out.println("父类信息：" + personCls.getSuperclass());
        //11）getInterfaces:以Class[]形式返回接口信息
        Class<?>[] interfaces = personCls.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println("接口信息：" + anInterface);
        }
        System.out.println();
        //12）getAnnotations:以Annotation[] 形式返回注解信息
        Annotation[] annotations = personCls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解信息：" + annotation);
        }
    }

    //第二组
    @Test
    public void api_02() throws ClassNotFoundException {
        //获取Class对象
        Class<?> personCls = Class.forName("hsp.chapter22.reflection.Person");
        //得到本类所有属性 及 属性名、属性修饰符值、属性类型
        System.out.println("本类所有属性：");
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("属性名=" + field.getName() + " 修饰符值=" + field.getModifiers() +
                    " 类型=" + field.getType());
        }
    }

    //第三组
    public void api_03() throws ClassNotFoundException {
        //获取Class对象
        Class<?> personCls = Class.forName("hsp.chapter22.reflection.Person");
        //获取本类中所有方法 及 方法名、方法的修饰符值、返回值类型、参数类型
        System.out.println("本类所有方法：");
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.print("方法名=" + method.getName() + " 方法的修饰符值=" + method.getModifiers() +
                    " 返回值类型=" + method.getReturnType());
            System.out.print(" 参数类型=");
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class parameterType : parameterTypes) {
                System.out.print(parameterType + " ");
            }
            System.out.println();
        }
    }

    //第四组
    @Test
    public void api_04() throws ClassNotFoundException {
        //获取Class对象
        Class<?> personCls = Class.forName("hsp.chapter22.reflection.Person");
        //获取本类中所有构造器 及 构造器全类名、构造器的修饰符值、构造器的参数类型
        System.out.println("本类所有构造器");
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            System.out.print("构造器(全类名)=" + constructor.getName() + " 构造器的修饰符值=" + constructor.getModifiers());
            System.out.print(" 构造器的参数类型=");
            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class parameterType : parameterTypes) {
                System.out.print(parameterType + " ");
            }
            System.out.println();
        }
    }
}

//接口
interface IA {
}

interface IB {
}

class Ape {
    public String hobby;

    public Ape() {
    }

}

@Deprecated
class Person extends Ape implements IA, IB {
    //属性
    public String name;
    protected int age;
    String job;
    private double sal;

    //构造器
    public Person() {

    }

    Person(String name) {

    }

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public Person(String name, int age, String job, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.sal = sal;
    }

    //方法
    public void m1() {

    }

    protected int m2(int age) {
        return 10;
    }

    String m3(String name) {
        return "Tom";
    }

    private boolean m4(String name, int age) {
        return true;
    }

}