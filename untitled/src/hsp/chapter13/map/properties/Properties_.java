package hsp.chapter13.map.properties;

import java.util.Properties;

/*
* Properties基本介绍
* 1.properties类继承自Hashtable类并且实现了Map接口,也是使用一种键值对的形式来保存数据
* 2.它的使用特点和HashMap类似
* 3.Properties还可以用于 从 xxx.properties文件中,加载数据到Properties类对象,进行读取和修改
* 4.说明: 工作后,xxx.properties 文件通常作为配置文件,这个知识在IO流举例
*
* */
@SuppressWarnings({"all"})
public class Properties_ {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("john", 100); //k-v
        //Properties.put(null, 100);  //异常
        //Properties.put("john", null); //异常
        properties.put("lic", 100); //k-v
        properties.put("lic", 80); //替换
        properties.put("luck", 120);

        //通过key 获取对应的value
        System.out.println(properties.get("john"));
        //如果value的类型String 就返回null
        System.out.println(properties.getProperty("john"));
        //删除元数
        properties.remove("lic");
        System.out.println(properties);
        //修改 , 返回修改前的value值
        System.out.println(properties.put("john", 200));
        System.out.println(properties);

    }
}
