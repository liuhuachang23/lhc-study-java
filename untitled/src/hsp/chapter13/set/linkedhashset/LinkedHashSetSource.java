package hsp.chapter13.set.linkedhashset;

import java.util.*;

/*
* LinkedHashSet底层机制说明
*   分析LinkedHashSet的添加元素底层是如何实现( hash() + equals() )
*
* 1) 在LinkedHashSet 中维护了一个hash表和双向链表(LinkedHashSet 有 head 和 tail)
* 2) 每一个结点有 before 和 after 属性, 这样可以形成双向链表
* 3) 在添加一个元素时, 先求hash值, 在求索引, 确定该元素在table的位置, 然后将添加的元素加入到双向链表中
*    (如果已经存在,就放弃添加[流程和HashSet一样，扩容和树化的机制一样])
*       //添加的大致代码:
*       tail.next = newElement
*       newElement.pre = tail
*       tail = newElement
* 4) 这样的话, LinkedHashSet也可以确保插入的顺序和遍历顺序一样
*
* */
@SuppressWarnings({"all"})
public class LinkedHashSetSource {
    public static void main(String[] args) {
        Set set = new LinkedHashSet();
        set.add(new String("AA"));
        set.add(456);
        set.add(456);
        set.add(new Customer("刘", 1001));
        set.add(123);
        set.add("HSP");
        //元素添加顺序和取出顺序一致
        System.out.println(set);
        //分析LinkedHashSet底层机制
        //1. LinkedHashSet 底层维护的是一个 LinkedHashMap(HashMap的子类)
        //2. LinkedHashMap 底层维护的是一个 (数组 + 双向链表)
        //3. 第一次添加时, 直接将 数组table 扩容到 16, 存放的结点类型是LinkedHashMap$Entry
        //4. table数组类型是HashMap$Node (HashMap$Node[]), 存放的元素/数据是 LinkedHashMap$Entry 类型
        /*
            //继承关系是在内部类完成的
            static class Entry<K,V> extends HashMap.Node<K,V> {
                LinkedHashMap.Entry<K,V> before, after;
                Entry(int hash, K key, V value, HashMap.Node<K,V> next) {
                    super(hash, key, value, next);
                }
            }
        */
        //5.

    }
}

class Customer {
    private String name;
    private int no;

    public Customer(String name, int no) {
        this.name = name;
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }
}