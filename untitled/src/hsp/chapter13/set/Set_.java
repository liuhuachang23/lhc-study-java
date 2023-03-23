package hsp.chapter13.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
* Set接口接介绍
* 1)无序(添加和取出的顺序不一致,但固定),没有索引
* 2)不允许添加重复元素,最多包含一个null (TreeSe不能有 null)
* 3)JDK API中Set接口的实现类有:
*   AbstractSet，ConcurrentHashMap.KeySetView，
*   ConcurrentSkipListSet，CopyOnWriteArraySet，
*   EnumSet，HashSet，JobStateReasons，LinkedHashSet，TreeSet
*
* Set接口的常用方法
*  和List接口一样, Set接口也是Collection的子接口,因此,常用方法和Collection一样
*
* Set接口的遍历方式
*   Set接口是Collection的子接口,和 Collection 的遍历方式一样(两种), (List接口多一种)
*   1)可以使用迭代器
*   2)增强for循环
*   3)注意:不能通过索引的方式来获取,(不能使用普通for循环)
*
* 下面以HashSet(Set的实现类之一)为例讲解
* */
@SuppressWarnings({"all"})
public class Set_ {
    public static void main(String[] args) {


        Set set = new HashSet();
        //1)不允许添加重复元素,最多包含一个null
        //2)无序(添加和取出的顺序不一致,但固定),没有索引
        set.add("john"); //T
        set.add("luck"); //T
        set.add("john"); //F 重复数据
        set.add("jack"); //T
        set.add(null);   //T
        set.add(null);   //F 重复数据
        set.remove(null);

        System.out.println("set= "+ set);

        //遍历
        //固定:两次遍历的顺序是一致的
        //使用迭代器
        System.out.println("===迭代器===");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
        //增强for
        System.out.println("===增强for===");
        for (Object o : set){
            System.out.println(o);
        }


    }
}
