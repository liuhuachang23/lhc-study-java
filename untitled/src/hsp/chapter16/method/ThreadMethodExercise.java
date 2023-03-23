package hsp.chapter16.method;
/*
* 设计一个程序：主线程执行5次后，开启子线程，并让子线程执行完毕后，再继续执行主线程，直到主线程执行完毕，程序结束
*
* */
public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        T3 t3 = new T3();
        Thread thread = new Thread(t3);

        for (int i = 1; i <= 10; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + i);
            if (i == 5){
                thread.start(); //开启子线程
                thread.join(); //线程的插队，让子线程执行完毕后，在执行主线程
                System.out.println("子线程结束..");
            }
        }
        System.out.println("主线程结束..");
    }
}

class T3 implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello " + i);
        }

    }
}