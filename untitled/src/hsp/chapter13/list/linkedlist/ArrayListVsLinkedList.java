package hsp.chapter13.list.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

/*

 LinkedList和ArrayList的比较(都是线程不安全)
_________________________________________________________
               |底层结构      | 增删的效率   | 改查的效率
_______________|_____________|_____________|______________
 ArrayList     |可变数组      | 较低        |  较高
               |             | 数组扩容     |
_______________|_____________|_____________|______________
  LinkedList   |双向链表      | 较高        |  较低
               |             |通过链表追加  |
_______________|_____________|_____________|______________

 如何选择ArrayList和LinkedList
 1)如果我们改查的操作比较多,选择ArrayList
 2)如果我们增删的操作比较多,选择LinkedList
 3)一般来说,在程序中,80%~90%都是查询,因此大部分情况下会选择LinkedList
 4)在一个项目中,根据业务灵活选择,也可能,一个模块使用ArrayList,另一个模块选择LinkedList
*/
@SuppressWarnings({"all"})
public class ArrayListVsLinkedList {

}
