package hsp.chapter16.threaduse;

/*
 * 线程应用案例2-实现Runnable接口
 *
 * 1 说明：
 *   1） java是单继承的，在某些情况下一个类已经继承了某个父类，这时在用继承Thread类方法来创建线程显然不可能了
 *   2） java设计者们提供了另外一个方式创建线程，就是通过实现Runnable接口来创建线程
 *
 * 2 应用案例；
 *   请编写程序，该程序可以每隔一秒，在控制台输出 "hi！"，当输出10次后，自动退出，请使用现实Runnable接口的方式实现。
 *   这里是静态代理
 * */
public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();

        //dog.start() //这里不能调用start() , start() 是Thread里面的方法
        //创建Thread对象，吧Dog对象(实现了Runnable)，放入Thread
        //这里底层使用到了一个设计模式：代理模式
        Thread thread = new Thread(dog);
        thread.start();


    }
}

class Dog implements Runnable { //通过实现Runnable接口，开发线程
    int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("小狗汪汪叫..hi！" + (++count) + " 线程名= " + Thread.currentThread().getName());
            //休眠一秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 10) {
                break;
            }
        }
    }
}
