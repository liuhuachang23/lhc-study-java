package hsp.chapter22.reflection;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/20 18:57
 * @Description: 反射相关的主要类
 */
@SuppressWarnings("all")
public class reflection01 {

    public static void main(String[] args) throws Exception {

        //使用 Properties类,读写配置文件
        //1) 创建一个 Properties
        Properties properties = new Properties();
        //2）加载该路径下的配置文件里面的信息 到properties中
        properties.load(new FileInputStream("src\\hsp\\chapter22\\reflection\\question\\re.properties"));
        //3）提取信息
        //全类名
        String classfullpath = properties.get("classfullpath").toString();
        //方法名
        String methodName = properties.get("method").toString();

        //下面演示一下 反射相关的主要类----------------------------------------

        //1、 java.lang.Class: 代表一个类，Class对象表示某个类加载后在堆中的对象
        //(1) 加载类 , 返回一个 Class类型的对象
        Class cls = Class.forName(classfullpath);
        System.out.println(cls); //显示cls对象，是那个类的Class对象：class hsp.chapter22.zoon.Cat
        System.out.println(cls.getClass()); //运行类型：class java.lang.Class
        //(2) 通过 cls.newInstance() 得到 加载的类(hsp.chapter22.zoon.Cat) 的对象实例
        Object o = cls.newInstance();
        System.out.println("o的运行类型+ " + o.getClass()); //hsp.chapter22.zoon.Cat

        //2、 java.lang.reflect.Method： 代表类的方法
        //(1) 通过 cls.getMethod(方法名) 得到 加载的类 的 methodName方法 该方法也为对象 即 方法对象
        Method method = cls.getMethod(methodName);
        //(4) 通过 method 调用方法, 即通过 方法对象 来调用方法
        //传统方法: 对象.方法() , 放射机制: 方法.invoke(对象)
        method.invoke(o); // hi 招财猫

        //3、java.lang.reflect.Field：代表类的成员变量，Field对象表示某个类的成员变量
        //得到name字段（成员变量对象）
        Field nameField = cls.getField("age");
        System.out.println(nameField); //public int hsp.chapter22.zoon.Cat.age
        //通过这个 name字段，得到对应的值
        //传统写法：对象.成员变量
        //反射：成员变量对象.get(对象)
        System.out.println(nameField.get(o)); //2

        //4.java.lang.reflect.Constructor：代表类的构造方法
        Constructor constructor = cls.getConstructor(); //无参构造器
        System.out.println(constructor); // public hsp.chapter22.zoon.Cat()
        Constructor constructor1 = cls.getConstructor(String.class); //String.class，就是String类的Class对象
        System.out.println(constructor1); //public hsp.chapter22.zoon.Cat(java.lang.String)


    }
}

