package hsp.chapter12.arrays;

import java.util.Arrays;
import java.util.Comparator;
//自定义Book类,里面包含name和price，要求使用定制排序完成：按price排序，按name长度
//有一个Book[] books = 5 本书对象
public class ArraysExercise {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅新", 90);
        books[2] = new Book("青年文稿20年", 5);
        books[3] = new Book("java从入门到放弃", 300);

        //按照书的价格排序
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                double priceX = b1.getPrice() - b2.getPrice();
                if (priceX > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        System.out.println(Arrays.toString(books));

        //按照书名长度排序
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                return b1.getName().length() - b2.getName().length();
            }
        });
        System.out.println(Arrays.toString(books));
    }


    /*public static void bubble(Book[] books, Comparator c) {
        Book temp;
        for (int i = 0; i < books.length - 1; i++) {
            for (int j = 0; j < books.length - 1 - i; j++) {
                if (c.compare(books[j].getPrice(), books[j + 1].getPrice()) > 0) {
                    temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }*/
}

class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
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

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
