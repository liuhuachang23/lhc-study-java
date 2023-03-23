package hsp.chapter13.map.treemap;

import java.util.Comparator;
import java.util.TreeMap;

@SuppressWarnings({"all"})
public class TreeMap_ {
    public static void main(String[] args) {

        //使用无参构造器(默认使用的是添加的对象实现的Comparable接口的comparato()去排序)
        //TreeMap treeMap = new TreeMap();
        //也可以使用TreeSet提供的构造器，可以传入一个比较器(匿名内部类)
        //如果添加的对象使用无参构造器，也没有实现Comparable接口的comparato()，就会报错
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //按字符串大小比较
                //return ((String)o1).compareTo((String)o2);
                //按字符串长度比较
                return ((String)o1).length() - ((String)o2).length();
            }
        });

        //treeMap.put(null,"空"); //异常
        treeMap.put("jack", "杰克");
        treeMap.put("tom", "汤姆");
        treeMap.put("kristina", "克瑞斯提诺");
        treeMap.put("smith", "史密斯");
        //treeMap.put("smith", "史密"); //字符串大小相同,value替换
        treeMap.put("hsp", "韩顺平"); //字符串长度相同,value替换


        System.out.println(treeMap);

        //分析
        /*
        1.执行构造器 ,吧转入的实现了Comparator接口的匿名内部类(对象),传给了TreeMep的comparator
            public TreeMap(Comparator<? super K> comparator) {
                this.comparator = comparator;
            }
        2. 执行 put()
            第一次添加: 吧k-v封装到 Entry 对象, 放入root
                if (t == null) {
                    //传入两个第一次添加的key(相同),
                    //也是动态绑定到匿名内部类,只是为了检查这个值是不是空值,空的话会抛异常
                    //但是它返回的结果没有去接收,所以结果不会产生任何影响（不为空的时候，空的话会抛异常）
                    compare(key, key); // type (and possibly null) check

                    root = new Entry<>(key, value, null);
                    size = 1;
                    modCount++;
                    return null;
                }
            第二次添加:
                Comparator<? super K> cpr = comparator; //将比较器赋给cpr
                if (cpr != null) {
                    do { //遍历所以的key,给加入的key找到适当位置
                        parent = t; //t代表table表中正在被比较的对象
                        cmp = cpr.compare(key, t.key); //动态绑定到匿名内部类的compare
                        if (cmp < 0) //比较结果小于0，添加方式
                            t = t.left;
                        else if (cmp > 0) //比较结果大于0，添加方式
                            t = t.right;
                        else  //遍历过程中发现准备添加的key,和当前已有的key 相等(比较结果为0),就不添加了,替换value ,退出put
                            return t.setValue(value);
                    } while (t != null); //t = null(找到适当位置了)退出循环
                }

        */
    }
}
