package hsp.chapter16.homework;

public class Homework02 {
    public static void main(String[] args) {
        Bank bank = new Bank();
        new Thread(bank).start();
        new Thread(bank).start();
    }
}

class Bank implements Runnable {
    private boolean loop = true;
    private double balance = 10000;

    @Override
    public void run() {
        while (loop) {

            //1. 这里使用 synchronized 实现了线程同步
            //2. 当多个线程执行到这里，就会去争夺this对象锁
            //3. 那个线程争夺到了（获取）this对象锁，就执行 synchronized 代码块 ，执行完了，就会释放this对象锁，再次去争夺
            //4. 争夺不到的线程就阻塞在这里blocked，等this对象锁被释放时后再次争夺
            synchronized (this) {
                //先判断余额够不够，再取钱
                if (balance <= 0) {
                    System.out.println("账户余额不足...");
                    loop = false;
                    break;
                }
                System.out.println("用户：" + Thread.currentThread().getName() + " 成功取出1000元，还剩" + (balance -= 1000));
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
