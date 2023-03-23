package hsp.chapter13.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionFor {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        Collection col = new ArrayList();

        col.add(new Book("三国演义", "罗贯中", 100));
        col.add(new Book("小李飞刀", "古龙", 80));
        col.add(new Book("红楼梦", "曹雪芹", 200));

        //使用增强for循环,在Collection集合
        //1.增强for 底层依然是迭代器
        //2.增强for 可以理解成就是简化版的 迭代器遍历
        //3.快捷键 I
        for (Object book : col){
            System.out.println(book);
        }
        //增强for也可以直接用于数组

    }
}
