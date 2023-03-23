package hsp.chapter19.tankgame08;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/13 11:19
 * @Description:
 */
public class Tank {

    private int x;
    private int y;
    private int d;
    private int spend = 2;
    private boolean isLive = true;



    public Tank(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }

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
