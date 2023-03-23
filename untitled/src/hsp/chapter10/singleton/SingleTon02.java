package hsp.chapter10.singleton;

/*
 <饿汉式> VS <懒汉式>
    1.两者最主要区别在于,创建对象的时机不同
        饿汉式:类加载就创建了实例对象
        懒汉式:使用时才创建对象

    2.饿汉式不存在线程安全问题,懒汉式存在线程安全问题

    3.饿汉式存在资源浪费的可能性 因为如果一个程序员一个对象实例都没有使用,那么饿汉式
      创建的对象实例就浪费了,懒汉式时使用时才创建对象,就不存在这个问题

    4.我们在javaSE标准类中,java.lang.Runtime就是经典的单例模式(饿汉式)

*/

//<懒汉式>
//步骤
//构造器私有化
//定义一个static属性对象
//提供一个public的static方法,用于返回一个Cat对象
//用户调用getInstance时,才返回cat对象,后面再次调用时,会返回上次创建的cat对象
public class SingleTon02 {
    public static void main(String[] args) {
        //调用静态属性(类加载)
        //但是没有创建对象(构造器未被调用)
        //所以就避免了,饿汉式的弊端
        System.out.println(Cat.n1);

        //调用getInstance
        //创建对象
        System.out.println(Cat.getInstance());

        //再次调用getInstance
        //返回的cat对象就是第一次创建出来的cat对象
        System.out.println(Cat.getInstance());

    }
}

class Cat {
    private String name;
    //定义一个静态属性,用于测试
    public static int n1 = 999;
    //定义一个static属性对象
    private static Cat cat;

    //构造器私有化
    private Cat(String name) {
        System.out.println("构造器被调用");
        this.name = name;
    }

    public static Cat getInstance() {
        if (cat == null) { //表示还没有创建cat对象
            cat = new Cat("小可爱");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
