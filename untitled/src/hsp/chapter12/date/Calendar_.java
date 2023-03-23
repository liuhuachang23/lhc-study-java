package hsp.chapter12.date;

import java.util.Calendar;

//第二代日期使用
public class Calendar_ {
    public static void main(String[] args) {

        //1. Calendar是一个抽象类,并且构造器是private ,所以不能直接创建Calender对象
        //2. 可以通过getInstance() 来获取实例
        //3. 提供大量方法和字段给程序员使用
        //4. Calendar没有提供专门的格式化方法,所以需要程序员自己来组合显示

        //1.调用getInstance(),获取日历对象
        Calendar c = Calendar.getInstance();
        System.out.println(c);
        //2.获取日历对象的某个日历字段
        System.out.println("年:" + c.get(Calendar.YEAR));
        //这里的月为什么要加一,因为Calendar返回月的时候是按照 0 开始编号
        System.out.println("月:" + c.get(Calendar.MONDAY) + 1);
        System.out.println("日:" + c.get(Calendar.DAY_OF_MONTH));
        System.out.println("时:" + c.get(Calendar.HOUR));
        System.out.println("分:" + c.get(Calendar.MINUTE));
        System.out.println("秒:" + c.get(Calendar.SECOND));
        //3.Calendar 没有专门的格式化方法,所以需要程序员自己来组合显示
        System.out.println(c.get(Calendar.YEAR) + "-" + c.get(Calendar.DAY_OF_MONTH) + "-"
                + c.get(Calendar.DAY_OF_MONTH) + " " + c.get(Calendar.HOUR) + "-" + c.get(Calendar.MINUTE)
                + ":" + c.get(Calendar.SECOND));
        //4. 如果我们需要按照 24小时进制 来获取时间, 将Calendar.HOUR --> Calendar.HOUR_OF_DAY
        System.out.println("时= " + c.get(Calendar.HOUR_OF_DAY));

    }
}
