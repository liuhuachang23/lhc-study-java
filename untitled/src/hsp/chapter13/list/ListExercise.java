package hsp.chapter13.list;

import java.util.*;

@SuppressWarnings({"all"})
public class ListExercise {
    public static void main(String[] args) {
        //三种实现类都行
        //List list = new ArrayList();
        //List list = new LinkedList();
        List list = new Vector();


        list.add(new Book("三国演义", 100, "罗贯中"));
        list.add(new Book("小李飞刀", 90, "古龙"));
        list.add(new Book("红楼梦", 200, "曹雪芹"));

        sort(list);

    }

    public static void sort(List list) {

        //按价格排序
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                Object o1 = list.get(j);
                Object o2 = list.get(j + 1);
                //向下转型
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                if (book1.getPrice() > book2.getPrice()) {
                    //交换
                    list.set(j, book2);
                    list.set(j+1, book1);
                }
            }
        }

        //使用迭代器遍历
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            System.out.println(o);
        }

    }
}

class Book {
    private String name;
    private double price;
    private String author;

    public Book(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "名称: " + name + "  \t\t" + "价格: " + price + " \t\t" + "作者: " + author;
    }
}