package hsp.chapter13.homework;

import java.util.HashSet;
import java.util.Objects;

@SuppressWarnings({"all"})
public class Homework06 {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");
        set.add(p1);
        set.add(p2);
        System.out.println(p1.hashCode()); //66442
        //这个会导致p1通过key(key改变了)计算出的hash值发生改变 （但是元素hash值不会改变位置不会改变，但key变为：Person{1001,"CC"}）
        p1.name = "CC"; //改变前hashCode为66442, 改变后hashCode为68426, 所以经过处理计算出来的hash也会不一样
        System.out.println(p1.hashCode()); //68426
        //此时p1是根据上一步改变后的hash值去索引到table表上的位置进行删除，定位失败，删除失败
        set.remove(p1);
        System.out.println(set);
        //添加时定位到这个位置(此位置就是上面删除失败的位置)没有元素(key也为Person{1001,"CC"}),直接添加
        set.add(new Person(1001, "CC"));
        System.out.println(set);
        //这个会和第一个key为 Person{1001,"CC"}, 有相同的hash值, 但是他们的key不同,会添加到其后面,形成链表
        set.add(new Person(1001, "AA"));
        System.out.println(set);
    }
}

class Person {

    public int id;
    public String name;


    public Person(int id, String name) {
        this.id = id;
        this.name = name;

    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
