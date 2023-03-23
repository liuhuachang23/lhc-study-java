package hsp.chapter13.map.hashtable;

import java.util.Hashtable;

/*
* Hashtable的基本介绍
* 1)存放的元素是键值对: 即k-v
* 2)Hashtable的键和值都不能为null, 否则会抛出NullPointerException
* 3)Hashtable使用方法基本上和HashMap一样
* 4)Hashtable 是线程安全的(synchronize), HashMap 是线程不安全的
*
* */
@SuppressWarnings({"all"})
public class HashTable_ {
    public static void main(String[] args) {
        Hashtable table = new Hashtable();
        table.put("john", 100); //k-v
        table.put(null, 100);  //异常
        //table.put("john", null); //异常
        table.put("lic", 100); //k-v
        table.put("lic", 80); //替换
        table.put("hello1", 1);
        table.put("hello2", 1);
        table.put("hello3", 1);
        table.put("hello4", 1);
        table.put("hello5", 1);
        table.put("hello6", 1);
        table.put("hello7", 1);
        table.put("hello8", 1);


        System.out.println(table);

        //简单说明一下Hashtable的底层
        //1.底层有数组 Hashtable$Entry[] 初始化大小为11
        //2.临界值 threshoid = 11 * 0.75 = 8
        //3.扩容: 按照自己的扩容机制
        //4.执行 方法 addEntry(hash, key, value, index); 添加k-v,封装到Entry
        //5.if (count >= threshold) 进行扩容:
        // int newCapacity = (oldCapacity << 1) + 1;  原来的两倍加1 = 11*2+1=23
    }
}
