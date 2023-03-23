package hsp.chapter13.list.arraylist;
import java.util.ArrayList;
import java.util.List;

/*
 * ArrayList的注意事项
 * 1)permits all elements, including null, ArrayList 可以加入null,并且可以多个
 * 2)ArrayList 是由数组来实现数据存储的
 * 3)ArrayList 基本等同于Vector, 除了ArrayList线程不安全(但执行效率高),多线程情况下不建议使用
 *
 * */
public class ArrayList_ {
    public static void main(String[] args) {

        /*
        1.ArrayList线程不安全,可以看源代码 没有synchronized
            public boolean add(E e) {
                ensureCapacityInternal(size + 1);  // Increments modCount!!
                elementData[size++] = e;
                return true;
            }
        */
        List list = new ArrayList();
    }
}
