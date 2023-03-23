package hsp.chapter14.generic;

import java.util.ArrayList;
import java.util.List;

/*
* 泛型的理解和好处-02
*
* 使用泛型来完成上一例题
*
* 泛型的好处:
* (1) 编译时, 检查添加元素的类型, 提高了安全性
* (2) 减少了类型转换的次数, 提高效率
*     -不使用泛型:
*      Dog -加入-> Object -取出-> Dog (加入到 ArrayList 会转成 Object, 在取出时,还需要转成 Dog)
*     -使用泛型:
*      Dog --> Dog --> Dog (放入时, 和取出时, 不需要类型转换, 提高效率)
*
* (3)不在提示编译警告
*
*
*
* */
//@SuppressWarnings({"all"}) //不加抑制也不会出现编译警告
public class Generic02 {
    public static void main(String[] args) {
        //使用泛型解决
        //1.当我们 ArrayList<Dog> 表示存放到 ArrayList 集合中的元素是Dog类型(或者Dog的子类)
        //2.如果编译器发现添加的类型不满足要求, 就会报错
        //3.在遍历的时候，就可以直接取出 Dog类型而不是Object 不要类型转换
        //4.List<E> list = new ArrayList<E>();
        List<Dog> list = new ArrayList<Dog>();
        list.add(new Dog("旺财", 6));
        list.add(new Dog("发财", 4));
        list.add(new Dog("小黄", 3));
        //假如我们的程序员不小心加入了一只猫,编译器会直接报错, 安全性更高了
        //list.add(new Cat("招财猫", 3));

        //使用泛型后,就可以直接使用Dog类型, 不需要类型转换
        for (Dog dog : list) {
            System.out.println(dog.getName() + "-" + dog.getAge());
        }

    }
}
class Dog1{
    public String name;
    public int age;

    public Dog1(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Cat1{
    public String name;
    public int age;

    public Cat1(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}