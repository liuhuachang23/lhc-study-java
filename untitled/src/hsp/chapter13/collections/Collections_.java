package hsp.chapter13.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
* Collections工具类
* */
@SuppressWarnings({"all"})
public class Collections_ {
    public static void main(String[] args) {
        //创建ArrayList 集合， 用于测试
        List list = new ArrayList();
        list.add("tom");
        list.add("smith");
        list.add("king");
        list.add("milan");

        System.out.println("原先顺序: " + list);
        //1. reverse(list): 反转 List中元素的顺序
        Collections.reverse(list);
        System.out.println("反转排序: " + list);

        //2. shuffle(list): 对 List集合的元素进行随机排序
        Collections.shuffle(list);
        System.out.println("随机排序: " + list);

        //3.sort()
        //1) sort(list): 根据元素的自然顺序(字符串大小排序)对指定 List集合元素按升序排序
        Collections.sort(list);
        System.out.println("自然排序: " + list);
        //2) sort(list Comparator): 根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
        //例如: 我们希望按照字符串长度大小排序
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //可以加入校验
                return ((String)o1).length() - ((String)o2).length();
            }
        });
        System.out.println("长度排序: " + list);

        //4. swap(List, int, int): 将指定 List集合中的 i 处元素和 j 处元素 进行交换
        Collections.swap(list, 1, 2);
        System.out.println("交换排序: " + list);

        //5. Object max()
        //1) Object max(Collection): 根据元素的自然排序, 返回给定集合中的最大值
        System.out.println("集合中的最大值: " + Collections.max(list));
        //2) Object max(Collection, Collection): 根据Comparator指定的顺序,返回给定集合中的最大值
        //比如我们要返回字符串长度最大的元素
        Object o  = Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length(); //将o1 o2 换一下就是求最小长度的元素
            }
        });
        System.out.println("长度最大的元素: " + o);

        //6. Object min(): 这个用法和上面一样, 不做分析

        //7. frequency(Collection, object): 返回指定集合中指定元素的出现次数
        System.out.println("list集合中tom出现的次数为: " + Collections.frequency(list, "tom"));

        //8. void copy(List dest, List src): 将src中的内容复制到dest中
        ArrayList dest = new ArrayList();
        //直接拷贝会出现IndexOutOfBoundsException异常
        //因为新数大小(为0)小于拷贝的数组大小 (注意,这里指的大小是size,不是容量length,所以必须要给新数组加元素)
        //Collections.copy(dest, list);
        //为了完成一个完整的拷贝,需要给dest赋值,大小和list.size()一样
        for (int i = 0; i <list.size() ; i++) {
            dest.add("");
        }
        Collections.copy(dest, list);
        System.out.println("dest: " + dest);

        //9. bollean replaceAll(List list, Object oldVal, Object newVal): 使用新值替换 List 对象的所有旧值
        //例题: 如果List中有tom, 就将所有tom替换成汤姆
        Collections.replaceAll(list, "tom", "汤姆");
        System.out.println("list替换后: " + list);
    }
}
