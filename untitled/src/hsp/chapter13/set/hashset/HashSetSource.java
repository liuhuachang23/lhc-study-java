package hsp.chapter13.set.hashset;

import java.util.HashSet;

/*
* HashSet底层机制说明
*   分析HashSet的添加元素底层是如何实现( hash() + equals() )
*
*   1.HashSet底层是 HashMap
*   2.添加一个元素时,先得到hash值,会转成-->索引值
*   3.找到储存数据表table,看这个索引位置是否已经存放了元素
*     (1)如果没有,直接加入
*     (2)如果有(他们的hash相同,因为相同才可能在同一链表上),比较key(key相同就可以判断出为重复元素)不同再调用equals
*       (这个equals程序员是可以重写的,不能只简单的理解成比较元素的内容) 比较如果相同,就放弃添加,如果不同,看他屁股后面有没有元素,
*       没有就直接加到链表后,有就要继续和后面哪个比较,依次类推)
*     //解释一下为什么中间会加一个比较key,因为但hash值和key相同时就可以直接认定为重复元素,如果key不同就不得不再去比较equals
*     //中间加个key比较,可以筛选掉很多东西,直接调用equals耗费性能;
*
*   4.在java8中,如果一条链表的元素个数到达 TREEIFY_YHRESHOLD(默认为8),
*     并且table的大小 >= MIN_TREEIFY_CAPACITY(默认为64),就会进行树化(红黑树)
*
* 接下来分析源码:
* */
@SuppressWarnings({"all"})
public class HashSetSource {
    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        hashSet.add("java");
        hashSet.add("php");
        hashSet.add("java");
        System.out.println("set= " + hashSet);

