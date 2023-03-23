package hsp.chapter13.list.linkedlist;

/*
 * LinkedList基本介绍
 * 1)LinkedList实现了双向链表和双端队列特点
 * 2)可以添加任意元素(元素可以重复),包括null
 * 3)线程不安全,没有实现同步
 *
 * LinkedList的底层操作机制
 * 1)LinkedList底层维护了一个双向链表
 * 2)LinkedList中维护了两个属性first和last分别指向 首结点和尾结点
 * 3)每个节点(Node对象),里面有维护了 prev next item 三个属性,
 *   其中通过prev指向前一个,通过next指向后一个结点,最终实现双向链表
 * 4)所以LinkedList的元素删除和添加,不是通过数组完成的,相对来说效率较高
 *
 * 模拟一个简单的双向链表:
 * */
public class LinkedList_ {
    public static void main(String[] args) {

        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node hsp = new Node("老韩");

        //链接3个结点,形成双向链表
        //jack-->tom-->hsp
        jack.next = tom;
        tom.next = hsp;
        //hsp-->tom-->jack
        hsp.prev = tom;
        tom.prev = jack;

        //让first引用指向jack,就是双向链表的头结点
        Node first = jack;
        //让last引用指向hsp,就是双向链表的尾结点
        Node last = hsp;

        //演示从头到尾遍历
        while (true) {
            if (first == null) {
                break;
            }
            System.out.println(first);
            first = first.next;
        }
        System.out.println("================");
        //演示从尾到头遍历
        while (true){
            if (last == null){
                break;
            }
            System.out.println(last);
            last = last.prev;
        }
        System.out.println("==================");
        //演示双向链表添加对象/数据,的方便性
        //需求:希望在 tom和老韩 之间加一个对象 mary
        Node mary = new Node("mary");
        tom.next = mary;
        mary.next = hsp;
        hsp.prev = mary;
        mary.prev = tom;

        //再次遍历
        //此时需要将first/last的位置重置(下面遍历用哪个重置哪个,也可以都重置一下方面使用)回来
        first = jack;
        last = hsp;
        while (true){
            if (first == null){
                break;
            }
            System.out.println(first);
            first = first.next;
        }


    }
}

//定义一个Node类, node对象 代表双向链表的一个结点
class Node {
    public Object item; //真正存放数据
    public Node next; //指向下一个结点
    public Node prev; //指向前一个结点

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Node name= " + item;
    }
}