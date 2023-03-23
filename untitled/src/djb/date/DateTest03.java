package djb.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest03 {
    public static void main(String[] args) {
        //这个是什么时间,输出的是北京时间
        //格林尼治时间为:1970-01-01 00:00:00 001
        Date time = new Date(1); //参数是毫秒

        //获取自1970年1月1日 00:00:00 000过了1毫秒后的时间(北京时间)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String strTime = sdf.format(time);
        //北京是东八区,相差8个小时
        //所以现在起始时间为：1970-01-01 08:00:00 000
        System.out.println(strTime); //1970-01-01 08:00:00 001

        //获取昨天此时的时间
        Date time2 = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
        String strTime2 = sdf.format(time2);
        System.out.println(strTime2);
    }
}
