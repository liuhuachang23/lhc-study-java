package hsp.chapter07.classicexample;

import java.util.Scanner;

/*
手机选号:根据用户输入的手机号来确认用户实际支付的价格
    如果尾数为8，需支付办卡费50元
    如果尾数为4，需支付办卡费用0元
    如果是其他尾号,需支付办卡费用20元
 */
public class Test07 {
    public static void main(String[] args) {
        //用户输入电话号码
        System.out.println("请输入您的手机号码：");
        String tel = new Scanner(System.in).nextLine();

        //调用方法判断
        getPrice(tel);
    }
    public static void getPrice(String tel){
        //取出电话号码尾数
        char c = tel.charAt(10);
        int i = c;
        //判断是否为电话号码
        if (tel.length() != 11 && i != 1){
            System.out.println("您输入的手机号码不合格");
            //结束方法，返回到调用位置再继续执行
            return;
        } else if (i == 8){
            System.out.println("你需要支付的办卡费为50元");
        } else if (i == 4){
            System.out.println("你需要支付的办卡费为0元");
        } else {
            System.out.println("你需要支付的办卡费20元");
        }
    }
}
