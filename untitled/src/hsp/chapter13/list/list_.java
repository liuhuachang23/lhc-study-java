package hsp.chapter13.list;

import java.util.ArrayList;
import java.util.List;

/*
 * List接口基本介绍
 * List 接口是 Collection接口的子接口
 * 1）List集合类中元素有序（即添加顺序和取出顺序一致），且可重复
 * 2）List集合中的每一个元素都有其对应的顺序索引，即支持索引
 * 3）List容器中的元素都对应一个整数型的序号记载其在容器中的位置，可以根据序号存取容器中的元素
 * 4）JDK API 中 List接口的实现类常用的有：ArrayList、LinkedList、Vector
 *
 * 下面使用List的其中一个实现类ArrayList演示
 * */
public class list_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        //1）List集合类中元素有序（即添加顺序和取出顺序一致），且可重复
        list.add("jack");
        list.add("tom");
        list.add("mary");
        list.add("hsp");
        list.add("tom");
        System.out.println(list);
        //2）List集合中的每一个元素都有其对应的顺序索引，即支持索引
        //3）List容器中的元素都对应一个整数型的序号记载其在容器中的位置，可以根据序号存取容器中的元素
        System.out.println(list.get(3)); //hsp

    }
}
