package hsp.chapter13.set.treeset;

import java.util.Comparator;
import java.util.TreeSet;


@SuppressWarnings({"all"})
public class TreeSet_ {
    public static void main(String[] args) {
        //分析：
        //1. 当我们使用无参构造器，创建TreeSet，则以你添加的对象实现的Comparable接口的compareto()去排序
        //TreeSet treeSet = new TreeSet();
        //2. 我们现在希望添加的元素，按照字符串大小来排序
        //3. 使用TreeSet提供的构造器，可以传入一个比较器(匿名内部类)
        //   并且指定排序规则
        //4.简单看看源码：
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //下面 就是调用String的compareTo方法 ,让传入的两个参数进行字符串大小比较（可以自己设置比较规则）
                //return ((String)o1).compareTo((String) o2);
                //现在想要将排序规则改为字符串的长度
                return ((String)o1).length()-(((String) o2).length());
            }
        });
        //treeSet.add(null); //异常
        treeSet.add("jack");
        treeSet.add("tom"); //长度为3
        treeSet.add("sp");
        treeSet.add("a");
        //treeSet.add("tom"); //大小与tom一样,加入失败
        treeSet.add("abc"); //长度为也3 ，所以加入失败

        System.out.println(treeSet);

        /*
        1.构造器把转入的比较器对象，赋值给了TreeSet底层的TreeMap的底层的属性this.compareto
            public TreeMap(Comparator<? super K> comparator) {
                this.comparator = comparator;
            }
        2. 执行put()
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
           后面添加,在底层会执行：
                Comparator<? super K> cpr = comparator; //将比较器赋给cpr
                if (cpr != null) {
                    do { //遍历所以的key,给加入的key找到适当位置
                        parent = t; //t代表table表中正在被比较的对象
                        cmp = cpr.compare(key, t.key); //动态绑定到匿名内部类的compare
                        if (cmp < 0) //比较结果小于0，添加方式
                            t = t.left;
                        else if (cmp > 0) //比较结果大于0，添加方式
                            t = t.right;
                        else  //遍历过程中发现准备添加的key,和当前已有的key 相等(比较结果为0),就不添加了,退出put
                            return t.setValue(value);
                    } while (t != null); //t = null(找到适当位置了)退出循环
                }
        */



    }
}
