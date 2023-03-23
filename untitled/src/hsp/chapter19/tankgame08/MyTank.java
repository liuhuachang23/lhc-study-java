package hsp.chapter19.tankgame08;

import java.util.Vector;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/13 11:19
 * @Description:
 */
public class MyTank extends Tank {

    public MyTank(int x, int y, int d) {
        super(x, y, d);
    }

    //添加子弹属性
    Vector<Bullet> bullets = new Vector<>();

    //添加开火方法
    public void shotEnemyTank() {
        //创建子弹对象
        if (bullets.size() == 5){
            return;
        }
        switch (getD()) {
            case 0: //上
                bullets.add(new Bullet(getX() + 20, getY(), 0));
                break;
            case 1: //右
                bullets.add(new Bullet(getX() + 60, getY() + 20, 1));
                break;
            case 2: //下
                bullets.add(new Bullet(getX() + 20, getY() + 60, 2));
                break;
            case 3: //左
                bullets.add(new Bullet(getX(), getY() + 20, 3));
                break;
        }
        //启动我们的子弹线程
        for (int i = 0; i < bullets.size(); i++) {
            if (bullets.get(i).isLive()) {
                new Thread(bullets.get(i)).start();
            }
        }
    }

}
