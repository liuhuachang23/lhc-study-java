package hsp.chapter14.generic;


/*
* 泛型介绍
*
* int a = 10;
* 泛型可以理解为：泛型就是表示数据类型的一种数据类型
* 泛(广泛)型(类型) =可以将它指定为=> Integer, String, Dog，等等
*
* 1) 泛型又称参数化类型, 是jdk5.0出现的新特性, 解决数据类型的安全性问题
* 2) 在类声明或实例化时只要指定好需要的具体的类型即可
* 3) java泛型可以保证如果程序在编译时没有发出错误警告,运行时就不会产生
*    ClassCastException异常, 同时, 代码更加简洁, 健壮
* 4) 泛型的作用是: 可以在类声明时通过一个 标识 表示 类中某个属性的类型、某个方法的返回值
*    的类型、是某个方法的参数类型
*
* 泛型的语法
*
* 1.泛型的声明
*   interface接口<T>{} 和 class类<K,V>{}  //比如: List, ArrayList
*   说明:
*   1)其中， T、K、V 不代表值，而是表示类型
*   2)任意字母都可以, 常用T表示, 是Type缩写
*
* 2.泛型的实例化；
*   要在类名后面指定类型参数的值（类型），如：
*   1) List<String> strList = new ArrayList<String>();
*   2) Iterator<Customer> iterator = customers.iterator();
*
*
* */
public class Generic03 {
    public static void main(String[] args) {
        //注意：E的具体数据类型在定义Person对象的时候指定（即在编译期间，就确定E是什么类型）
        //创建对象，指定E的数据类型
        Person<String> person1 = new Person<String>("韩顺平教育");
        /*
        Person类就变成
        class Person<String>{
            String s;
            public Person(String s) {
                this.s = s;
            }
            public String f(){}
        }
        */
        person1.show(); // String

        //创建对象，指定E的数据类型
        Person<Integer> person2 = new Person<Integer>(100);
        /*
        Person类就变成
        class Person<Integer>{
            Integer s;
            public Person(Integer s) {
                this.s = s;
            }
            public Integer f(){}
        }
        */
        person2.show(); // Integer

    }

}

class Person<E>{
    E s; //E表示 类中属性s的类型，该数据类型在定义(创建)Person对象的时候指定，即在编译期间，就确定E是什么类型

    public Person(E s) { //E 也可以是参数类型
        this.s = s;
    }

    public E f(){ //E 也可用于返回类型
      return s;
    }

    public void show(){
        System.out.println("s的运行类型：" + s.getClass()); //显示 s 的运行类型
    }
}