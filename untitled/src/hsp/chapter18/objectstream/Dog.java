package hsp.chapter18.objectstream;

import java.io.Serializable;
//如果需要序列化某个对象, 则这个对象必须实现 Serializable

public class Dog implements Serializable {

    //SerialVersionUID 序列化的版本号，可以提高兼容性
    private static final long SerialVersionUID = 1L;

    //序列化对象时，默认将里面所有的属性都进行了序列化，但是除了static或transient修饰的成员
    private String name;
    private int age;
    //下面两个属性不会被序列化和反序列化(static或transient修饰)
    private transient String color;
    private static String nation;

    //序列化对象时 要求里面属性的类型也需要实现序列化接口
    //这个属性没有被序列化，所以在对这个dog对象进行序列化和反序列化，会认为dog不可序列化 而报错
    //private Master master = new Master();


    public Dog(String name, int age, String color, String nation) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.nation = nation; //这里是为了演示
    }


    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}' + nation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
