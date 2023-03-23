package hsp.chapter17.tankgame04;

import javax.swing.*;
/*
* 新增功能:
* 1.当我方坦克击中敌人坦克时,敌人的坦克,就消失,如果可以做出爆炸效果更好
* 2.让敌人坦克可以自由的随机移动
* 3.控制我方坦克和敌人坦克在规定的范围内移动
*
* */
public class TankGame04 extends JFrame{

    //定义画板属性
    private MyPanel mp = null;

    //构造器
    public TankGame04(){
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
        new TankGame04();
    }

}
