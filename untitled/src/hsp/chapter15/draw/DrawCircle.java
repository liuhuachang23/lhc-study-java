package hsp.chapter15.draw;

import javax.swing.*;
import java.awt.*;

/*
* 演示如何在面板上画圆
*   绘图原理
*   - Component类提供了两个和绘图相关最重要的方法
*   1) paint(Graphics g)
*   2) repaint() 刷新组件的外观
*
*   - 当组件第一次在屏幕显示的时候, 程序会自动调用paint()方法来绘制组件
*   - 以一下三种情况也会自动调用paint()
*   1) 窗口最小化, 在最大化
*   2) 窗口的大小发生变化
*   3) repaint方法被调用
*
* Graphic类
* Graphic类 可以理解成一只画笔,为我们提供了各种绘制图形的方法
*
* */

@SuppressWarnings({"all"})
//继承JFrame对应窗口, 可以理解为 一个画框, 下面定义的面板要放在这个画框里
public class DrawCircle extends JFrame{

    //定义一个面板属性
    private MyPanel mp= null;

    //构造器
    public DrawCircle(){
        //初始化面板(创建面板对象)
        mp = new MyPanel();
        //把面板放入到窗口(画框)
        this.add(mp);
        //设置画框大小
        this.setSize(1500, 900);
        //将窗口(画框)可视化
        this.setVisible(true);
        //点击窗口的关闭按钮(×)会退出程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //main方法
    public static void main(String[] args) {
        new DrawCircle();

    }

}

//先创建一个MyPanel类, 继承JPanel
//可以理解为 画板
class MyPanel extends JPanel {

    //说明:
    // MyPanel 对象就是一个画板
    // Graphics g 吧g理解成一只画笔
    // Graphics 提供了很多绘图的方法

    //实现JPanel的一个绘图方法
    @Override
    public void paint(Graphics g) {
        super.paint(g); //调用父类的有参构造器完成初始化

        //调用绘制圆形方法,画出圆形
        //g.drawOval(10, 10, 100, 100);

        //测试一下这个方法被调用的情况
        //System.out.println("paint方法被调用~");

        //另外一些常见图形的绘制方法
        //画 直线
        //g.drawLine(10,10,100,100);
        //画 矩形
        //g.drawRect(10,10,100,100);
        //画 填充矩形
        //g.setColor(Color.cyan); //设置画笔颜色
        //g.fillRect(10,10,100,100);
        //画 填充椭圆
        //g.setColor(Color.YELLOW); //设置画笔颜色
        //g.fillOval(10,10,100,100);
        //画 图片
        //1. 获取图片资源, /james.jpeg 表示在该项目的根目录去获取 james.jpeg 这个图片
        //2.在调用绘制图片方法
        //Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/james.jpeg"));
        //g.drawImage(image, 10,10,1421,799,this);
        //画 字符
        //g.setColor(Color.RED); //设置画笔颜色
        //g.setFont(new Font("隶书", Font.BOLD, 50)); //设置字体
        //g.drawString("北京你好",100,100); //这里的100,100 是字体的左下角
        //画
    }
}


