package hsp.chapter16.threaduse;
/*
* 线程应用案例3-多线程执行
*
* */
public class Thread03 {
    public static void main(String[] args) { //主线程

        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start(); //启动第一个子线程
        thread2.start(); //启动第二个子线程
    }
}

class T1 implements Runnable {

    @Override
    public void run() {
        int count = 0;
        while (true) {
            System.out.println("hello world " + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 10){
                break;
            }
        }
    }
}

class T2 implements Runnable{

    @Override
    public void run() {
        int count = 0;
        while (true) {
            System.out.println("hi " + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 5){
                break;
            }
        }
    }
}