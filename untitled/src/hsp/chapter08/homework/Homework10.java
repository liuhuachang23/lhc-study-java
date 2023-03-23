package hsp.chapter08.homework;

import java.util.Random;
import java.util.Scanner;

//扩展题
/*
    有个人Tom设计他的成员变量,成员变量可以电脑猜拳,电脑每次都会随机生成0,1,2
    0表示石头 1表示剪刀 2表示布
    要显示Tom的输赢次数(清单)
*/
public class Homework10 {
    public static void main(String[] args) {

        //创建Mora对象
        Mora mora= new Mora();

        //记录输赢次数
        int isWinCount = 0;

        //创建一个二维数组表示猜拳次数
        int[][] arr1 = new int[3][3];
        int j = 0;

        //创建一个一维数组，来记录每组输赢
        String[] arr2 = new String[3];

        Scanner scanner = new Scanner(System.in);

        //设置循环，表示猜拳次数
        for (int i = 0; i <3 ; i++) {
            //获取玩家的出拳
            System.out.println("请出拳(0表示石头 1表示剪刀 2表示布)：");
            int num = scanner.nextInt();
            mora.setTomGuess(num);
            arr1[i][j + 1] = mora.getTomGuess();
            //接收电脑出的拳
            int computerGuessNum = mora.computerGuess();
            arr1[i][j + 2] = computerGuessNum;
            //将玩家的拳与电脑的拳比较
            //isWin接收结果
            String isWin = mora.compare();

            arr2[i] = isWin;
            arr1[i][j] = mora.count;

            //对每一局的情况进行输出
            System.out.println("=======================================");
            System.out.println("局数 \t玩家出拳\t\t电脑出拳\t\t输赢情况");
            System.out.println(arr1[i][j] + "\t\t\t" + arr1[i][j + 1] + "\t\t\t" +arr1[i][j + 2] + "\t\t" + mora.compare());
            System.out.println("=======================================");
            System.out.println();

            //记录输赢次数
            isWinCount = mora.winCount(isWin);
        }
        //对游戏的最终结果进行输出
        System.out.println("局数 \t玩家出拳\t\t电脑出拳\t\t输赢情况");
        for (int i = 0; i < arr1.length; i++) {
            for (int k = 0; k < arr1[i].length; k++) {
                System.out.print(arr1[i][k] + "\t\t\t");
            }
            System.out.println(arr2[i]);
        }
        System.out.println("你赢了 " + isWinCount + " 次");
    }
}

class Mora {
    //电脑猜拳
    int comGuessNum;
    //Tom猜拳
    int tomGuessNum;
    //猜拳局数
    int count;
    //赢的次数
    int winCountNum;

   //电脑猜拳
    public int computerGuess() {
        Random r = new Random();
        comGuessNum = r.nextInt(3); //随机生成0~2的随机数
        count += 1;
        return comGuessNum;
    }

    //Tom猜拳
    public void setTomGuess(int tomGuessNum) {
        if (tomGuessNum < 0 || tomGuessNum > 2) {
            System.out.println("输出的数字不合格");
            return;
        }
        this.tomGuessNum = tomGuessNum;
    }
    //返回出拳数字
    public int getTomGuess(){
        return tomGuessNum;
    }

    /**
     * 比较电脑和Tom的拳
     * @return 输赢情况
     */
    public String compare() {
        if (comGuessNum == 0 && tomGuessNum == 2) {
            return "你赢了";
        } else if (comGuessNum == 1 && tomGuessNum == 0) {
            return "你赢了";
        } else if (comGuessNum == 2 && tomGuessNum == 1) {
            return "你赢了";
        } else if (comGuessNum == tomGuessNum) {
            return "平局";
        } else {
            return "你输了";
        }
    }

    //记录玩家赢的次数的方法
    public int winCount(String s){

        if (s.equals("你赢了")){
            winCountNum ++;
        }
        return winCountNum;
    }
}