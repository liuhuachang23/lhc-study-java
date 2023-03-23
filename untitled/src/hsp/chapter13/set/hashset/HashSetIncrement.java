package hsp.chapter13.set.hashset;


import java.util.HashSet;


/*
 * HashSet底层机制说明
 *   分析HashSet的扩容和转成红黑树机制
 *
 *   1.HashSet底层是HashMap,第一次添加时,table数组扩容到16,
 *      临界值(Threshold) =  (原容量)16*(加载因子loadFactor)0.75 = 12
 *   2.如果table数组使用到了临界值12,就会扩容到16*2=32, 新的临界值就是32*0.75=24,依次类推
 *      注意这里的临界值12，指的是整个数据及链表上的所有元素个数到达12，不要误以为是再table数组上占了12个位置才触发
 *   3.在java8中,如果链表的元素个数到达TREEIFY_THRESHOLD(默认为8),并且table的大小>=MIN_TREEIFY_CAPACITY(默认64)
 *     就会进行树化(红黑树) , 如果table没有满64,就会不会树化,而进行扩容,扩容完了n(代表容量大小,结合hash用于计算元素在table上的位置)
 *     会改变(同一链表上的元素算出的位置还是相同),会影响所有链表在table上的分布,但是链表还是不会拆分,
 *     就有可能会使一个链表上有超过8个元素,等table扩容满64之后,链表将会化树
 *
 *
 * 下面来演示一下
 * */
@SuppressWarnings({"all"})
public class HashSetIncrement {
    public static void main(String[] args) {

        HashSet set = new HashSet();

        /*
        //演示HashSet的扩容
        for (int i = 0; i <100 ; i++) {
            set.add(i);
`        }
        */

        //演示HashSet的转成红黑树机制
        //这里要想办法下面添加的元素在table表上的同一个链表上,才好触发红黑树机制
        //我们知道,当元素的哈希值相等时,他们就在同一个链表上
        for (int i = 0; i <12 ; i++) {
            set.add(new A(i)); //hash固定 equals不同
        }


    }
}

//我们定义一个类
class A{
    private int n;

    public A(int n) {
        this.n = n;
    }

    //重写这个类hashCode(), 将他们的返回值固定的hash,就可以让他们在同一个链表上
    //因为重写了hashCode(),就直接用这个
    @Override
    public int hashCode() {
        return 100;
    }
}
