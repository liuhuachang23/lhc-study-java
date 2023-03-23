package hsp.chapter22.reflection.question;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/20 15:34
 * @Description: 看问题，引出发射
 */
@SuppressWarnings("all")
public class ReflectionQuestion {
    /*
    问题：根据配置文件 re.properties 指定信息,创建 Cat对象 并调用 方法hi

            配置文件信息：（第一个信息：Cat类的全路径，第二个信息：方法=方法名）
                classfullpath=hsp.chapter22.zoon.Cat
                method=hi

      1）使用现有技术,你可以做到吗?
      2）使用反射机制

    这样的需求在学习框架时特别多, 即通过外部文件配置,在不修改源码的情况下
        来控制程序, 也符合设计模式的 OCP原则(开闭原则: 不修改源码,扩展功能)

     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //使用 Properties类,读写配置文件
        //1) 创建一个 Properties
        Properties properties = new Properties();
        //2）加载该路径下的配置文件里面的信息 到properties中
        properties.load(new FileInputStream("src\\hsp\\chapter22\\reflection\\question\\re.properties"));
        //3）提取信息
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        //打印一下 两个信息 的运行类型
        System.out.println("classfullpath= " + classfullpath); //hsp.chapter22.zoon.Cat
        System.out.println("method= " + methodName); // hi

        //我们尝试做一做
        /*
        1. 使用传统方式:
            (1)方式1： new 对象 -> 调用方法 （这种方式没有使用到 配置文件）
                Cat cat = new hsp.chapter22.zoon.Cat();
                cat.hi();
            (2)方式2： 通过 配置文件获取 Cat的全路径（hsp.chapter22.zoon.Cat()） 去创建Cat对象
                //报错 , 因为 classfullpath 就是一个普通的字符串 hsp.chapter22.zoon.Cat
                // 所以传统方法是行不通的，
                new classfullpath();


            第一种方式是肯定可以的，但是题目要求是 使用配置文件 来创建配置文件中（指定路径的那个类）的对象
            由此引出 反射
         */


        //2. 使用反射机制

        //(1) 加载类 , 返回一个 Class类型的对象
        // （将一个类的全路径名 变成一个Class对象 ） 将 hsp.chapter22.zoon.Cat（路径名） 变成 hsp.chapter22.zoon.Cat（Class对象）
        Class cls = Class.forName(classfullpath);

        //(2) 通过 cls.newInstance() 得到 加载的类(hsp.chapter22.zoon.Cat) 的对象实例
        Object o = cls.newInstance();
        System.out.println("o的运行类型+ " + o.getClass()); //hsp.chapter22.zoon.Cat

        //    在放射中, 可将方法视为对象(万物皆对象)
        //(3) 通过 cls.getMethod(方法名) 得到 加载的类 的 methodName方法(hi方法) 该方法也为对象 即 方法对象
        Method method1 = cls.getMethod(methodName);

        //(4) 通过 method1 调用方法, 即通过 方法对象 来调用方法
        //传统方法: 对象.方法() , 放射机制: 方法.invoke(对象)
        method1.invoke(o); // hi 招财猫

        //扩展：在 hsp.chapter22.zoon.Cat类中，添加一个方法 cry(), 在不修改上面源码的情况下，
        //     将第 (4)步 的结果改为 调用 cry() 方法
        //怎么做：
        // 传统方法：修改源码，调用 cry()
        // 反射机制中：只要修改 配置文件（re.properties），将 method=hi --改为--> method=cry  即可



    }
}
