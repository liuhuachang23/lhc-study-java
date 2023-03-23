package hsp.chapter13.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Collection col = new ArrayList();

        col.add(new Dog("三毛", 7));
        col.add(new Dog("小黄", 4));
        col.add(new Dog("阿尤", 6));


        System.out.println("==使用迭代器遍历集合==");
        Iterator iterator = col.iterator();
        while(iterator.hasNext()){
            Object o = iterator.next();
            System.out.println(o);
        }
        System.out.println("==使用增强for循环遍历集合==");
        for (Object dog : col){
            System.out.println(dog);
        }

    }
}

class Dog {
    private String name;
    private int age;

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

