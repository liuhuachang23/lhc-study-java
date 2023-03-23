package hsp.chapter19.tankgame07;

import hsp.chapter18.decorator_design_patterns.Reader_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
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

    //定义一个存放Node 对象的Vector ,用于恢复敌人坦克的坐标和方向
    Vector<Node> nodes = new Vector<>();

    //定义一个Vector, 用于存放我们的炸弹
    //当坦克被击中时,就创建一个炸弹,加入到集合中
    Vector<Bomb> bombs = new Vector<>();
    //定义3张炸弹图片用于显示炸弹效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    //初始化坦克(构造器)
    //写一个参数key传入,用于判断,玩家选择了开始新游戏,还是继续上局游戏
    public MyPanel(String key) {
        //将Recorder中getNodesAndEnemyTankRec() 的返回值，赋给MyPanel的属性 集合nodes
        //首先要做一个判断,判断getRecordFile路径的文件是否存在(避免文件不存在,导致无法正常继续游戏)
        File file = new File(Recorder.getRecordFile());
        if (file.exists()) { //文件存在,可以继续上一局游戏
            nodes = Recorder.getNodesAndEnemyTankRec();
        } else { //文件不存在,只能开始新游戏
            System.out.println("记录上局游戏的文件丢失,将为您开启新的游戏");
            key = "1";
        }
        //将MyPanel对象的 enemyTanks 设置给 Recorder 的 enemyTanks
        Recorder.setEnemyTanks(enemyTanks);

        //创建自己坦克
        myTank = new MyTank(100, 500);
        myTank.setSpend(3); //设置速度

        switch (key) {
            case "1": //开始新游戏
                //将击毁敌方坦克数清零
                Recorder.setAllEnemyTankNum(0);
                //创建敌人坦克
                for (int i = 0; i < enemyTankSize; i++) {
                    EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0); //创建敌人坦克
                    enemyTanks.add(enemyTank); //加入到集合
                    //调用EnemyTank 的setEnemyTanks()，将enemyTanks设置给EnemyTank
                    enemyTank.setEnemyTanks(enemyTanks);
                    enemyTank.setD(2); //初始化坦克方向
                    //启动敌人坦克的随机移动
                    new Thread(enemyTank).start();
                    //给敌人坦克加子弹
                    Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getD());//创建子弹
                    enemyTank.bullets.add(bullet); //加入到集合
                    //启动
                    new Thread(bullet).start();
                }
                break;
            case "2": // 继续新游戏
                for (int i = 0; i < nodes.size(); i++) {
                    Node node = nodes.get(i);
                    EnemyTank enemyTank = new EnemyTank(node.getX(), node.getY()); //创建敌人坦克
                    enemyTanks.add(enemyTank); //加入到集合
                    //调用EnemyTank 的setEnemyTanks()，将enemyTanks设置给EnemyTank
                    enemyTank.setEnemyTanks(enemyTanks);
                    enemyTank.setD(node.getD()); //初始化坦克方向
                    //启动敌人坦克的随机移动
                    new Thread(enemyTank).start();
                    //给敌人坦克加子弹
                    Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getD());//创建子弹
                    enemyTank.bullets.add(bullet); //加入到集合
                    //启动
                    new Thread(bullet).start();
                }
                break;
            default:
                System.out.println("您的输入有误...");
        }

        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/Bomb1.GIF"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/Bomb2.GIF"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/Bomb3.GIF"));

        //画完后,播放坦克大战的背景音乐
        new AePlayWave("src\\hsp\\chapter19\\tankgame07\\111.wav").start();
    }

    //编写方法,显示我方坦克击毁敌方坦克的成绩栏
    public void showInfo(Graphics g) {
        g.setColor(Color.black);
        Font font = new Font("宋体", Font.BOLD, 25);
        g.setFont(font);
        g.drawString("累计击毁敌方坦克", 1020, 30);
        drawTank(1020, 60, g, 0, 1);
        g.setColor(Color.black);
        g.drawString(Recorder.getAllEnemyTankNum() + "", 1080, 100);


    }

    //实现JPanel的一个绘图方法
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //填充画板颜色
        g.fillRect(0, 0, 1000, 750);
        //调用显示成绩栏方法
        showInfo(g);

        //画出我方坦克
        if (myTank.isLive() && myTank != null) {
            drawTank(myTank.getX(), myTank.getY(), g, myTank.getD(), 0);
        }

        //画子弹 这里要考虑只有子弹存活时才能去画
        for (int i = 0; i < myTank.bullets.size(); i++) {
            Bullet bullet = myTank.bullets.get(i);
            if (bullet.isLive() && bullet != null) {
                g.draw3DRect(bullet.getX(), bullet.getY(), 1, 1, false);
            } else {
                myTank.bullets.remove(bullet);
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
        this.repaint();


        //画出敌人坦克,及其发射的子弹
        for (int i = 0; i < enemyTanks.size(); i++) {

            EnemyTank enemyTank = enemyTanks.get(i); //从集合中取出创建的坦克
            enemyTank.getD(); //坦克方向
            if (enemyTank.isLive()) { //画出存活的坦克
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getD(), 1);
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

    //我方坦克受到攻击
    public void hitMyTank() {
        //取出有敌方坦克和其子弹,调用 是否击中方法
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j < enemyTank.bullets.size(); j++) {
                Bullet bullet = enemyTank.bullets.get(j);
                if (bullet.isLive() && bullet != null && myTank.isLive()) {
                    hitTank(myTank, bullet);
                }
            }
        }
    }

    //射击敌人坦克
    public void hitEnemyTank() {
        //将判断敌人坦克是否中弹的方法
        //如果我方坦克已经 发射了子弹，且子弹还存活，就可以遍历所有的敌人坦克，调用方法进行判断
        if (myTank.bullet != null && myTank.bullet.isLive()) {
            //遍历敌人所有的坦克
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                hitTank(enemyTank, myTank.bullet);
            }
        }

    }

    //编写方法,判断子弹是否击中坦克
    //考虑什么时候判断（执行这个方法）比较好？ run方法中
    public void hitTank(Tank t, Bullet b) {
        //判断子弹击是否中坦克
        switch (t.getD()) {
            case 0:
                if (b.getX() > t.getX() && b.getX() < (t.getX() + 40) && b.getY() > t.getY() && b.getY() < (t.getY() + 60)) {
                    System.out.println("坦克被摧毁");
                    t.setLive(false);
                    b.setLive(false);
                    enemyTanks.remove(t);
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
                    enemyTanks.remove(t);
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
                    if (t instanceof EnemyTank) {
                        Recorder.addAllEnemyTankNum();
                    }
                    enemyTanks.remove(t);
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
                    enemyTanks.remove(t);
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
        int bd = 0;
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
            //射击敌人坦克
            hitEnemyTank();
            //我方坦克被攻击
            hitMyTank();
            //更新
            this.repaint();
        }
    }
}
