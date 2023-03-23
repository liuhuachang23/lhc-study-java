package hsp.chapter13.list.arraylist;

import java.util.ArrayList;

/*
 ArrayList的底层操作机制源码分析

        1)ArrayList中维护了一个Object类型的数组elementData.[debug看源码]
            transient Object[] elementData;

        2)当创建对象时,如果使用的是无参构造器
            初始elementData容量为0 (jdk7为10)
            如果第一次添加,则扩容elementData为10,
            如果需要再次扩容,则扩容elementData为1.5倍.

        3)当创建对象时,如果使用的是指定容量capacity的构造器,
            则初始elementData容量为capacity
            需要扩容,则直接扩容elementData为1.5倍

        4)当添加元素时:先判断是否需要扩容,如果需要,则调用grow方法,否则直接添加元素到合适位置
 * */
public class ArrayListSource {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //使用无参数构造器创建ArrayList对象
        ArrayList list = new ArrayList();
        //如果使用的是指定容量capacity的构造器
        //ArrayList list = new ArrayList(8);

        //使用for循环给list集合添加1~10数据
        for (int i = 0; i <10 ; i++) {
            list.add(i);
        }

        //使用for循环给list集合添加11~15数据
        for (int i = 11; i <15 ; i++) {
            list.add(i);
        }

        list.add(100);
        list.add(200);
        list.add(null);

        for (Object o : list) {
            System.out.println(o);
        }

    }
}
