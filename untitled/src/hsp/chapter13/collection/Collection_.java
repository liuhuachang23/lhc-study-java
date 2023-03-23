package hsp.chapter13.collection;

import java.util.ArrayList;
import java.util.HashMap;

public class Collection_ {
    //抑制警告
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //1.集合主要是两组(单列集合 , 双列集合)
        //2.collection 接口有两个主要的子接口 List Set , 他们的实现子类都是单列
        //3.Map 接口的实现子类, 是双列集合, 存放的 K-V
        //4.吧这两张图记下来: Collection 和 Map

        //单例集合:
        ArrayList arrayList = new ArrayList();
        arrayList.add("jack");
        arrayList.add("tom");
        //双列集合
        HashMap hashMap = new HashMap();
        hashMap.put("NO1", "北京");
        hashMap.put("NO2", "上海");

    }
}
