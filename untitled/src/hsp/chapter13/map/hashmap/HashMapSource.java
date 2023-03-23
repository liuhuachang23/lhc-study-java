package hsp.chapter13.map.hashmap;

import java.util.HashMap;

/*
* HashMap底层机制及源码分析
* 扩容机制(和HashSet相同)
* 1)HashMap底层维护了Node类型的table数组, 默认为null
* 2)当创建对象时,将加载因子(loadfactor)初始化为0.75
* 3)当添加key-value时,通过key的哈希值得到在table上的索引,然后判断该索引出是否有元素,
*   如果没有就直接添加,如果该索引处有元素,继续判断该元素的key是否和准备加入的key相等,如果
*   相等,则直接替换value,如果不等需要进行判断是树结构还是链表结构,做出相应处理.如果添加时发现容量不够,则需要扩容
* 4)第一次添加,只需要扩容table为16,临界值(threshold)为12
* 5)以后再扩容,则需要扩容到原来的2倍,临界值也变为原来的2倍
* 6)在java8中,如果一条链表的元素到达8,并且table的容量到达64,就会进行树化
*
* */
@SuppressWarnings({"all"})
public class HashMapSource {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("java", 10);
        map.put("php", 10);
            map.put("java", 20);

        //分析:
        /*
        1. 执行构造器 : 初始化加载因子(0.75)
            public HashMap() {
                this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
            }
        2. 执行put
            public V put(K key, V value) {
                return putVal(hash(key), key, value, false, true);
            }
        3. 执行hash(key) : 传入key 得到key计算出哈希值
            static final int hash(Object key) {  // key = "java"
                int h;
                //key显然不等于null , 执行算法: (h = key.hashCode()) ^ (h >>> 16)
                //这个算法就是 将 key 的hashcode值 与 其低16位的值 进行异或处理,再返回得到的哈希值
                //这里可能会被提问,这个得到的哈希值是不是这个 hashCode 回答 不是! 做过上述处理
                //异或处理目的是:减少碰撞使哈希值分布更均匀
                return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
            }
        4. 执行putVal()
            final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                           boolean evict) {
                Node<K,V>[] tab; Node<K,V> p; int n, i;
                //如果table数组为空,或者length=0, 就扩容
                if ((tab = table) == null || (n = tab.length) == 0)
                    //执行resize(),进行第一次扩容,执行完 n  = tab.length = 16 ; table.length = 16, threshold = 12
                    n = (tab = resize()).length;

                //根据key,得到的hash , 以及n = 16, 去计算该key应该存放到table表的那个索引位置
                //1)并判断该索引出是否有元素,没有就直接吧k-v加入到一个新建的Node结点中,并将结点放到这个位置
                if ((p = tab[i = (n - 1) & hash]) == null)
                    tab[i] = newNode(hash, key, value, null);
                else {
                    Node<K,V> e; K k;
                    //1)如果table现有的结点位置(当前链表的第一个元素)的key的hash值和准备加入的key的hash值相同
                    //并且 满足(table现有的结点的key和准备添加的key是同一个对象 || 两个对象的equals返回值相同)
                    if (p.hash == hash &&
                        ((k = p.key) == key || (key != null && key.equals(k))))
                        e = p;
                    //2)如果当前的table的已有的Node,是红黑树,就按照红黑树的红黑树的机制处理
                    else if (p instanceof TreeNode)
                        e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                    else {
                        //3)如果找到的结点,后面是链表,就循环比较
                        for (int binCount = 0; ; ++binCount) {
                            //如果整个链表没有和他相同的元素,就加入到该链表结构
                            if ((e = p.next) == null) {
                                p.next = newNode(hash, key, value, null);
                                //判断链表是否到达8,
                                //到达了8,就调用treeifyBin(tab, hash),进行红黑树机制(先看table容量,在考虑是扩容还是树化)
                                //跳出循环
                                if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                    treeifyBin(tab, hash);
                                break;
                            }
                            //在循环比较过程中发现,有和传入的元素相同的,就停止添加,跳出循环
                            if (e.hash == hash &&
                                ((k = e.key) == key || (key != null && key.equals(k))))
                                break;
                            //这个代码很重要,这个就让传进来的元素再次循环的时候跟链表的下一个元素继续判断比较
                            p = e;
                        }
                    }
                    //当添加失败时,进入该语句, 替换与key相同的元素的value值
                    if (e != null) { // existing mapping for key
                        V oldValue = e.value;
                        if (!onlyIfAbsent || oldValue == null)
                            e.value = value;
                        afterNodeAccess(e);
                        return oldValue; //返回oldValue, 退出putVal()
                    }
                }
                ++modCount; //修改次数加1
                //判断table元素个数是否大于临界值,判断是否需要扩容
                if (++size > threshold)
                    resize();
                afterNodeInsertion(evict);
                return null; //返回null, 退出putVal()
            }


        */
    }
}
