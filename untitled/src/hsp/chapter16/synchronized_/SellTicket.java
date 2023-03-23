package hsp.chapter16.synchronized_;


//解决售票超卖现象
public class SellTicket {
    public static void main(String[] args) {
        SellTicket03 sellTicket03 = new SellTicket03();
        //多线程共享一个对象，对象锁只能有一个
        new Thread(sellTicket03).start();
        new Thread(sellTicket03).start();
        new Thread(sellTicket03).start();
    }
}

//实现Runnable接口，使用synchronized实现线程同步
class SellTicket03 implements Runnable {
    private int ticketNum = 100;
    private boolean loop = true;
    Object object = new Object(); //三个线程操作同一个对象, 下面的this可以改为object


    @Override
    public void run() {
        while (loop) {
            sell();  //同步方法
        }
    }

    /*1.同步方法(静态的)的锁为当前 类
        实现同步的方式
        1)静态方法上加锁
        public synchronized static void m1() {} 锁是加在 SellTicket03.class 上的
        2)静态方法的代码块上加锁
        synchronized (SellTicket03.class){} 锁还是加在 SellTicket03.class 上的*/
    public synchronized static void m1() { //在静态方法上加锁
    }
    public static void m2(){
        synchronized (SellTicket03.class){ //在静态方法里的 代码块上加锁

        }
    }

    /*2.同步方法(非静态的) 的锁为当前 对象
        实现同步的方式
        1) 方法上加锁 同步方法，
        public synchronized void sell() {}  互斥锁在 this对象
        2) 也可以在代码块上加锁 , 同步代码块，
        synchronized (this) {} 互斥锁还是在 this对象*/
    public /*synchronized*/ void sell() { //同步方法, 同一时刻，只能有一个线程来执行m方法

        synchronized (/*this*/object) {  //同步代码块
            //先判断，有没有，再开始售票
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                loop = false;
                return;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票" +
                    "剩余票数: " + (--ticketNum));
        }

    }
}