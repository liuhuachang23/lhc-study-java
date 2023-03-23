package hsp.chapter15.tankgame02;

import javax.swing.*;
/*
新增功能
* 1.我方坦克,可以控制键盘W D S A (上右下左) 来控制坦克移动
*
* 2.绘制出三个敌人坦克
* */
public class TankGame02 extends JFrame{

    //定义画板属性
    private MyPanel mp = null;

    //构造器
    public TankGame02(){
        //创建画板
        mp = new MyPanel();
        //把画板放入画框
        this.add(mp);
        //设置画框大小
        this.setSize(1000,750);
        //窗口(画框)JFrame 对象可以监听键盘事件, 即可以监听到mp（面板）上发生的键盘事件
        this.addKeyListener(mp);

        //可视化画框
        this.setVisible(true);
        //点击窗口的关闭按钮(×)会退出程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //main
    public static void main(String[] args) {
        new TankGame02();
    }

}
