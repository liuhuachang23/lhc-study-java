package hsp.chapter27.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/15 14:55 星期日
 * @Operating:
 * @Description: 演示捕获分组 （非命名分组、命名分组）
 */
public class RegSign02 {
    public static void main(String[] args) {

        String content = "wuwenli2001 ";

        //非命名分组
        String regStr1 = "(\\d\\d)(\\d\\d)";
        //说明：
        //1. matcher.group(0) 得到匹配到的字符串
        //2. matcher.group(1) 得到匹配到的字符串的第一个分组内容
        //3. matcher.group(2) 得到匹配到的字符串的第二个分组内容

        //命名分组（给分组命名）
        String regStr2 = "(?<g1>\\d\\d)(?<g2>\\d\\d)";
        //说明：
        //1. matcher.group(0) 得到匹配到的字符串
        //2. matcher.group(1)|matcher.group("g1") 得到匹配到的字符串的第一个分组内容
        //3. matcher.group(2)|matcher.group("g2") 得到匹配到的字符串的第二个分组内容

        Pattern pattern = Pattern.compile(regStr2);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("group(0)：" + matcher.group(0));
            System.out.println("group(1)：" + matcher.group(1));
            System.out.println("通过组名获取：" + matcher.group("g1"));
            System.out.println("group(2)：" + matcher.group(2));
            System.out.println("通过组名获取：" + matcher.group("g2"));
        }

    }
}