package hsp.chapter18.objectstream;

import hsp.chapter18.objectstream.Dog;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/*
* 演示ObjectOutputStream的使用，完成数据的序列化
* */
public class ObjectOutputStream_ {
    public static void main(String[] args) throws Exception {
        //序列化后保存的文件格式 不是存文本 而是按照它的格式来保存
        String filePath = "d:\\data.dat";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));

        //序列化数据到 e:\data.dat
        oos.writeInt(100); //int -> Integer(实现了Serializable接口)
        oos.writeBoolean(true); //boolean -> Boolean(实现了Serializable接口)
        oos.writeChar('a'); //char -> Character(实现了Serializable接口)
        oos.writeDouble(9.6); //double -> Double(实现了Serializable接口)
        oos.writeUTF("吴小文"); //String(实现了Serializable接口)
        //保存一个 dog对象
        //注意:dog中 color和nation两个属性,不能被序列化和反序列化l
        //该属性值保持默认初始化值 null；
        oos.writeObject(new Dog("旺财", 3,"白色", "日本"));

        oos.close();
        System.out.println("数据保存完毕(序列化形式)");

    }
}


