package hsp.chapter13.collection;

/*
 *Collection 接口实现类特点 (看继承图,一目了然)
 *   1.Collection接口继承了Iterable
 *    public interface Collection <E> extends Iterable <E>
 *
 *       1) collection实现子类可以存放多个元素,每个元素可以是Object
 *       2) 有些collection的实现类, 可以存放重复的元素,有些不可以
 *       3) 有些collection的实现类, 有些是有序的(List), 有些是无序的(Set)
 *       4) Collection 接口没有直接的实现子类,是通过它的子接口 Set 和 List 来实现的
 *
 * Collection接口的常用方法:
 *   以下例题用 Collection 的子接口 List 的实现子类 ArrayList 来演示
 *
 * */

import java.util.ArrayList;
import java.util.List;

public class CollectionMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        List list = new ArrayList();

        //add:添加单个元素
        list.add("jack");
        list.add(10); // list.add(new Integer(10)); 自动装箱
        list.add(true); // 也涉及到一个自动装箱过程
        System.out.println(list);

        //remove:删除指定元素 (可以指定下标 也可以指定元素)
        //list.remove(1); //删除第2个元素
        list.remove("jack"); //删除 jack 这个元素
        System.out.println(list);

        //contains:查找元素是否存在
        System.out.println(list.contains(10));

        //size:获取元素的个数
        System.out.println(list.size());

        //isEmpty:判断是否为空
        System.out.println(list.isEmpty());

        //clear:清空
        list.clear();
        System.out.println(list);

        //addAll:添加多个元素
        ArrayList list1 = new ArrayList();
        list1.add("红楼梦");
        list1.add("水浒传");
        list.addAll(list1);
        System.out.println(list);

        //(bollean) containsAll:查找多个元素是否存在
        System.out.println(list.containsAll(list1));

        //(String) removeAll:删除多个元素
        list.add("聊斋");
        list.removeAll(list1);
        System.out.println(list);


    }
}
