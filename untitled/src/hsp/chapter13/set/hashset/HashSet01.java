package hsp.chapter13.set.hashset;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@SuppressWarnings({"all"})
public class HashSet01 {
    public static void main(String[] args) {
        Set set = new HashSet();

        //HashSet 不能添加相同元素/数据
        //说明:在执行add方法后,会返回一个boolean
        //如果添加成功 返回true 否则 false

        //小测试一波
        set.add("john"); //T
        set.add("luck"); //T
        set.add("john"); //F 重复数据
        set.add("jack"); //T
        set.add("rose"); //T
        System.out.println("set= " + set);

        //加一点点难度
        set = new HashSet();
        set.add("lucy"); //T
        set.add("lucy"); //F
        set.add(new Dog("lucy")); //T
        set.add(new Dog("tom")); //T
        set.add(new Dog("tom")); //T
        System.out.println("set= " + set);

        //在加点难度
        //非常经典的面试题, 这个需要研究源码了
        set = new HashSet();
        set.add("hsp"); //T
        set.add(new String("hsp")); //F
        set.add(new String("hsp")); //F
        System.out.println(set);
    }
}

class Dog {

    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog.name=" + name;
    }

}