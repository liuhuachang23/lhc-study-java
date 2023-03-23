package hsp.chapter19.tankgame06;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/*
 * 新增功能:
 * 1.防止敌人坦克重叠
 * 2.记录玩家的成绩,存盘退出
 * 3.记录当时敌人坦克坐标,存盘退出
 * 4.玩游戏时,可以选择开始新游戏还是继续上局游戏
 *
 * */
public class TankGame06 extends JFrame {

    //定义画板属性
    private MyPanel mp = null;

    //构造器
    public TankGame06() {

        //选择新游戏,还是继续上一局
        System.out.println("请输入选择（1：新游戏 2：继续游戏）：");
        Scanner scanner = new Scanner(System.in);
        String key = scanner.next();

        //创建画板
        mp = new MyPanel(key);
        new Thread(mp).start();
        //把画板放入画框
        this.add(mp);
        //设置画框大小
        this.setSize(1400, 795);
        //窗口(画框)JFrame 对象可以监听键盘事件, 即可以监听到mp（面板）上发生的键盘事件
        this.addKeyListener(mp);

        //可视化画框
        this.setVisible(true);
        //点击窗口的关闭按钮(×)会退出程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //在JFrame 中增加相应关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("监听到了");
                Recorder.keepRecord();
                System.exit(0);
            }
        });
    }

    //main
    public static void main(String[] args) {

        new TankGame06();
    }

}
