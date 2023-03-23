package hsp.chapter12.date;


import java.time.Instant;
import java.util.Date;

public class Instant_ {
    public static void main(String[] args) {

        //1.用Instant调用它的now() 获取当前时间戳的对象
        Instant now = Instant.now();
        System.out.println(now);

        //2.通过from 可以把 Instant 转成 Date
        Date date = Date.from(now);
        //3.通过 date 的 toInstant() 可以把 date 转成 Instant
        Instant instant = date.toInstant();

    }
}
