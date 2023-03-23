package djb.date;

/*
* 获取自1970年1月1日 00:00:00 000到当前系统时间的总毫秒数
*
* 简单总结一下System类的相关属性和方法
*   System.out 【out是System类的静态方法】
*   System.out.println() 【println()方法不是System类型，是printStream类的方法】
*   System.gc 【建议启动垃圾回收器】
*   System.currentTimeMillis() 【获取自1970年1月1日 00:00:00 000到当前系统时间的总毫秒数】
*   System.exit(0) 【退出JVM】
* */
public class DateTest02 {
    public static void main(String[] args) {
        //获取自1970年1月1日 00:00:00 000到当前系统时间的总毫秒数
        long nowTimeMillis = System.currentTimeMillis();
        System.out.println(nowTimeMillis);

        //统计一个方法耗时
        long begin = System.currentTimeMillis();
        print();
        long end = System.currentTimeMillis();
        System.out.println("耗费时长：" + (end - begin));

    }

    //需求：统计一个方法执行所耗费的时长
    public static void print(){
        for (int i = 0; i < 1000000000 ; i++) {
            //System.out.println("i = " + i);
        }
    }
}
