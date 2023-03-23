package hsp.chapter13.set.hashset;

import java.util.HashSet;
import java.util.Set;

/*
* HashSet全面说明
* 1)HashSet实现了Set接口
* 2)HashSet 实际上是 HashMap ,看源码:
*       public HashSet() {
*           map = new HashMap<>();
*       }
* 3)可以存放null值,但只能存放一个
* 4)HashSet不保证元素是有序的,取决于hash后,在确定索引的结果
* 5)不能有重复元素/对象
*
* */
@SuppressWarnings({"all"})
public class HashSet_ {
    public static void main(String[] args) {

        Set set = new HashSet();

        set.add("john");
        set.add("lucy");
        set.add("john"); //重复
        set.add("jack");
        set.add("hsp");
        set.add("mary");
        set.add(null);
        set.add(null); //重复


    }
}
