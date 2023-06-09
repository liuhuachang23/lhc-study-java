package hsp.chapter19.tankgame08;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/13 12:16
 * @Description: 子弹
 */
public class Bullet implements Runnable {
    private int x;
    private int y;
    private int d;
    private int spend = 2;
    private boolean isLive = true;

    public Bullet(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }

    public int getSpend() {
        return spend;
    }

    public void setSpend(int spend) {
        this.spend = spend;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    @Override
    public void run() {
        while (isLive) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (d) {
                case 0: //上
                    y -= spend;
                    break;
                case 1: //右
                    x += spend;
                    break;
                case 2: //下
                    y += spend;
                    break;
                case 3: //左
                    x -= spend;
                    break;
            }
            System.out.println("子弹 x=" + x + " y=" + y);
            //当子弹移动到面板边界时，自动销毁
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750)) {
                System.out.println("子弹线程退出...");
                isLive = false;
                break;
            }
        }
    }
}
