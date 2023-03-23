package hsp.chapter07.classicexample;

import java.util.Scanner;

/*
 BMI 指数测试 BMI = 体重 (kg) / 身高² (m)
 接收用户输入的身高和体重,将判断结果输出
        过轻：低于18.5
        正常：18.5 ~ 22.9
        偏胖：23 ~ 24.9
        肥胖：25 ~ 29.9
        重度肥胖：高于30
        极度肥胖：高于40
 */
public class Test05 {
    public static void main(String[] args) {
        //接收用户输入
        System.out.println("请输入您的身高：");
        double height = new Scanner(System.in).nextDouble();
        System.out.println("请输入您的体重");
        double weight = new Scanner(System.in).nextDouble();

        //调用构造方法判断结果
        getBMI(height,weight);
    }

    public static void getBMI(double h, double w){

        //计算BMI
        double bmi = w / (h * h);
        //声明一个变量来记录结果
        String r = "";
        //给它重新赋值
        if (bmi < 18.5){
            r = "过轻";
        }else if (18.5 <= bmi || bmi <= 22.9){
            r = "正常";
        }else if (23 <= bmi || bmi <= 24.9){
            r = "偏胖";
        }else if (25 <= bmi || bmi <= 29.9){
            r = "肥胖";
        }else if (bmi <= 40){
            r = "重度肥胖";
        }else {
            r = "极度肥胖";
    }

        System.out.println("你的BMI指数为：" + bmi);
        System.out.println("您的体重属于" + r);

    }
}
