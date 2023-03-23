package hsp.chapter08.smallchangesys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {
    //化繁为简
    //1. 先完成显示菜单，并可以选择菜单，给出对应提示
    //2. 完成零钱通明细
    //3. 完成收益入账
    //4. 消费
    //5. 退出
    //6. 用户输入4退出时，给出提示"你确定要退出吗? y/n"，必须输入正确的y/n ，否则循环输入指令，直到输入y 或者 n
    //7. 在收益入账和消费时，判断金额是否合理，并给出相应的提示
    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";

        //2.完成零钱通明细
        //思路：
        //（1）可以把收益入账和消费，存储到数组当中
        //（2）可以使用对象
        //（3）简单的话可以使用String拼接
        //现在我们先使用第3种
        String details = "--------------零钱通明细--------------\n";

        //3.完成收益入账
        //定义新的变量
        double money = 0;
        double balance = 0;
        Date date = null;//date是java.util.Date包下的一个属性,表示日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式

        //4.消费
        //定义新变量,表示消费项目
        String project = "";

        do {

            //1.完成显示菜单，并且可以选择
            System.out.println("============零钱通============");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退     出");

            System.out.println("请选择服务项目(1~4):");
            key = scanner.next();

            //使用switch 分支控制
            switch(key){
                case "1" :
                    System.out.println(details);
                    break;
                case "2" :
                    System.out.println("请输入收益入账金额: ");
                    money = scanner.nextDouble();
                    //在收益入账时，判断金额是否合理，并给出相应的提示
                    if (money < 0 ){
                        System.out.println("你输入的金额不合法");
                        break;
                    }
                    balance += money;
                    //获取当前日期
                    Date date1 = new Date();
                    //完成字符串拼接(与前面的details拼接在一起)
                    details += "收益入账"+ "\t+" + money + "\t" + sdf.format(date1) + "\t" + "余额:" + balance + "\n";
                    break;
                case "3" :
                    System.out.println("请输入消费项目: ");
                    project = scanner.next();
                    System.out.println("请输入消费金额: ");
                    money = scanner.nextDouble();
                    //7. 在消费时，判断金额是否合理，并给出相应的提示
                    if (money < 0 || money >balance ){
                        System.out.println("你的消费金额应该在 0~" + balance);
                        break;
                    }
                    balance -= money;
                    //获取当前日期
                    Date date2 = new Date();
                    details += project + "\t-" + money + "\t" + sdf.format(date2) + "\t" + "余额:" + balance + "\n";
                    break;
                case "4" :
                    //用户输入4退出时，给出提示"你确定要退出吗? y/n"，
                    // 必须输入正确的y/n ，否则循环输入指令，直到输入y 或者 n
                    System.out.println("你确定要退出吗? y/n");
                    char c ;
                    c = scanner.next().charAt(0);
                    if (c == 'y'){
                        System.out.println("退      出");
                        loop = false;
                        break;
                    } else if (c == 'n'){
                        break;
                    }

                default:
                    System.out.println("菜单选择有误,重新选择!");
            }

        }while (loop);
        System.out.println("退出零钱通...");
    }
}
