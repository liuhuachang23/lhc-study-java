package hsp.chapter17.tankgame05;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    /**
     * 敌人的坦克
     *
     * @param x 坦克(左上角)的x坐标
     * @param y 坦克(左上角)的y坐标
     */
    public EnemyTank(int x, int y) {
        super(x, y);
    }

    Vector<Bullet> bullets = new Vector<>();

    @Override
    public void run() {

        while (isLive()) {

            if (isLive() && bullets.size() < 1) {

                Bullet bullet = null;
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
                bullets.add(bullet);
                new Thread(bullet).start();
            }

            switch (getD()) {
                case 0:  //向上
                    //让坦克保持一个方向，走30步
                    for (int i = 0; i < 30; i++) {
                        if (getY() > 0) {
                            moveUp();
                        }
                        //休眠50毫秒
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:  //向右
                    for (int i = 0; i < 30; i++) {
                        if (getX() + 60 < 1000) {
                            moveRight();
                        }
                        //休眠50毫秒
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:  //向下
                    for (int i = 0; i < 30; i++) {
                        if (getY() + 60 < 750) {
                            moveDown();
                        }
                        //休眠50毫秒
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:  //向左
                    for (int i = 0; i < 30; i++) {
                        if (getX() > 0) {
                            moveLeft();
                        }
                        //休眠50毫秒
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;

            }
            setD((int) (Math.random() * 4));
        }
    }

}
