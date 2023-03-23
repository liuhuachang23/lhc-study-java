package hsp.chapter19.tankgame08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Vector;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/13 11:18
 * @Description:
 */

//画板
@SuppressWarnings({"all"})
public class MyPanel extends JPanel implements KeyListener, Runnable {

    //定义我的坦克
    private MyTank myTank = null;

    //定义敌人的坦克
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //敌人坦克的数量
    private int enemyTankSize = 3;

    //定义一个存放Node 对象的Vector ,用于恢复敌人坦克的坐标和方向
    Vector<Node> nodes = new Vector<>();

    //定义一个Vector, 用于存放我们的炸弹
    //当坦克被击中时,就创建一个炸弹,加入到集合中
    Vector<Bomb> bombs = new Vector<>();
    //定义3张炸弹图片用于显示炸弹效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    //构造器
    public MyPanel(String key) {
        //初始化我方坦克
        myTank = new MyTank(100, 500, 0);
        //首先要做一个判断,判断getRecordFile路径的文件是否存在(避免文件不存在,导致无法正常继续游戏)
        File file = new File(Recorder.getRecordFile());
        if (file.exists()) {
            //将Recorder中getNodesAndEnemyTankRec() 的返回值，赋给MyPanel的属性 集合nodes
            nodes = Recorder.getNodesAndEnemyTankRec();
        } else {
            System.out.println("记录上局游戏的文件丢失,将为您开启新的游戏");
            key = "1";
        }

        switch (key) {
            case "1": //开始新游戏
                //战绩清0
                Recorder.setAllEnemyTankNum(0);
                //初始化敌方坦克
                for (int i = 0; i < enemyTankSize; i++) {
                    //创建敌人坦克
                    EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0, 2);
                    //将创建的敌人坦克加入集合中
                    enemyTanks.add(enemyTank);
                    //开启敌人坦克线程
                    new Thread(enemyTank).start();
                    //给该enemyTank 加入一颗子弹
                    Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getD());
                    //加入enemyTank的Vector 成员
                    enemyTank.bullets.add(bullet);
                    //启动 子弹 线程
                    new Thread(bullet).start();
                    //调用EnemyTank类的setEnemyTanks()，将敌人坦克传入，解决敌人坦克重叠问题
                    enemyTank.setEnemyTanks(enemyTanks);
                }
                break;
            case "2":
                for (int i = 0; i < nodes.size(); i++) {
                    Node node = nodes.get(i);
                    //创建敌人坦克
                    EnemyTank enemyTank = new EnemyTank(node.getX(), node.getY(), node.getD());
                    //将创建的敌人坦克加入集合中
                    enemyTanks.add(enemyTank);
                    //开启敌人坦克线程
                    new Thread(enemyTank).start();
                    //给该enemyTank 加入一颗子弹
                    Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getD());
                    //加入enemyTank的Vector 成员
                    enemyTank.bullets.add(bullet);
                    //启动 子弹 线程
                    new Thread(bullet).start();
                    //调用EnemyTank类的setEnemyTanks()，将敌人坦克传入，解决敌人坦克重叠问题
                    enemyTank.setEnemyTanks(enemyTanks);
                }
                break;
            default:
                System.out.println("输入有误...");
        }

        //调用Recorder类的setEnemyTanks()，将敌人坦克传入，解决敌人坦克信息存储问题
        Recorder.setEnemyTanks(enemyTanks);

        //定义一个Vector, 用于存放我们的炸弹
        //当坦克被击中时,就创建一个炸弹,加入到集合中
        Vector<Bomb> bombs = new Vector<>();
        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/Bomb1.GIF"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/Bomb2.GIF"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/Bomb3.GIF"));

        //画完后,播放坦克大战的背景音乐
        new AePlayWave("src\\hsp\\chapter19\\tankgame08\\111.wav").start();

    }

    //显示我方坦克击毁敌方坦克的成绩栏
    public void showInfo(Graphics g) {
        g.setColor(Color.black);
        Font font = new Font("宋体", Font.BOLD, 25);
        g.setFont(font);
        g.drawString("累计击毁敌方坦克", 1020, 30);
        drawTank(1020, 60, 0, g, 1);
        g.setColor(Color.black);
        g.drawString(Recorder.getAllEnemyTankNum() + "", 1080, 100);
    }

    //画坦克
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //填充画板颜色
        g.fillRect(0, 0, 1000, 750);

        //画出成绩栏
        showInfo(g);

        //调用编制坦克方法，画出我方坦克
        if (myTank.isLive()) {
            drawTank(myTank.getX(), myTank.getY(), myTank.getD(), g, 0);
        }
        //画出我方坦克发射的子弹
        for (int i = 0; i < myTank.bullets.size(); i++) {
            Bullet bullet = myTank.bullets.get(i);
            if (!(bullet == null || bullet.isLive() == false)) {
                System.out.println("子弹被绘制...");
                g.draw3DRect(bullet.getX(), bullet.getY(), 1, 1, false);
            } else {
                myTank.bullets.remove(bullet);
            }
        }

        //调用编制坦克方法，画出敌人坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank et = enemyTanks.get(i);
            if (et.isLive()) {
                drawTank(et.getX(), et.getY(), et.getD(), g, 1);
            } else {
                enemyTanks.remove(et);
            }
            //画出敌人坦克发射的子弹
            for (int j = 0; j < et.bullets.size(); j++) {
                Bullet bullet = et.bullets.get(j);
                if (bullet.isLive()) {
                    g.draw3DRect(bullet.getX(), bullet.getY(), 1, 1, false);
                } else {
                    et.bullets.remove(bullet);
                }
            }
        }

        //如果bombs 集合中有对象(有坦克被击中),就画出炸弹
        for (int i = 0; i < bombs.size(); i++) {
            //取出炸弹
            Bomb bomb = bombs.get(i);
            //根据当前炸弹的life值去画出对应的图片

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
    }


    /**
     * 编制坦克方法
     *
     * @param x    坦克的左上角x坐标
     * @param y    坦克的左上角y坐标
     * @param d    坦克方向(上下左右)
     * @param g    画笔
     * @param type 坦克类型
     */
    public void drawTank(int x, int y, int d, Graphics g, int type) {

        //坦克类型(敌我)
        switch (type) {
            case 0: //我们的坦克
                g.setColor(Color.pink);
                break;
            case 1: //敌人的坦克
                g.setColor(Color.YELLOW);
                break;
        }

        //根据坦克方向,来绘制坦克
        switch (d) {
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


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
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
    }

    //击中敌方坦克
    public void hitEnemyTank() {
        for (int i = 0; i < myTank.bullets.size(); i++) {
            Bullet bullet = myTank.bullets.get(i);
            if (bullet != null && bullet.isLive()) {
                for (int j = 0; j < enemyTanks.size(); j++) {
                    hit(enemyTanks.get(j), bullet);
                }
            }
        }
    }

    //击中我方坦克
    public void hitMyTank() {
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j < enemyTank.bullets.size(); j++) {
                if (enemyTank.bullets.get(j).isLive() && enemyTank.bullets.get(j) != null && myTank.isLive()) {
                    hit(myTank, enemyTank.bullets.get(j));
                }
            }
        }
    }

    //编写一个坦克中弹方法
    public void hit(Tank t, Bullet b) {
        //判断子弹击是否中坦克
        switch (t.getD()) {
            case 0:
                if (b.getX() > t.getX() && b.getX() < (t.getX() + 40) && b.getY() > t.getY() && b.getY() < (t.getY() + 60)) {
                    System.out.println("坦克被摧毁");
                    t.setLive(false);
                    b.setLive(false);
                    //如果击中的是敌人坦克,则战绩加一
                    if (t instanceof EnemyTank) {
                        Recorder.addAllEnemyTankNum();
                    }
                    //创建Bomb对象,加入到bombs
                    Bomb bomb = new Bomb(t.getX(), t.getY());
                    bombs.add(bomb);
                }
                break;
            case 1:
                if (b.getX() > t.getX() && b.getX() < (t.getX() + 60) && b.getY() > t.getY() && b.getY() < (t.getY() + 40)) {
                    System.out.println("坦克被摧毁");
                    t.setLive(false);
                    b.setLive(false);
                    //如果击中的是敌人坦克,则战绩加一
                    if (t instanceof EnemyTank) {
                        Recorder.addAllEnemyTankNum();
                    }
                    //创建Bomb对象,加入到bombs
                    Bomb bomb = new Bomb(t.getX(), t.getY());
                    bombs.add(bomb);
                }
                break;
            case 2:
                if (b.getX() > t.getX() && b.getX() < (t.getX() + 40) && b.getY() > t.getY() && b.getY() < (t.getY() + 60)) {
                    System.out.println("坦克被摧毁");
                    t.setLive(false);
                    b.setLive(false);
                    //如果击中的是敌人坦克,则战绩加一
                    if (t instanceof EnemyTank) {
                        Recorder.addAllEnemyTankNum();
                    }
                    //创建Bomb对象,加入到bombs
                    Bomb bomb = new Bomb(t.getX(), t.getY());
                    bombs.add(bomb);
                }
                break;
            case 3:
                if (b.getX() > t.getX() && b.getX() < (t.getX() + 60) && b.getY() > t.getY() && b.getY() < (t.getY() + 40)) {
                    System.out.println("坦克被摧毁");
                    t.setLive(false);
                    b.setLive(false);
                    //如果击中的是敌人坦克,则战绩加一
                    if (t instanceof EnemyTank) {
                        Recorder.addAllEnemyTankNum();
                    }
                    //创建Bomb对象,加入到bombs
                    Bomb bomb = new Bomb(t.getX(), t.getY());
                    bombs.add(bomb);
                }
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //射击敌人坦克
            hitEnemyTank();
            //我方坦克被攻击
            hitMyTank();
            //刷新画板
            this.repaint();
        }

    }
}