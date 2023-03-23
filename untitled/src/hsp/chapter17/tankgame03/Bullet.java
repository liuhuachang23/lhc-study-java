package hsp.chapter17.tankgame03;

public class Bullet implements Runnable {
    private int x; //子弹(左上角)的横坐标
    private int y; //子弹(左上角)的纵坐标
    private int d; //坦克的方向
    private int spend = 2; //子弹速度(默认为1)
    private boolean isLive = true;

    public Bullet(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }


    @Override
    public void run() { //射击
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
            if (!(x >=0 && x <= 1000 && y >= 0 && y <= 750)){
                System.out.println("子弹线程退出...");
                isLive = false;
                break;
            }
        }
    }


    /*//子弹移动的方法
    public void moveUp(){
        y -= spend;
    }
    public void moveRight(){
        x += spend;
    }
    public void moveDown(){
        y += spend;
    }
    public void moveLeft(){
        x -= spend;
    }

    public Bullet(int d) {
        this.d = d;
    }

    public int getSpend() {
        return spend;
    }*/

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
}
