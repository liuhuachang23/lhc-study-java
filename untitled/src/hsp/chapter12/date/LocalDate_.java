package hsp.chapter12.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

//第三代日期
/*
 * 1.前面两代日期类的不足之处:
 *   JDK1.0 中包含了一个java.util.Date类,但是它的大多数方法已经在JDK1.1引入Calendar类之后被抛弃了
 *   而Calendar类的不足之处有
 *       1)可变性:像日期和时间这样的类应该是不可变的
 *       2)偏移性:Date的年份是从1900开始的,而月份都是从0月份开始的
 *       3)格式化:格式化只对Date有用,Calendar不行
 *       4)此外它不是线程安全的,不能处理闰秒等(每隔两天多出1秒)
 *
 * 2.第三代日期类的常见方法
 *   1)LocalDate() :只包含日期,可以获取日期字段
 *   2)localTime() :只包含时间,可以获取时间字段
 *   3)LocalDateTime() :包含时间+日期 ,可以获取日期和时间字段
 * */
public class LocalDate_ {
    public static void main(String[] args) {

        //1.使用now() 返回表示当前日期时间的 对象
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        //2.使用DateTimeFormatter 对象来进行格式化
        //1)创建DateTimeFormatter对象
        //2)使用DateTimeFormatter对象的format方法完成格式化
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        String format = dtf.format(ldt);
        System.out.println(format);

        System.out.println("年= " + ldt.getYear());
        System.out.println("月= " + ldt.getMonth());
        System.out.println("月(数字)= " + ldt.getMonthValue());
        System.out.println("日= " +ldt.getDayOfMonth());
        System.out.println("时= "+ ldt.getHour());
        System.out.println("分= " +ldt.getMinute());
        System.out.println("秒= " +ldt.getSecond());

        //只需要年月日
        LocalDate now = LocalDate.now();
        //只需要时分秒
        LocalTime now1 = LocalTime.now();


        //提供 plus 和 minus 方法可以对当前时间进行加减
        //看看890天后,是什么时候
        LocalDateTime localDateTime = ldt.plusDays(890);
        System.out.println(dtf.format(localDateTime));  //格式化一下在输出
        //看看 3920分钟前是什么时间
        LocalDateTime localDateTime1 = ldt.minusMinutes(3920);
        System.out.println(dtf.format(localDateTime1));
    }
}

