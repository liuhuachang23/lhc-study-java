package hsp.chapter13.map;

import java.util.HashMap;
import java.util.Map;

/*
* Map接口常用方法
*
* */
@SuppressWarnings({"all"})
public class MapMethod {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("邓超", new Book("", 100)); //T
        map.put("邓超", "孙俪"); // 替换
        map.put("王宝强", "马蓉"); // T
        map.put("宋喆", "马蓉"); //T
        map.put(null, "刘亦菲"); //T
        map.put("鹿晗", "关晓彤"); //T
        map.put("hsp", "hsp的老婆"); //T

        System.out.println("map= " + map);
        //remove 根据见删除映射关系

        map.remove(null);
        System.out.println("map= " + map);
        //get 根据键获取
        System.out.println(map.get("鹿晗"));
        //size 获取元素个数
        System.out.println(map.size());
        //clear 清空
        //map.clear();
        System.out.println(map);
        //containsKey 查找键是否存在
        System.out.println(map.containsKey("hsp"));


    }
}
class Book{
    private String name;
    private int num;

    public Book(String name, int num) {
        this.name = name;
        this.num = num;
    }
}