package hsp.chapter16.state_;
/*
  线程的生命周期
  JDK中用Thread.State枚举表示了线程的几种状态
    1） NEW (创建状态) 尚未启动的线程 处于此状态
    2） RUNNABLE (可运行状态) 在java虚拟机中执行的线程 处于此状态（还可分为 Ready、Running 2种状态）
    3） BLOCKED (封锁状态) 被阻塞等待监视器锁定的线程 处于此状态
    4） WAITING (等待状态) 正在等待另一个线程执行特定动作的线程 处于此状态
    5） TIMED_WAITING (超时等待状态) 正在等待另一个线程执行动作到达指定等待时间的线程 处于此状态
    6） TERMINATED (终止状态) 已退出的线程 处于此状态
*/
//打印一个简单线程的 生命周期状态变化
public class ThreadState_ {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        //输出线程开启前的状态
        System.out.println(t.getName() + " 状态" + t.getState());
        t.start();
        //每隔1s输出一次,线程实时的状态
        while (Thread.State.TERMINATED != t.getState()){ //当线程状态不是 已退出的状态
            Thread.sleep(1000);
            System.out.println(t.getName() + " 状态" + t.getState());
        }
        //输出线程结束后的状态
        System.out.println(t.getName() + " 状态" + t.getState());

    }
}

class T extends Thread {

    @Override
    public void run() {
        while (true){
            for (int i = 0; i < 10; i++) {
                System.out.println( "hi " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
           break;
        }
    }
}
