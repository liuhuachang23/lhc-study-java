package hsp.chapter13.list;

import java.util.ArrayList;
import java.util.List;

public class ListMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("张三丰");
        list.add("贾宝玉");

        //1.void add(int index, Object ele) 在index位置插入ele元素
        list.add(1,"韩顺平");
        System.out.println(list);

        //2.bollean addAll(int index, Collection eles) 从index位置开始1将eles中的所有元素添加进来 返回boolean
        List list1 = new ArrayList();
        list1.add("jack");
        list1.add("tom");
        System.out.println(list.addAll(1,list1));
        System.out.println(list);

        //3.Object get(int index) 获取指定index位置下的元素
        System.out.println(list.get(1));

        //4.int indexOf(Object obj) 返回obj在集合中首次出现的位置
        System.out.println(list.indexOf("tom"));

        //5.int lastIndexOf(Object obj) 返回obj在集合中最后一次出现的位置
        list.add("韩顺平");
        System.out.println(list.lastIndexOf("韩顺平"));

        //6.Object remove(int index) 移除指定index位置的元素,并返回此元素
        System.out.println(list.remove(5));
        System.out.println();

        //7.Object set(int index, Object ele) 设置指定index位置上的元素为ele(相当于替换) 返回被替换的元素
        System.out.println(list.set(2,"玛丽"));
        System.out.println(list);

    }

}
