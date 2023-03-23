package hsp.chapter19.tankgame07;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/7 15:44
 * @Description: 一个 Node 对象,表示一个敌人坦克信息
 */
public class Node {
    private int x;
    private int y;
    private int d;

    public Node(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
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
