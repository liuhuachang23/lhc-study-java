package hsp.chapter18.homework.homework03;

import java.io.*;
import java.util.Properties;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/4 21:46
 * @Description:
 * (1) 要编写一个dog.properties
 *      name=tom
 *      age=5
 *      color=red
 * (2) 编写dog类(name,age,color) 创建一个dog对象,读取dog.properties 用相应的内容完成属性初始化, 并输出
 * (3) 将创建的Dog对象, 序列化到 文件 dog.dat文件
 * (4) 在将 dog.dat文件 反序列化
 *
 */
public class Homework03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //1 要编写一个dog.properties
        Properties properties = new Properties();
        properties.load(new FileReader("src\\hsp\\chapter18\\homework\\homework03\\dog.properties"));
        String name = properties.getProperty("name");
        int age = Integer.valueOf(properties.getProperty("age"));
        String color = properties.getProperty("color");
        //2 创建一个dog对象,读取dog.properties 用相应的内容完成属性初始化, 并输出
        Dog dog = new Dog(name,age,color);
        System.out.println(dog);

        //3 将创建的Dog对象, 序列化到 文件 dog.dat文件
        String filePath = "d:\\data2.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeObject(new Dog(name,age,color));
        oos.close();
        System.out.println("数据保存(序列化)完毕");
        //4.1 在将 dog.dat文件 反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        Object o = ois.readObject();
        System.out.println(o);
        //4.2 如果我们希望调用dog的方法, 必须向下转型
        Dog dog1 = (Dog)o;
        System.out.println(dog1.getName());
        System.out.println(dog1.getAge());
        System.out.println(dog1.getColor());
        ois.close();
    }
}


