package hsp.chapter17.tankgame04;

public class Tank {
    private int x; //坦克(左上角)的横坐标
    private int y; //坦克(左上角)的纵坐标
    private int d; //坦克方向
    private int spend = 1; //坦克速度(默认为1)
    private boolean isLive = true;


    //坦克上下左右移动的方法
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

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public int getSpend() {
        return spend;
    }

    public void setSpend(int spend) {
        this.spend = spend;
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
}
