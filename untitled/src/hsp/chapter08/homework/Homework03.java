package hsp.chapter08.homework;
//编写Book，定义方法updatePrice，实现更改某本书的价格
//具体：如果价格>150，则更改为150，如果价格>100，更改为100，否则不变
public class Homework03 {
    public static void main(String[] args) {
        //创建对象
        Book book = new Book("红高粱",300);
        System.out.println("书名为: " + book.name + " 的的价格为: " + book.price);
        book.newPrice();
        System.out.println("书名为: " + book.name + " 的价格更新为: " + book.price);
    }
}

class Book{

    String name;
    double price;
    //构造函数
    public Book(String name, double price){
        this.name = name;
        this.price = price;
    }
    //更新书籍价格
    public void newPrice(){
        //这个方法中没有newPrice局部变量，所以这里的this可写可不写
        if (this.price >= 150){
            this.price = 150;
        } else if (price >= 100){
            this.price = 100;
        } else {
            this.price = price;
        }
    }
}
