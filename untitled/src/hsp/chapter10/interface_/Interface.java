package hsp.chapter10.interface_;

import sun.plugin2.message.JavaReplyMessage;

/*
什么是接口
 1.接口是一种引用数据类型
 2.接口是完全抽象的（抽象类是半抽象） 或者也可以说接口是特殊的抽象类
 3.接口怎么定义，语法是什么？
       [修饰符列表] interface 接口名{}
 4.接口支持多继承,一个接口可以继承多个接口
 5.接口中只包含两部分，一部分是：常量。一部分是：抽象方法。接口中没有其他内容
    (jdk8及以上 接口可以有 静态方法，默认方法，也就是说接口中可以有方法体的实现)
 6.接口中所有元素但是public修饰（都是公开的）
 7.接口中抽象方法定义时：public abstract修饰符可以省略
 8.接口中的常量的 public static final 可以省略（所以在接口中定义的变量都是常量）

接口的基础语法:
    1.类和类之间叫继承,类和接口之间叫实现(可以看做继承)
         继承使用extend关键字完成
         实现使用implements关键字完成
     2.当一个抽象的类实现接口的话,必须将接口中所有的抽象方法全部实现(重写/覆盖)
 */
public class Interface {
    public static void main(String[] args) {

        MysqlDB mysqlDB = new MysqlDB();
        OracleDB oracleDB = new OracleDB();
        oracleDB.CC();
        Computer computer = new Computer();
        computer.work(mysqlDB);
        computer.work(oracleDB);
    }
}

class Computer{
    public void work(DBInterface dbInterface){
        dbInterface.connect();
        dbInterface.close();
    }
}

interface DBInterface{
    //常量
    int n1 = 999;
    //抽象方法
    void connect();
    void close();
    //jdk8及以上 接口可以有 静态方法，默认方法，也就是说接口中可以有方法体的实现
    public static void AA(){}
    public default void CC(){}
}


class MysqlDB implements DBInterface {

    @Override
    public void connect() {
        System.out.println("链接Mysql数据库");
    }

    @Override
    public void close() {
        System.out.println("关闭Mysql数据库");
    }
}

class OracleDB implements DBInterface{

    @Override
    public void connect() {
        System.out.println("链接Oracle数据库");
    }

    @Override
    public void close() {
        System.out.println("关闭Oracle数据库");
    }
}
