package hsp.chapter13.list;

import java.util.*;

//List的三种遍历方式
public class ListFor {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //list 接口的实现子类 ArrayList Vector LinkedList
        //List list = new ArrayList();
        //List list = new Vector();
        List list = new LinkedList();

        list.add("jack");
        list.add("tom");
        list.add("mary");
        list.add("北京烤鸭");

        //分别用三种方式遍历
        //1.迭代器
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            Object o = iterator.next();
            System.out.println(o);
        }

        System.out.println("================");
        //2.增强for循环
        for (Object o : list){
            System.out.println(o);
        }

        System.out.println("=================");
        //3.普通for循环
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }

    }
}
