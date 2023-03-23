package hsp.chapter17.tankgame05;

import javax.swing.*;

/*
* 新增功能:
* 1.我方坦克在发射子弹后,才能发射新的子弹 --> 扩展(发射多颗子弹怎么办)
* 2.让敌人坦克发射的子弹消亡后,可以再发射子弹
* 3.让敌人的坦克击中我方坦克时,我方坦克消失,并出现爆炸效果
*
* */
public class TankGame05 extends JFrame{

    //定义画板属性
    private MyPanel mp = null;

    //构造器
    public TankGame05(){
        //创建画板
        mp = new MyPanel();
        new Thread(mp).start();
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
        new TankGame05();
    }

}
