package hsp.chapter18.objectstream;


import java.io.FileInputStream;
import java.io.ObjectInputStream;

/*
* 演示ObjectInputStream的使用，完成数据的反序列化
* */
public class ObjectInputStream_ {
    public static void main(String[] args) throws Exception {
        String filePath = "d:\\data.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        //分析:
        //1. 读取(反序列化)的顺序需要和你保存数据(序列化)的顺序一致 , 否则出现异常
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        Object dog = ois.readObject();//底层 Object -> Dog
        System.out.println("运行类型: " + dog.getClass());
        System.out.println("dog信息: " + dog); //输出的dog信息中,color和nation两个信息为null,因为没有被序列化和反序列化

        //如果我们希望调用dog的方法, 必须向下转型
        //反序列化的对象(dog对象)必须要提供该对象的字节码文件.class
        //所以我们需要将Dog类,放在一个可以引用到的位置
        Dog dog2 = (Dog)dog;
        System.out.println(dog2.getName());
        System.out.println(dog2.getAge());

    }
}
