package hsp.chapter16.method;
/*
* 线程常用方法02
* 1） yield：线程的礼让。
*       让出CPU，让其它线程执行，但礼让的时间不确定，也不一定礼让成功（由CPU决定）
*
* 2） join：线程的插队。
*       插队的线程一旦插队成功，则会先执行完插入线程的所以任务
*
* 案例：创建一个子线程，每隔1s输出 "子线程吃包子"，输出20次，主线程每隔1s，输出 "主线程吃包子"，输出20次
* 要求：两个线程同时执行，当主线程输出5次后，就让子线程运行完毕，主线程在继续
*
* */
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        Thread.currentThread().setName("刘华昌");
        t2.setName("吴小文");
        for (int i = 1; i <21 ; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "(小弟)吃了 " + i + "个包子");
            if (i == 5){
                System.out.println("小弟让大哥先吃");
                t2.start();
                //Thread.yield(); //yield 线程礼让，不一定成功
                t2.join(); //join 线程插队：让t2线程先执行完毕，主线程在执行

            }
        }
    }
}

class T2 extends Thread{

    @Override
    public void run() {
        for (int i = 1; i <21 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println( Thread.currentThread().getName() +"(大哥)吃了 " + i + "个包子");
        }
    }
}