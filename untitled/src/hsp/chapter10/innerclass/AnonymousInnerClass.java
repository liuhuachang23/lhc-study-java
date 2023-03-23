package hsp.chapter10.innerclass;

/*
匿名内部类（重要！！！）
    1）本质是类 2）内部类 3）该类没有名字 4）同时还是一个对象
基本语法：
    new 类或接口(参数列表){
        类体
    }
*/
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();

    }
}

class Outer04 {
    private int n1 = 10;

    public void method() {

        //基于接口的匿名内部类==================
        //需求：想使用IA接口，并创建对象
        //1、传统方式：写一个类，实现接口，并创建对象
        //需求升级，Tiger/Dog 类只是使用一次，后面再不使用

        //2.使用匿名内部类来简化开发
        //解析匿名内部类
        /*
        1)tiger 的编译类型: IA
        2）tiger 的运行类型: 就是匿名内部类 Outer04$1
        3)我们看底层系统会分配 类名 Outer04$1
        4)jdk底层在创建匿名内部类 Outer04$1
            class Outer04$1 implements IA{
                @Override
                public void cry() {
                    System.out.println("老虎叫唤...");
                }
            }
        5）然后立即创建Outer04$1实例，并且吧地址返回给tiger
        6）匿名内部类使用一次，就不能在使用
        */
        IA tiger = new IA() {
            @Override
            public void cry() {
                System.out.println("老虎叫唤...");
            }
        };
        //这里我们可以测试一下tiger的运行类型
        System.out.println("tiger的运行类型= " + tiger.getClass());
        //上面说的匿名内部类使用一次，不是指只能调用一次(可以无数次)
        tiger.cry();//动态绑定
        tiger.cry();


        //基于类的匿名内部类==========================
        //需求：想要使用Father类(把它当成父类，继承它的东西)，只使用一次
        //分析
        /*
        1)father 的编译类型：Father
        2)father 的运行类型：Outer04$2
        3)底层创建匿名内部类
        class Outer04 extends Father{
            @Override
            public void test() {
                System.out.println("匿名内部类重写了test方法");
            }
        }
        4）立即创建创建Outer04$2实例，并把地址返回给father
        5）注意("jack")参数列表会传递给 构造器
        */

        Father father = new Father("jack") {
            @Override
            public void test() {
                System.out.println("匿名内部类重写了test方法");
            }
        };
        //查看father的运行类型
        System.out.println("father的运行类型= " + father.getClass());
        father.test();//动态绑定


        //基于抽象类的匿名内部类 =================
        //需求：想要使用这个抽象类，（跟上面两种，原理相似）
        Animal animal = new Animal() {
            @Override
            void eat() {
                System.out.println("小狗啃骨头...");
            }
        };
        animal.eat();//动态绑定
    }
}

//接口
interface IA {
    public void cry();
}

//类
class Father {
    //构造器
    public Father(String name) {
        System.out.println("接收到name= " + name);
    }

    public void test() {
    }
}

//抽象类
abstract class Animal {
    abstract void eat();
}

