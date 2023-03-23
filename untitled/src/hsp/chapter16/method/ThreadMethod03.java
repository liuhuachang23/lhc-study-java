package hsp.chapter16.method;

import java.util.Map;

/*
 * 线程常用方法03
 * 用户线程和守护线程
 * 1） 用户线程：也叫工作线程，当线程的任务执行完成结束 或通知方式结束
 * 2） 守护线程：一般是为了给用户线程服务的，当所有的用户线程结束，守护线程自动结束
 * 3） 常见的守护线程：垃圾回收机制
 * */
public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        //我们希望当（用户线程）刘华昌学习完了，（子线程）吴小文停止吃东西
        //需要将子线程设为守护线程
        myDaemonThread.setDaemon(true);
        //开启子线程
        myDaemonThread.start();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("刘华昌在学习...");
        }
    }
}

class MyDaemonThread extends Thread {
    @Override
    public void run() {
        for (; ; ){ //无线循环
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("吴小文在吃东西...");
        }
    }
}