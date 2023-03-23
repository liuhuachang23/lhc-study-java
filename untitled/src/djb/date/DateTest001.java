package djb.date;

import java.text.SimpleDateFormat;
import java.util.Date;
/*
* java中对日期的处理
*   这个案例最主要掌握：
*       知识点1：怎么获取系统当前时间
*       知识点2：String --> Date
*       知识点3：Data --> String
* */
public class DateTest001 {
    public static void main(String[] args) throws Exception{

        //获取系统当前时间（精确到毫秒的系统当前时间）
        //直接调用无参数构造方法就行
        Date nowTime = new Date();

        //java.util.Date类的toString()方法已经被重写了
        //Tue Feb 08 17:02:19 CST 2022
        System.out.println(nowTime);

        //日期可以格式化吗？
        //将日期类型Date，按照指定的格式转换：Date --转换成具有一定格式的日期字符串--> String
        //SimpleDateFormat是java.text包下的，专门负责日期格式化的。
        /*
        * yyyy 年
        * MM 月
        * dd 日
        * HH 时
        * mm 分
        * ss 秒
        * SSS 毫秒
        * 注意：在日期格式中，除了y M d H m s S 这些字符不能随便写之外，剩下的符号格式自己随意组织。
        * */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
        //SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
        String nowTimeStr = sdf.format(nowTime);
        //2022-02-08 17:02:19 061
        System.out.println(nowTimeStr);

        //假设现在有一个日期字符串String，怎么转换成Date类型？
        //String --> Data
        String time = "2008-08-08 08:08:08 888";
        //SimpleDateFormat sdf2 = new SimpleDateFormat("格式不能随便写，要和日期字符串格式相同")
        //注意：字符串的日期格式和SimpleDateFormat对象指定的日期格式要一致，不然会出现异常
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date dateTime = sdf2.parse(time);
        System.out.println(dateTime);




    }
}
