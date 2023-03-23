package hsp.chapter13.homework;

import java.util.TreeSet;

@SuppressWarnings({"all"})
public class Homework05 {
    public static void main(String[] args) {

        TreeSet treeSet = new TreeSet();
        /*
        执行add()，因为 TreeSet() 构造器没有传入Comparator 接口的匿名内部类
        所以在底层他会调用传入对象实现的Comparable接口的compareTo方法去比较:
        final int compare(Object k1, Object k2) {
            return comparator==null ? ((Comparable<? super K>)k1).compareTo((K)k2)
                : comparator.compare((K)k1, (K)k2);
        }
        而此时的对象没有实现Comparable的compareTo方法， 所以到：(Comparable<? super K>)k1
        即 把 Person转成 Comparable类型 会抛出异常：ClassCastException

        如何解决；
        1）在构造器中传入Comparator匿名对象
        2）Person01类 实现Comparable接口的compareTo方法
        */

        treeSet.add(new Person01());
        treeSet.add(new Person01());
        treeSet.add(new Person01());
        System.out.println(treeSet); //只能输出一个对象

    }
}

/*
class Person01 {
}
*/

//Person01类 实现Comparable接口的compareTo方法
class Person01 implements Comparable {
    @Override
    public int compareTo(Object o) {
        return 0; //不管创建多个对象加入到add中都只能添加进一个（返回零，代表相同的元素）
    }
}
