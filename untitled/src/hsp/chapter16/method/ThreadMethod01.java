package hsp.chapter16.method;
/*
* 线程常用方法01
* 1） setName 设置线程名称，使之与参数name相同
* 2） getName 返回该线程名称
* 3） start 使线程开始执行；java虚拟机底层调用该线程的 start0()
* 4） run 调用线程对象run方法
* 5） setPriority 更改线程的优先级
* 6） getPriority 获取线程的优先级
* 7） sleep 在指定的毫秒数内让当前正在执行的线程休眠
* 8） interrupt 中断线程
*
* 注意事项和细节
* 1） start 底层会创建新的线程，调用run，run就是一个简单的方法调用，不会启动新线程
* 2） 线程优先级的范围 MIN_PRIORITY(1)、NORM_PRIORITY(5)、NAX_PRIORITY(10)
* 3） interrupt 中断线程，但并没有真正的中断线程，一般用于中断正在休眠的线程（让其停止休眠，继续工作）
* 4） sleep 线程的静态方法，使当前线程休眠
* */
public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("吴小文"); //更改线程名称
        System.out.println(t.getName());//获取线程名称
        t.setPriority(Thread.MIN_PRIORITY); //更改线程优先级
        t.start(); //启动线程

        //主线程打印5个 hi，然后中断子线程休眠
        for (int i = 0; i <5 ; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + i);
        }
        System.out.println(t.getName() + "线程的优先级为 " + t.getPriority()); //1
        t.interrupt(); //当执行到这里，就会中断子线程的休眠

    }
}

class T extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                //Thread.currentThread().getName() 获取当前线程名称
                System.out.println(Thread.currentThread().getName() + "吃包子...." + i);
            }
            try {
                Thread.sleep(20000); //休眠20秒
            } catch (InterruptedException e) {
                //当该线程执行到一个 interrupt 方法时，就会catch一个异常，可以加入自己的业务代码
                //InterruptedException 是捕获到了一个中断异常
                System.out.println(Thread.currentThread().getName() + "被 interrupt 了");
            }
        }
    }
}