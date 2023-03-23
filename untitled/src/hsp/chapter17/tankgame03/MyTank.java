package hsp.chapter17.tankgame03;

public class MyTank extends Tank {

    /**
     * 我的坦克
     *
     * @param x 坦克(左上角)的x坐标
     * @param y 坦克(左上角)的y坐标
     */
    public MyTank(int x, int y) {
        super(x, y);
    }

    //定义一个Bullet对象
    Bullet bullet = null;

    //开火方法
    public void shotEnemyTank() {
        //创建子弹对象
        switch (getD()) {
            case 0: //上
                bullet = new Bullet(getX() + 20, getY(), 0);
                break;
            case 1: //右
                bullet = new Bullet(getX() + 60, getY() + 20, 1);
                break;
            case 2: //下
                bullet = new Bullet(getX() + 20, getY() + 60, 2);
                break;
            case 3: //左
                bullet = new Bullet(getX(), getY() + 20, 3);
                break;
        }
        new Thread(bullet).start();
    }
}
