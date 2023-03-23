package hsp.chapter14.generic;

import java.util.ArrayList;
import java.util.List;

/*
* 泛型的理解和好处-01
*
* 看一个需求:
*   1) 请编写程序,在ArrayList中,添加3个Dog对象
*   2) Dog对象含有name和age, 并输出name和age(要求使用getXxx())
*
* 先使用传统方法来解决 --> 引出泛型
*
* 由例题可以体现出,传统方法的弊端:
* 1)不能对加入到集合 ArrayList中的数据进行约束, 不安全 (例题中有体现)
* 2)遍历的时候,需要进行类型转换,如果集合中的数据量比较大,对效率有影响
*
* 怎么解决: 需要用到泛型
*
* */
@SuppressWarnings({"all"})
public class Generic01 {
    public static void main(String[] args) {
        //使用传统方法
        List list = new ArrayList();
        list.add(new Dog("旺财", 6));
        list.add(new Dog("发财", 4));
        list.add(new Dog("小黄", 3));
        //假如我们的程序员不小心加入了一只猫,下面运行遍历的时候就会抛出异常
        list.add(new Cat("招财猫", 3));

        //遍历
        for (Object o : list) {
            Dog dog = (Dog) o; //当遍历到猫的时候就会出异常 ClassCastException
            System.out.println(dog.getName() + "-" + dog.age);
        }
    }
}

class Dog{
public String name;
public int age;

public Dog(String name, int age) {
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

class Cat{
    public String name;
    public int age;

    public Cat(String name, int age) {
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