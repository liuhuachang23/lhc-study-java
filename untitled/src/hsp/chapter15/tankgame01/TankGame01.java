package hsp.chapter15.tankgame01;

import javax.swing.*;

public class TankGame01 extends JFrame{

    //定义画板属性
    private MyPanel mp = null;

    //构造器
    public TankGame01(){
        //创建画板
        mp = new MyPanel();
        //把画板放入画框
        this.add(mp);
        //设置画框大小
        this.setSize(1000,750);
        //可视化画框
        this.setVisible(true);
        //点击窗口的关闭按钮(×)会退出程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //main
    public static void main(String[] args) {
        new TankGame01();
    }
}
