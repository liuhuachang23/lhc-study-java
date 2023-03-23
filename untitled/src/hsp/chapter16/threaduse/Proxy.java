package hsp.chapter16.threaduse;
/*
* 来模拟一下：代理模式
* */
public class Proxy {
    public static void main(String[] args) {
        //我们模拟一下这个代理模式：
        //创建tiger对象，实现了Runnable接口
        Tiger tiger = new Tiger();
        //创建一个线程代理类
        ThreadProxy threadProxy = new ThreadProxy(tiger);
        //就可以调用start()了
        threadProxy.start();
    }
}


class Animal{}

//定义一个老虎类，继承了动物类，实现了Runnable接口
class Tiger extends Animal implements Runnable{

    @Override
    public void run() {
        System.out.println("老虎嗷嗷叫...");
    }
}

//模拟一个极简的Thread类
class ThreadProxy implements Runnable { //ThreadProxy（Thread代理类）

    private  Runnable target = null; // Runnable类型的 属性

    //构造器
    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    //写一个start方法，调用start0()
    public void start(){
        start0();
    }

    //写一个start0方法
    //这个方法是真正实现多线程的方法
    public void start0(){
        run(); //这个run方法就是本类里面的run方法
    }

    @Override
    public void run() {
        if (target != null){
            target.run(); //动态绑定（运行类型为Tiger，执行tiger.run() 输出：老虎嗷嗷叫...）
        }
    }
}