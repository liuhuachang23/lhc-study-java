package hsp.chapter16.synchronized_;

public class DeadLock_ {
    public static void main(String[] args) {
        DeadLockDemo A = new DeadLockDemo(true);
        DeadLockDemo B = new DeadLockDemo(false);
        A.start();
        B.start();
    }
}

class DeadLockDemo extends Thread {
    static Object o1 = new Object(); //使用static修饰，保证多线程，共享一个对象
    static Object o2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {

        //下面业务逻辑分析
        //1. 如果flag 为 T，线程A就先得到/持有 o1 对象锁，线程A进入1
        //   尝试去获取o2 对象锁，得不到，就会Blocked
        //2. 如果flag 为 F，线程B就会得到/持有 o2 对象锁，线程B进入3
        //   尝试去获取o1 对象锁，得不到，就会Blocked

        if (flag){
            synchronized (o1) { //对象互斥锁，下面就是同步代码
                System.out.println(Thread.currentThread().getName() + "进入1");
                synchronized (o2){ //这里获得li对象的监视权
                    System.out.println(Thread.currentThread().getName() + "进入2");
                }
            }
        } else {
            synchronized (o2) { //对象互斥锁，下面就是同步代码
                System.out.println(Thread.currentThread().getName() + "进入3");
                synchronized (o1){ //这里获得li对象的监视权
                    System.out.println(Thread.currentThread().getName() + "进入4");
                }
            }
        }
    }
}