package hsp.chapter15.tankgame01;

import javax.swing.*;
import java.awt.*;

//坦克大战的 画板
public class MyPanel extends JPanel {
    //定义我的坦克
    private MyTank myTank = null;

    //构造器
    //初始化坦克
    public MyPanel() {
        myTank = new MyTank(100,100);
    }

    //实现JPanel的一个绘图方法
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //填充画板颜色
        g.fillRect(0,0,1000,750);

        //画出坦克
        drawTank(myTank.getX(), myTank.getY(), g, 0,0);
        drawTank(myTank.getX()+60, myTank.getY(), g, 0,1);


    }

    //编写方法，画出坦克

    /**
     *
     * @param x 坦克的左上角x坐标
     * @param y 坦克的左上角y坐标
     * @param g 画笔
     * @param direction 坦克方向(上下左右)
     * @param type 坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type){

        //坦克类型(敌我)
        switch (type){
            case 0: //我们的坦克
            g.setColor(Color.pink);
            break;
            case 1: //敌人的坦克
            g.setColor(Color.YELLOW);
            break;
        }

        //根据坦克方向,来绘制坦克
        switch (direction){
            case 0: //0表示向上
                g.fill3DRect(x, y, 10,60, false); //画出坦克左边矩形轮子
                g.fill3DRect(x+30, y,10, 60, false); //右边矩形轮子
                g.fill3DRect(x+10, y+10, 20, 40, false); //坦克身体
                g.fillOval(x+10, y+20,20,20); //坦克盖子
                g.drawLine(x+20, y, x+20, y+20); //坦克炮筒
                break;
        }
    }
}
