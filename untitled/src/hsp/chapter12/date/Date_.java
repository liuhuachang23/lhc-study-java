package hsp.chapter12.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//第一代日期使用
public class Date_ {
    public static void main(String[] args) throws ParseException {

        //获取当前时间
        //这里的Date类在java.util.Date包下
        //默认输出的日期是国外的方式,因此我们需要对格式进行转换
        Date d1 = new Date();
        System.out.println(d1);
        //创建SimpleDateFormat对象,可以指定相应的格式
        //在调用SimpleDateFormat内的format() , 传入未处理的当前日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss E");
        String format = sdf.format(d1);
        System.out.println(format);

        //通过指定毫秒数来,得到时间(自 1970-1-1 的时间)
        Date d2 = new Date(92292);
        System.out.println(sdf.format(d2));

        //把一个格式化的String 转成 Date
        //转换时,使用的sdf格式,需要与你给的String格式一致,否则抛出转换异常
        String s = "2020-1-33 2:30:50 星期一";
        Date parse = sdf.parse(s);
        //此时默认按照国外方式输出
        System.out.println(parse);
        //可以进行转换
        System.out.println(sdf.format(parse));

    }
}