        /*
        源码解读:
        1.执行 HashSet()
         public HashSet() {
            map = new HashMap<>();
         }

        2.执行 add()
            public boolean add(E e) { //e = "java"
                return map.put(e, PRESENT)==null;  // (final static)PRESENT = new Object();
            }

        3.执行 put()
            public V put(K key, V value) { //key = "java" , value = PRESENT 静态的(共享)
                return putVal(hash(key), key, value, false, true);
            }

         4.执行 hash()
            static final int hash(Object key) {  // key = "java"
                int h;
                //key显然不等于null , 执行算法: (h = key.hashCode()) ^ (h >>> 16)
                //这个算法就是 将 key 的hashcode值 与 其低16位的值 进行异或处理,再返回得到的哈希值
                //这里可能会被提问,得到哈希值是不是这个 hashCode 回答 不是! 做过上述处理
                //异或处理目的是:减少碰撞使哈希值分布更均匀
                return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
            }

         5.执行 putVal()
            final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
                Node<K,V>[] tab; Node<K,V> p; int n, i; //定义了辅助变量
                //table 就是HashMap 的一个数组, 类型是 Node[]
                //此时table = null,进入这个if
                if ((tab = table) == null || (n = tab.length) == 0)
                //执行 resize() : 第一次扩容 table变成一个有 16空间的空数组 , n = tab.length = 16，临界值（threshold）=12
                    n = (tab = resize()).length;

                //(1)根据key,得到的hash , 以及n = 16, 去计算该key应该存放到table表的那个索引位置
                //(2)并把这个位置的对象,赋给 p
                //(3)判断这个p是否为空 (这个位置上有没有其它对象)
                //(3.1)如果这个p == null 就创建一个Node(hash, "java", PRESENT, null),放在tab[i] 这个位置上
                if ((p = tab[i = (n - 1) & hash]) == null)
                    tab[i] = newNode(hash, key, value, null);
                else {
                    Node<K,V> e; K k;

                    if (p.hash == hash &&
                        ((k = p.key) == key || (key != null && key.equals(k))))
                        e = p;
                    else if (p instanceof TreeNode)
                        e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                    else {
                        for (int binCount = 0; ; ++binCount) {
                            if ((e = p.next) == null) {
                                p.next = newNode(hash, key, value, null);
                                if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                    treeifyBin(tab, hash);
                                break;
                            }
                            if (e.hash == hash &&
                                ((k = e.key) == key || (key != null && key.equals(k))))
                                break;
                            p = e;
                        }
                    }
                    if (e != null) { // existing mapping for key
                        V oldValue = e.value;
                        if (!onlyIfAbsent || oldValue == null)
                            e.value = value;
                        afterNodeAccess(e);
                        return oldValue;
                    }
                }
                ++modCount;
                //我们每加入一个节点,size就会加1
                //判断这个table里元素是否已经到达了这个临界值(总容量75%),超过则进入resize()进行扩容
                if (++size > threshold)
                    resize();
                afterNodeInsertion(evict);
                return null; //返回空代表执行成功
            }

          //一步步往返回, 第一个 add("java") 完成
==================================================================================================
          //继续执行 add("php")
            public boolean add(E e) { // e = "php"
                return map.put(e, PRESENT)==null;
            }
          //执行 put()
            public V put(K key, V value) {
                return putVal(hash(key), key, value, false, true);
            }
          //执行 hash()
            static final int hash(Object key) {
                int h;
                //执行算法: (h = key.hashCode()) ^ (h >>> 16) 返回一个处理后的hash值
                return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
            }

          //执行 putVal()

            final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                           boolean evict) {
                Node<K,V>[] tab; Node<K,V> p; int n, i;
                if ((tab = table) == null || (n = tab.length) == 0)
                    n = (tab = resize()).length;
                //(1)根据key,得到的hash , 以及n = 16, 去计算该key应该存放到table表的那个索引位置
                //(2)并把这个位置的对象,赋给 p
                //(3)判断这个p是否为空 (这个位置上有没有其它对象)
                //(3.1)如果这个p == null 就创建一个Node(hash, "php", PRESENT, null),放在tab[i] 这个位置上
                if ((p = tab[i = (n - 1) & hash]) == null)
                    tab[i] = newNode(hash, key, value, null);
                else {
                    Node<K,V> e; K k;
                    if (p.hash == hash &&
                        ((k = p.key) == key || (key != null && key.equals(k))))
                        e = p;
                    else if (p instanceof TreeNode)
                        e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                    else {
                        for (int binCount = 0; ; ++binCount) {
                            if ((e = p.next) == null) {
                                p.next = newNode(hash, key, value, null);
                                if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                    treeifyBin(tab, hash);
                                break;
                            }
                            if (e.hash == hash &&
                                ((k = e.key) == key || (key != null && key.equals(k))))
                                break;
                            p = e;
                        }
                    }
                    if (e != null) { // existing mapping for key
                        V oldValue = e.value;
                        if (!onlyIfAbsent || oldValue == null)
                            e.value = value;
                        afterNodeAccess(e);
                        return oldValue;
                    }
                }
                ++modCount;
                if (++size > threshold)  //判断这个table的元素是否已经到达了这个临界值(总容量75%),超过则进入resize()进行扩容
                    resize();
                afterNodeInsertion(evict);
                return null; //到达这里表示添加元素成功
            }
          //一步步往返回, 第一个 add("php") 完成
==================================================================================================
          //继续执行 add("java")
            public boolean add(E e) { //e = "java"
                return map.put(e, PRESENT)==null;
            }
          //执行 put()
            public V put(K key, V value) {
                return putVal(hash(key), key, value, false, true);
            }
          //执行hash()
            static final int hash(Object key) {
                int h;
                //执行算法: (h = key.hashCode()) ^ (h >>> 16) 返回一个处理后的hash值
                return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
            }
          //执行 putVal()
            final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                           boolean evict) {
                Node<K,V>[] tab; Node<K,V> p; int n, i;
                if ((tab = table) == null || (n = tab.length) == 0)
                    n = (tab = resize()).length;
                //(1)根据key,得到的hash , 以及n = 16, 去计算该key应该存放到table表的那个索引位置
                //(2)并把这个位置的对象,赋给 p
                //(3)判断这个p是否为空 (这个位置上有没有其它对象)
                //因为第一次已经吧"java"这个值传进来了, 且 p = 3 ,所以执行else
                if ((p = tab[i = (n - 1) & hash]) == null)
                    tab[i] = newNode(hash, key, value, null);
                else {
                    //这里可领悟到一些开发技巧:在需要局部变量(辅助变量)时候,再创建
                    Node<K,V> e; K k;

                    //跳到这里, 进行if判断 下面两个判断(&&):
                    //(1)p.hash == hash
                    //  (1.1)p.hash: (p)当前这个索引位置上对应的链表的第一个元素 (.hash)的hash值
                    //  (1.2)hash : 现在传来(准备添加)的对象的hash
                    //  (1.3)两者进行比较
                    //(2) ((k = p.key) == key || (key != null && key.equals(k)))
                    //  (2.1) (k = p.key) == key : p指向Node结点的key == 准备加入的key
                    //  (2.2) (key != null && key.equals(k)) 准备加入的key不为空 或者 kay.equals(p.hash)
                    //以上判断顺序的安排原因:
                        //先判断hash是否相等,但因为有些对象没有重写hashcode让hash值不相等，这样导致的后果就是hashset中会出现key
                        //相等的重复元素，破坏了hashset的特性，所以hash值相等要进一步判断key，如果两个都相等就可以确认是重复元素，
                        //如果key不同，却不能确定是否重复元素（例如key是一个String对象，他们的key不同，但是值有可能相同啊） ，所以
                        //要继续最后一步判断：比较两个对象的equals(这个程序员可以根据需求去重写,不能简单的理解为比较内容)返回值
                        //因为判断去调用equals耗费性能，所以先判断hash值和key(因为当hash值和key相同时就可以确认是重复元素)
                        //可以大大减少调用equals的次数
                    //(注意,这里只是和当前数组位置上的链表的第一个元素进行比较)
                    if (p.hash == hash &&
                        ((k = p.key) == key || (key != null && key.equals(k))))
                        e = p;

                    //到这里代表 上面判断与链表上的第一个元素不是重复元素
                    //判断 p 是不是红黑树
                    //如果是 就调用 putTreeVal 进行添加
                    //这里继续不深入(太深奥)
                    else if (p instanceof TreeNode)
                        e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                    else {
                        //到这里代表 与链表上的第一个元素不是重复元素,也不是红黑树
                        //进入循环, 与链表的后面元素继续依次比较
                        for (int binCount = 0; ; ++binCount) {
                            //p.next : (p)当前这个索引位置上对应的链表的第一个元素 (.next)的后一个元素
                            //判断当前链表位置上的后一个位置是否为空
                            //如果是空就进入
                            if ((e = p.next) == null) {
                                //创建一个新的Node 将传入元素的数据(hash, key, value, null)导入进去,
                                //p.next将新添加的元素链接到链表上
                                p.next = newNode(hash, key, value, null);
                                //判断 该链表是否达到8个结点
                                if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                    //进入treeifyBin(),里面可以进一步判断是否需要树化
                                    //(如果满足了当前tab.length到达了64, 到了就树化,否则不树化,而进行扩容)
                                    //注意:扩容的话n就会改变(第一次扩容n=16),这个改变了,将改变所有的元素在table上的位置
                                    treeifyBin(tab, hash);
                                break;
                            }
                            //不是空,就判断,是否与传来的元素重复,重复就退出循环
                            if (e.hash == hash &&
                                ((k = e.key) == key || (key != null && key.equals(k))))
                                break;

                            //到这里表示上面判断的情况都不是
                            //p = e 表示 p = p.next 指向链表上后一个元素 ,
                            //这个代码很重要,这个就让传进来的元素再次循环的时候跟链表的下一个元素继续判断比较
                            p = e;
                            //再次循环
                        }
                    }
                    //上面代码可知 如果添加元素失败的话 e != null
                    //进入这个就会返回一个oldValue, 退出整个 putVal()
                    //我们知道 不是返回空都代表添加元素失败
                    if (e != null) { // existing mapping for key
                        V oldValue = e.value;
                        if (!onlyIfAbsent || oldValue == null)
                            e.value = value;
                        afterNodeAccess(e);
                        return oldValue;
                    }
                }
                ++modCount;
                if (++size > threshold) //判断是否需要扩容
                    resize();
                afterNodeInsertion(evict);
                return null; //到达这里表示添加元素成功
            }

            //一步步返回 add程序结束

        */
    }
}
