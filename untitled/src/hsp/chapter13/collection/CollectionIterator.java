package hsp.chapter13.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
* Collection接口遍历元素方式: 使用Iterator(迭代器)
* 1.什么是迭代器
*   1) Iterator对象被称为迭代器,主要用于遍历Collection集合中的元素
*   2) 所有实现了Collection接口的集合类都有一个iterator()方法,用于
*      返回一个实现了Collection接口的对象,即可以返回一个迭代器
*   3) Iterator 的结构图（下方原理图了解）
*   4) Iterator 仅用于遍历集合,Iterator本身并不存放对象
*
* 2.迭代器的执行原理
*   1) 迭代器里面有一些方法:
*       hasNext() : 判断是否还有下一个元素 ,返回一个boolean
*       next() : 指针下移  将下移以后集合位置上的元素返回
*       remove() : 很少用，不做介绍
*   1） 提示：在调用iterator.next()方法之前，必须要调用iterator.hasNext()进行检测。
*            若不调用，且下一条记录无效，直接调用iterator.next()会抛出 NoSuchElementException异常
*   3) 代码实现：
*       Iterator iterator = coll.iterator(); //得到一个集合的迭代器
 *      while(iterator.hasNext()){
*           next(); //指针下移，将下移以后集合的位置上的元素符号
*           System.out.println(iterator.next());
*       }
*                                               iterator      _________
*                                          ------------->    |123      |
*                                         iterator.next()    |_________|
*                                                            |AAA      |
*                                                            |_________|
*                                                            |new Cat()|
*                                                            |_________|
*                                                            |1        |
*                                                            |_________|
*
*                                                            迭代器原理图
* */
public class CollectionIterator {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        Collection col = new ArrayList();

        col.add(new Book("三国演义", "罗贯中", 100));
        col.add(new Book("小李飞刀", "古龙", 80));
        col.add(new Book("红楼梦", "曹雪芹", 200));

        //System.out.println(col);
        //不想一起输出, 希望可以一个个遍历出来
        //1.先得到 col 对应的迭代器
        Iterator iterator = col.iterator();
        //2.使用while循环遍历
        //快速生成这个while循环 : itit
        //忘记了快捷键了怎么办 : ctrl + j (可以把快捷键显示出来)
        while(iterator.hasNext()){ //判断是否还有下一个元素
            //返回下一个元素,类型为Objiec
            Object o = iterator.next();
            System.out.println(o);
        }
        //3.当退出while循环后,这时iterator迭代器已经指向了最后元素
        //在去使用 iterator.next(); 就会抛出异常 NoSuchElementException
        //iterator.next();

        //4.想要再次遍历,需要重置我们的迭代器
        iterator = col.iterator();
        //5.再次遍历
        System.out.println("===第二次遍历===");
        while (iterator.hasNext()) {
            Object o =  iterator.next();
            System.out.println(o);
        }

    }
}

class Book{
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
