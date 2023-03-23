package hsp.chapter13.map;

import java.util.HashMap;
import java.util.Map;

/*
Map接口实现类的特点
    1)Map 与 Collection并列存在, 用于保存具有映射关系的数据: Key-Value
    2)Map 中的 key和value 可以是如何类型的数据,会封装到HashMap$Node对象中
    3)Map 在的 key不允许重复,原因和 HashSet一样,前面分析过源码
    4)Map 中的 value可重复
    5)Map 的key可以为null, value也可以为null, 注意 key为null,只能有一个, value为null可以有多个
    6)常用String类作为Map的key
    7)key和value之间存在单向一对一关系,即通过指定的key总能找到,对应的value

*/
@SuppressWarnings({"all"})
public class Map_ {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("no1", "韩顺平"); //k-v
        map.put("no2", "张无忌"); //k-v
        map.put("no1", "张三丰"); //当有相同的key时,就等价与替换
        map.put("no3", "张三丰"); //k-v ,key不能相同,value没要求
        map.put(null,null); //k-v
        map.put(null, "abc"); //当有相同的key时,就等价与替换
        map.put("no4", null); //k-v
        map.put("no5", null); //k-v
        map.put(1, "赵敏"); //k-v
        map.put(new Object(), "金毛狮王"); //k-v

        //7)key和value之间存在单向一对一关系,即通过指定的key总能找到,对应的value
        //通过get方法,传入 key, 就会返回对应的 value
        System.out.println(map.get("no1"));
    }
}
