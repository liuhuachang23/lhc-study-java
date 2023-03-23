package hsp.chapter13.list.linkedlist;

import java.util.LinkedList;

//LinkedList的增删改查
@SuppressWarnings({"all"})
public class LinkedListCRUD {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        //添加结点
        linkedList.add(1);
        System.out.println("LinkedList.add(1)= " + linkedList);

        //源码解读
        /*
         1.调用无参构造器
                public LinkedList() {
                }

         2. 这时 LinkedList 的属性 first = null, last =null
         3. 执行add(1)
            1)执行 LinkedList.add(e) // e == 1
                public boolean add(E e) {
                    linkLast(e);
                    return true;
                }
            2)执行 linklast(e) // e ==1
                void linkLast(E e) {
                    final Node<E> l = last;                         //last为null , 赋值给 l 也为空
                    final Node<E> newNode = new Node<>(l, e, null); //创建一个新的 Node对象 newNode(null, e, null)
                    last = newNode;                                 //last指向这个新对象 newNode
                    if (l == null)                                  //l为空 进入if
                        first = newNode;                            //first 也指向这个新对象 newNode
                    else
                        l.next = newNode;
                    size++;                                         //链表元素加一
                    modCount++;                                     //记录修改次数加一
                }

             3) 一步步返回 完成对象的添加
        */
        //继续添加
        linkedList.add(2);
        System.out.println("LinkedList.add(2)= " + linkedList);

        /*
        //执行add(2)
        1)执行 LinkedList.add(e) // e ==2
            public boolean add(E e) {
                linkLast(e);
                return true;
            }
        2)执行 linklast(e) // e == 2
            void linkLast(E e) {
                //此时last已经指向了 上一个对象 newNode(null, 1, null) ,使用l也指向上一个对象
                final Node<E> l = last;
                //创建一个新的 Node对象 newNode(l, e, null) //这里将l赋给了新对象的prev ,说明 newNode.prev = Node
                final Node<E> newNode = new Node<>(l, e, null);
                last = newNode; //last重新指向 现在创建的新对象 newNode
                if (l == null)  //l不为空 , l指向的是上一个对象
                    first = newNode;
                else
                    l.next = newNode;  //执行这个 表示上一个Node对象的next指向这个新对象,即 Node.next = newNode
                size++;         //链表元素加一
                modCount++;    //记录修改次数加一
            }
        3) 一步步返回 完成对象添加
        */
        linkedList.add(3);
        System.out.println("LinkedList.add(3)= " + linkedList);

        //删结点
        linkedList.remove(); //默认删除第一个
        System.out.println("LinkedList.remove()= " + linkedList);
        /*
        1.进入remove
         1)public E remove() {
            return removeFirst(); //默认删除第一个
           }
         2)进入 removeFirst()
            public E removeFirst() {
                final Node<E> f = first; //first是指向第一个结点的, 所以 f 也指向第一个结点
                if (f == null) //判断第一个结点是否存在,不存在就抛出异常
                    throw new NoSuchElementException();
                return unlinkFirst(f);
            }
         3)进入unlinkFirst(f)
            private E unlinkFirst(Node<E> f) {
                // assert f == first && f != null;
                final E element = f.item;  //将第一个结点的数据赋给element
                final Node<E> next = f.next; //f.next 指向的是第二个结点 所以next指向第二个结点
                f.item = null; //将第一个结点数据清空 即第一个结点里面的 item属性=null
                f.next = null; // help GC //表示:将第一个结点指向第二个结点的线切断 即第一个结点里面 next属性=null,并请求调用GC机制
                first = next;  // 因为上面已经将next 指向了第二个结点, 所以first也变成指向第二个结点
                if (next == null)  //这个是判断是否存在下一个结点的
                    last = null;
                else
                    next.prev = null; //将第二个结点指向第一个结点的线切断 即 第二个结点里面的 prev属性=null ,到这里就删干净了
                size--;                 //链表元素减一
                modCount++;             //记录修改次数加一
                return element;        //返回第一个结点(被删除结点)里面的数据
            }
         4)一步步返回完成结点(对象)的删除
        */

        //修改
        linkedList.set(1, 999);
        System.out.println("LinkedList.set(1, 999)= " + linkedList);

        //得到
        linkedList.get(1);
        System.out.println("linkedList.get(1)" + linkedList.get(1));

    }
}
