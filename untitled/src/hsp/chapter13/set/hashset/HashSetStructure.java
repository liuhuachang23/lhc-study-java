package hsp.chapter13.set.hashset;
/*
* HashSet底层机制说明
*   HashSet底层是HashMap, HashMap底层是(数组 + (单向)链表 + 红黑树)
*   数组类型 Node[]
*
*
* */
@SuppressWarnings({"all"})
public class HashSetStructure {
    //模拟一个简单的 数组+链表 结构
    public static void main(String[] args) {

        //1.创建一个数组, 数组类型是 Node[] 也可称为表
        Node[] table = new Node[16];
        System.out.println("table= " + table);
        //创建结点
        Node john = new Node("john", null);
        //将结点存放到table数组下标为2的位置上
        table[2] = john;
        //创建结点
        Node jack = new Node("jack", null);
        //将jack结点挂在john后面,形成有2个结点的链表
        john.next = jack;
        //创建结点
        Node rose = new Node("rose", null);
        //将rose结点挂在jack后面 , 形成有3个结点的链表
        jack.next = rose;
        System.out.println("table= " + table);

        Node lucy = new Node("lucy", null);
        //将lucy放到table数组下标为3的位置上
        table[3] = lucy;
        System.out.println("table= " + table);
    }
}

class Node{ //结点, 存储数据, 可以指向下一个结点, 从而写成链表
    Object item;
    Node next;

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}