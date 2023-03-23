package hsp.chapter27.homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/17 7:56 星期二
 * @Operating:
 * @Description: 电子邮件
 * 要求：(1) 只能有一个 @
 *      (2) @ 前面是用户名，可以是a-z A-Z 0-9 _ - 字符
 *      (3) @ 后面是域名，并且域名只能是英文字母，如 sohu.com 或 tsinghuo.org.cn
 *
 */
public class Homework01 {
    public static void main(String[] args) {

        String content = "liu-hua_chang@java.com";
        String regStr1 = "^[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+$";
        String regStr2 = "[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+";


        Pattern pattern = Pattern.compile(regStr1);
        Matcher matcher = pattern.matcher(content);

        //使用find判断
        if (matcher.find()){
            System.out.println("满足格式");
        } else {
            System.out.println("不满足格式");
        }

        //使用matches判断
        //整体匹配，可以不加定位符，建议加上 更严谨
        if (content.matches(regStr2)){
            System.out.println("满足格式");
        } else {
            System.out.println("不满足格式");
        }

    }
}