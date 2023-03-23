package hsp.chapter13.map;

import javax.xml.soap.Node;
import java.util.*;

/*
* Map接口的遍历方式
*
* */
@SuppressWarnings({"all"})
public class MapFor {

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("邓超", new Book("", 100)); //T
        map.put("邓超", "孙俪"); // 替换
        map.put("王宝强", "马蓉"); // T
        map.put("宋喆", "马蓉"); //T
        map.put(null, "刘亦菲"); //T
        map.put("鹿晗", "关晓彤"); //T
        map.put("hsp", "hsp的老婆"); //T

        //第一组 先取出key, 通过key 取出对应的value
        System.out.println("===第一组===");
        Set keySet = map.keySet();
        //方式一 增强for
        for (Object key : keySet){
            System.out.println("增强for: " + key + "-" + map.get(key));
        }
        //方式二 迭代器
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println("迭代器: " + key + "-" + map.get(key));
        }


        //第二组 把所有的value值取出 (没有key)
        System.out.println("===第二组===");
        Collection values = map.values();
        //方式一 增强for
        for (Object value : values){
            System.out.println("增强for: " + value);
        }
        //方式二 迭代器
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            Object value = iterator1.next();
            System.out.println("迭代器: " + value);
        }


        //第三组 通过EntrySet 来获取 k-v
        System.out.println("===第三组===");
        //EntrySet<Entry<k,v>>  EntrySet里面存了Entry<k,v>
        Set entrySet = map.entrySet();
        //增强for
        for (Object entry : entrySet){
            //System.out.println(entry.getClass()); //HashMap$Node
            //我们需要将entry --> Map.Entry(因为Map.Entry提供了两个重要方法)
            Map.Entry m = (Map.Entry)entry;
            System.out.println("增强for: " + m.getKey() + "-" + m.getValue());
        }
        //迭代器
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()) {
            //entry编译类型为Object 运行类型为HashMap$Node
            Object entry = iterator2.next();
            //entry 转为 Map.Entry类型(HashMap$Node实现了Map.Entry)
            Map.Entry m = (Map.Entry)entry;
            System.out.println("迭代器: " + m.getKey() + "-" + m.getValue());

        }
    }
}
