package hsp.chapter16.ticket;

//使用多线程,模拟三个窗口同时售票
//要求演示两种创建线程方式

//通过下面案例，发现程序会出现 超卖现象
public class SellTicket {
    public static void main(String[] args) {

        //使用继承Thread的方式
        /*SellTicket01 sellTicket01 = new SellTicket01();
        SellTicket01 sellTicket02 = new SellTicket01();
        SellTicket01 sellTicket03 = new SellTicket01();
        sellTicket01.start(); //启动售票
        sellTicket02.start(); //启动售票
        sellTicket03.start(); //启动售票*/

        //使用实现Runnable方式
        SellTicket01 sellTicket01 = new SellTicket01();
        new Thread(sellTicket01).start();
        new Thread(sellTicket01).start();
        new Thread(sellTicket01).start();


    }
}

//继承Thread
class SellTicket01 extends Thread{
    private static int ticketNum = 100;

    @Override
    public void run() {
        while (true){
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
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

//实现Runnable
class SellTicket02 implements Runnable{
    private int ticketNum = 100;

    @Override
    public void run() {
        while (true){
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
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