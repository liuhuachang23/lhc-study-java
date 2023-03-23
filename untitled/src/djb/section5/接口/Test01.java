package djb.section5.接口;

/*
* 1.接口是一种引用数据类型
* 2.接口是完全抽象的（抽象类是半抽象） 或者也可以说接口是特殊的抽象类
* 3.接口怎么定义，语法是什么？
*       [修饰符列表] interface 接口名{}
* 4.接口支持多继承,一个接口可以继承多个接口
* 5.接口中只包含两部分，一部分是：常量。一部分是：抽象方法。接口中没有其他内容
* 6.接口中所有元素都是public修饰（都是公开的）
* 7.接口中抽象方法定义时：public abstract修饰符可以省略
* 8.接口中的常量的 public static final 可以省略.
* */

public class Test01 {

    public static void main(String[] args) {
        System.out.println(MyMath.PI);
    }
}

//定义接口
interface A{}

//接口继承
interface B extends A{}

//一个接口可以继承多个接口
interface C extends A,B{}

//我的数学接口
interface MyMath{

    //常量
    //public static final double PI = 3.1415926;
    //常量中的 public static final 可以省略
    double PI = 3.1415926;

    //所以接口中随便定义一个变量都是常量,不可重新赋值
    int c = 100;


    //抽象方法
    //public abstract int sum(int a,int b);
    //接口中都是抽象方法,在编写代码的时候, public abstract可以省略
    int sum(int a,int b);

    //接口中的方法可以有方法体吗?
    //不可以:接口抽象方法不能带有主体
    /* void doSome(){
        }*/

    //相减的抽象方法
    int sub(int a,int b);
}

