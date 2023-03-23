package hsp.chapter16.homework;

import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        new Thread(a).start();
        new Thread(b).start();

    }
}

class A implements Runnable {
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            System.out.println((int)(Math.random() * 100 + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("A线程退出...");
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class B implements Runnable{

    private A a;
    private Scanner scanner = new Scanner(System.in);

    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("请输入您的指令（Q）B表示退出：");
            char c = scanner.next().charAt(0);
            if (c == 'Q') {
                a.setLoop(false);
                System.out.println("B线程退出...");
                break;
            }

        }
    }
}