package djb.object.finalize方法;

/*
* 关于Object类中finalize()方法
*   1.在Object类中的源代码：
*       protected void finalize() throws Throwable { }
*
*   2.finalize() 方法只有一个方法体，里面没有代码，这个方法是protected修饰的。
*
*   3.这个方法不需要程序员自己手动调用
*       当一个java对象即将被垃圾回收器回收时候，JVM的垃圾回收器负责调用finalize()方法
*
*   4.finalize()方法实际上就是SUN公司为java程序员准备的一个时机，垃圾销毁时机。
*       如果希望在对象销毁时执行一段代码，这段代码可以写到finalize()方法当中。
*       比如有需求：所有对象在JVM中被释放的时候，请记录一下释放时间！！！
*
*   5.java中的垃圾回收器不是轻易启动的，
*       垃圾太少 / 时间没到 ，种种条件下，才可能启动
*
*   6.建议启动垃圾回收器代码
*       System.gc();
*
*
* */

public class Test {
    public static void main(String[] args) {

        //创建对象
        Person p = new Person();

        //怎么吧person对象变成垃圾
        p = null;

        //但是垃圾太少了，无法启动
        //制造更多的垃圾
        for (int i = 0; i < 1000000; i++){
            Person p1 = new Person();
            p1 = null;
        }

        Person p2 = new Person();
        p = null;

        //有一段代码可以建议垃圾回收器启动。
        //只是建议启动
        System.gc();

    }
}

class Person{

    //重写finalize()方法
    //person类型的对象被垃圾回收器回收的时候，垃圾回收器负责调用：p.finalize();
    protected void finalize() throws Throwable {
        //this代表当前对象
        System.out.println(this + "即将被销毁！");
    }
}
