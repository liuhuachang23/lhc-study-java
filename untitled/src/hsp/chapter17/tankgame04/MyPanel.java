package hsp.chapter17.tankgame04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TreeSet;
import java.util.Vector;

@SuppressWarnings({"all"})
//坦克大战的 画板
//为了让MyPanel重绘，将他设置为线程
public class MyPanel extends JPanel implements KeyListener, Runnable {
    //定义我的坦克
    private MyTank myTank = null;
    //定义敌人的坦克
    //敌人的坦克比较多所以放入到Vector(支持多线程)集合中
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //敌人坦克数量
    int enemyTankSize = 3;

    //定义一个Vector, 用于存放我们的炸弹
    //当坦克被击中时,就创建一个炸弹,加入到集合中
    Vector<Bomb> bombs = new Vector<>();
    //定义3张炸弹图片用于显示炸弹效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;


    //构造器
    //初始化坦克
    public MyPanel() {

        //创建自己坦克
        myTank = new MyTank(100, 100);
        myTank.setSpend(3); //设置速度

        for (int i = 0; i < enemyTankSize; i++) {
            //创建敌人坦克
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0); //创建敌人坦克
            enemyTanks.add(enemyTank); //加入到集合
            enemyTank.setD(2); //坦克方向
            //启动敌人坦克的随机移动
            new Thread(enemyTank).start();
            //给敌人坦克加子弹
            Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getD());//创建子弹
            enemyTank.bullets.add(bullet); //加入到集合
            //启动
            new Thread(bullet).start();
        }

        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/Bomb1.GIF"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/Bomb2.GIF"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/Bomb3.GIF"));

    }

    //实现JPanel的一个绘图方法
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //填充画板颜色
        g.fillRect(0, 0, 1000, 750);

        //画出我方坦克
        drawTank(myTank.getX(), myTank.getY(), g, myTank.getD(), 0);

        //画子弹 这里要考虑只有子弹存活时才能去画
        if (!(myTank.bullet == null || myTank.bullet.isLive() == false)) {
            g.draw3DRect(myTank.bullet.getX(), myTank.bullet.getY(), 1, 1, false);
        }

        //如果bombs 集合中有对象(有坦克被击中),就画出炸弹
        for (int i = 0; i < bombs.size(); i++) {
            //取出炸弹
            Bomb bomb = bombs.get(i);
            //根据当前炸弹的life值去画出对应的图片
            //这里让炸弹休眠一会,避免第一次爆炸不会显示爆炸效果
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            //每画完一次, 炸弹生命值减少1
            bomb.lifeDown();
            if (bomb.life == 0) { //bomb生命值为零了,爆炸完了,就从集合中删除
                bombs.remove(bomb);
            }
        }

        //画出敌人坦克,及其发射的子弹
        for (int i = 0; i < enemyTanks.size(); i++) {

            EnemyTank enemyTank = enemyTanks.get(i); //从集合中取出创建的坦克
            enemyTank.getD(); //坦克方向
            if (enemyTank.isLive() == false) { //坦克被击中了,就删除
                enemyTanks.remove(enemyTank);
            } else { //画出存活的坦克
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getD(), 1);
            }

            //画出敌人坦克的所有子弹
            for (int j = 0; j < enemyTank.bullets.size(); j++) {
                //取出子弹
                Bullet bullet = enemyTank.bullets.get(j);
                //这里要考虑只有子弹存活时才能去画
                if (bullet.isLive()) {
                    g.draw3DRect(bullet.getX(), bullet.getY(), 1, 1, false);
                } else {
                    enemyTank.bullets.remove(bullet);
                }
            }
        }

    }


    /**
     * 编写方法，画出坦克
     *
     * @param x         坦克的左上角x坐标
     * @param y         坦克的左上角y坐标
     * @param g         画笔
     * @param direction 坦克方向(上右下左)
     * @param type      坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type) {

        //坦克类型(敌我)
        switch (type) {
            case 0: //我们的坦克
                g.setColor(Color.cyan);
                break;
            case 1: //敌人的坦克
                g.setColor(Color.pink);
                break;
        }

        //根据坦克方向,来绘制坦克
        switch (direction) {
            case 0: //0表示向上
                g.fill3DRect(x, y, 10, 60, false); //画出坦克左边矩形轮子
                g.fill3DRect(x + 30, y, 10, 60, false); //右边矩形轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false); //坦克身体
                g.fillOval(x + 10, y + 20, 20, 20); //坦克盖子
                g.drawLine(x + 20, y, x + 20, y + 20); //坦克炮筒
                break;
            case 3: //向左
                g.fill3DRect(x, y, 60, 10, false); //画出坦克上边矩形轮子
                g.fill3DRect(x, y + 30, 60, 10, false); //下边矩形轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false); //坦克身体
                g.fillOval(x + 20, y + 10, 20, 20); //坦克盖子
                g.drawLine(x + 30, y + 20, x, y + 20); //坦克炮筒
                break;
            case 2: //表示向下
                g.fill3DRect(x, y, 10, 60, false); //画出坦克左边矩形轮子
                g.fill3DRect(x + 30, y, 10, 60, false); //右边矩形轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false); //坦克身体
                g.fillOval(x + 10, y + 20, 20, 20); //坦克盖子
                g.drawLine(x + 20, y + 40, x + 20, y + 60); //坦克炮筒
                break;
            case 1: //向右
                g.fill3DRect(x, y, 60, 10, false); //画出坦克上边矩形轮子
                g.fill3DRect(x, y + 30, 60, 10, false); //下边矩形轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false); //坦克身体
                g.fillOval(x + 20, y + 10, 20, 20); //坦克盖子
                g.drawLine(x + 40, y + 20, x + 60, y + 20); //坦克炮筒
                break;
        }
    }

    //编写方法,判断我方子弹是否击中敌人坦克
    //考虑什么时候判断（执行这个方法）比较好？ run方法中
    public void hitTank(EnemyTank e, Bullet b) {
        //判断子弹击是否中坦克
        switch (e.getD()) {
            case 0:
                if (b.getX() > e.getX() && b.getX() < (e.getX() + 40) && b.getY() > e.getY() && b.getY() < (e.getY() + 60)) {
                    System.out.println("敌人坦克被摧毁");
                    e.setLive(false);
                    b.setLive(false);
                    //创建Bomb对象,加入到bombs
                    Bomb bomb = new Bomb(e.getX(), e.getY());
                    bombs.add(bomb);
                }
                break;
            case 1:
                if (b.getX() > e.getX() && b.getX() < (e.getX() + 60) && b.getY() > e.getY() && b.getY() < (e.getY() + 40)) {
                    System.out.println("敌人坦克被摧毁");
                    e.setLive(false);
                    b.setLive(false);
                    //创建Bomb对象,加入到bombs
                    Bomb bomb = new Bomb(e.getX(), e.getY());
                    bombs.add(bomb);
                }
                break;
            case 2:
                if (b.getX() > e.getX() && b.getX() < (e.getX() + 40) && b.getY() > e.getY() && b.getY() < (e.getY() + 60)) {
                    System.out.println("敌人坦克被摧毁");
                    e.setLive(false);
                    b.setLive(false);
                    //创建Bomb对象,加入到bombs
                    Bomb bomb = new Bomb(e.getX(), e.getY());
                    bombs.add(bomb);
                }
                break;
            case 3:
                if (b.getX() > e.getX() && b.getX() < (e.getX() + 60) && b.getY() > e.getY() && b.getY() < (e.getY() + 40)) {
                    System.out.println("敌人坦克被摧毁");
                    e.setLive(false);
                    b.setLive(false);
                    //创建Bomb对象,加入到bombs
                    Bomb bomb = new Bomb(e.getX(), e.getY());
                    bombs.add(bomb);
                }
                break;

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //某个键被按下, 该方法会触发
    //W D S A 分别坦克代表 上 右 下 左
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println((char)e.getKeyCode() + "被按下...");
        //根据用户按下的不同键,来处理小球的移动(上下左右 键)
        //在java中会给 每一个键 分配 一个值(int)
        //KeyEvent.VK_W就是"W"键对应的code值

        if (e.getKeyCode() == KeyEvent.VK_W) { //向上走
            myTank.setD(0);
            if (myTank.getY() > 0) {
                myTank.moveUp();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) { //向右走
            myTank.setD(1);
            if ((myTank.getX() + 60) < 1000) {
                myTank.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) { //向下走
            myTank.setD(2);
            if ((myTank.getY() + 60) < 750) {
                myTank.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) { //向左
            myTank.setD(3);
            if (myTank.getX() > 0) {
                myTank.moveLeft();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_J) { //出炮
            myTank.shotEnemyTank();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //将判断敌人坦克是否中弹的方法反正这里
            //如果我方坦克已经 发射了子弹，且子弹还存活，就可以遍历所有的敌人坦克，调用方法进行判断
            if (myTank.bullet != null && myTank.bullet.isLive()) {
                for (int i = 0; i < enemyTanks.size(); i++) {
                    hitTank(enemyTanks.get(i), myTank.bullet);
                }
            }
            this.repaint();
        }
    }
}
