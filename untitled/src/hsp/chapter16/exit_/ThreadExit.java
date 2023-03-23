package hsp.chapter16.exit_;

/*
 * 线程终止
 * 1) 当线程完成任务后,会自动终止
 * 2) 还可以通过使用变量来控制run方法退出的方式,来停止线程,即通知方式
 *
 * 需求: 启动一个线程t, 要求在main线程中去停止线程t
 * */
public class ThreadExit {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();

        //如果希望main线程去控制线程t的终止, 必须修改loop
        //让t 退出run方法, 终止线程t
        //让主线程休眠10秒，在通知t线程终止
        Thread.sleep(10000);
        t.setLoop(false);
    }
}

class T extends Thread {
    private int count = 0;
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T 运行中..." + (++count));
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
