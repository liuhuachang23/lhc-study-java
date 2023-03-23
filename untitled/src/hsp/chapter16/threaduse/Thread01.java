package hsp.chapter16.threaduse;

/*
 * 线程应用案例1-继承Thread类
 *
 * 1）请编写程序，开启一个线程，该线程每隔1秒，在控制台上输出 "喵喵，我是小喵咪"
 * 2）对上题改进，当输出80次 "喵喵，我是小喵咪"，结束该线程
 * 3）使用JConsole监控线程执行情况，并画出程序示意图
 *
 * */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        //创建Cat对象（可以将它当成一个线程使用）
        Cat cat = new Cat();

        //启动线程
        /*
         分析：我们为什么不能直接调用run方法，来达到题目要求
          1. 程序运行（进程）
          2. 开启主线程main()
          3. cat.start():开启第二个线程 Thread-0
          3. 当main线程启动一个子线程 Thread-0，主线程不会阻塞，会继续执行
          4. 使用JConsole监控线程执行情况他，来验证上述分析

          5. run()就是一个普通的方法，调用它的话，程序必须要等到run()执行完了之后，才会向下执行（线程阻塞）
             相当于是我们的主线程直接调用run()，并没有真正的开新的线程，是串行化，而不是多线程

        */
        //cat.run();
        cat.start(); //启动线程-> 最终会执行cat.run()
        /*
          我们来分析一下start()的源码：
          (1) 执行 start()： （下面代码简化了，保留了关键部分）
              public synchronized void start() {
                    start0()
              }
          (2) 进入 start0()
              //这是一个本地方法，是JVM调用，底层是c/c++实现
              //真正实现多线程的效果，是start0()，而不是run()
              private native void start0();

          (3) start() 调用start0() 后，该线程并不会立马执行，只是将线程变成了可运行状态，
                具体什么时候执行，取决于CPU，由CPU统一调度
        */

        System.out.println("主线程继续执行");
        for (int i = 0; i < 60; i++) {
            System.out.println("主线程 i= " + i + " 主线程名= " + Thread.currentThread().getName());//主线程名字：main
            //让主线程也休眠（隔一秒输出一次），这里不捕获异常了，直接抛出
            Thread.sleep(1000);
        }
    }
}

//1. 当一个类 继承了 Thread类，该类就可以当做线程使用
//2. 我们会重写 run方法，写上自己的业务代码
//3. run Thread类 实现了 Runnable接口的run方法
class Cat extends Thread {
    int times;

    @Override
    public void run() {

        while (true) {
            //该线程每隔1秒，在控制台上输出 "喵喵，我是小喵咪"
            System.out.println("喵喵，我是小喵咪" + (++times) + " 线程名= " + Thread.currentThread().getName()); //Thread-0
            //输出一个后让它休眠一秒(1000ms == 1 s)
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //当输出80次，就退出循环（退出线程）
            if (times == 80) {
                break;
            }
        }
    }
}