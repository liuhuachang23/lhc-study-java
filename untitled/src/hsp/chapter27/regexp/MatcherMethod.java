package hsp.chapter27.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/16 16:20 星期一
 * @Operating:
 * @Description: 类的常用方法
 */
public class MatcherMethod {
    public static void main(String[] args) {
        String content = "hello edu jack hspedu tom hello smith hello hspedu hspedu";
        //String regStr = "hello"; //演示 方法 1、2、3
        //String regStr = "hello.*"; //演示 方法 3
        String regStr = "hspedu"; //演示 方法 4


        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            System.out.println("=================");
            //1. matcher.start() 获取子字符串的第一个字符索引值
            System.out.println(matcher.start());
            //2. matcher.end() 获取子字符串的最后一个字符索引值+1
            System.out.println(matcher.end());
            //我们可以利用上面这两个数据，直接截取匹配到的子字符串
            System.out.println("找到：" + content.substring(matcher.start(), matcher.end()));

            //4. replaceAll() 替换
            //将 content中 regStr的内容 替换成 韩顺平教育 ，即 hspedu --> 韩顺平教育
            //注意：返回的内容 完成了替换，但是不会改变 content的内容
            System.out.println(matcher.replaceAll("韩顺平教育"));
            System.out.println(content);
        }

        //3. matcher.matches() 整体匹配，常用于 校验某个字符串是否满足某个规则
        System.out.println(matcher.matches());


    }
}
