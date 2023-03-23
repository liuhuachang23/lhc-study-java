package hsp.chapter15.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * 演示小球通过键盘控制上下左右移动 -> 讲解Java的事件控制
 * */
@SuppressWarnings({"all"})
public class BallMove extends JFrame {
    private MyPanel mp = null;

    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        //窗口（画框）JFrame 对象可以监听键盘事件，即可以监听到mp（面板）上发生的键盘事件
        this.addKeyListener(mp);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    //main
    public static void main(String[] args) {
        new BallMove();
    }
}

//画板
//KeyListener 是一个监听器，可以监听键盘事件
class MyPanel extends JPanel implements KeyListener {

    //为了让小球可以移动,将小球位置坐标(左上角)设置为变量
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);

    }


    //有字符输出时，该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //当某个键被按下去，该方法会触发
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println((char)e.getKeyCode() + "被按下...");
        //根据用户按下的不同键,来处理小球的移动(上下左右 键)
        //在java中会给 每一个键 分配 一个值(int)
        if (e.getKeyCode() == KeyEvent.VK_DOWN) { //KeyEvent.VK_DOWN就是向下的箭头对应的code值
            y++; //改变球坐标
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }

        //让面板重绘
        this.repaint();
    }

    //当某个键松开了，该方法会触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}