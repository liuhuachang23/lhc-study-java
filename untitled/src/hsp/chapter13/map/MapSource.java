package hsp.chapter13.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"all"})
public class MapSource {
    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("no1", "韩顺平");
        map.put("no2", "张无忌");
        map.put(new Car(), new Person());

        //分析
        //1. k-v 最后是存放在 HashMap$Node node = newNode(hash, key, value, null);
        //2. k-v 为了方便程序员的遍历, 还会 创建 EntrySet 集合, 该集合存放的元素类型为 Entry,
        //   而一个Entry对象, 就有k,v  EntrySet<Entry<K,V>> 即: transient Set<Map.Entry<K,V>> entrySet;
        //   Entry中的 k,v 就是指向node中的 k,v (存放的是一个地址,地址和node里面的地址一样)
        //3. entrySet 中， 定义的类型是 Map.Entry，但实际上存放的还是 HashMap$Node ，为什么可以这样存放
        //   因为，Node<K,V> implements Map.Entry<K,V>，所以可以将 HashMap$Node类型 定义成 Map.Entry类型
        //4. 当把 HashMap$Node 对象 存放到 entrySet 就方便我们遍历，
        //   因为Map.Entry 提供了K getKey() 和 V getValue() 两个方法
        Set set = map.entrySet();
        System.out.println(set.getClass()); //set的运行类型：HashMap$EntrySet
        for (Object o : set) {
            //探索entrySet里面放什么东西：
            //System.out.println(o.getClass()); //HashMap$Node类型

            //为了从 HashMap$Node 取出 k-v
            //1.先做一个向下转型 Object --> Map.Entry
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }


        Set set1 = map.keySet();
        System.out.println(set1.getClass()); //HashMap$KeySet
        Collection values = map.values();
        System.out.println(values.getClass()); //HashMap$Values
    }
}

class Car{

}

class Person{

}
