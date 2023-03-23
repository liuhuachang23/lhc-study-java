package hsp.chapter27.homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/17 15:25 星期二
 * @Operating:
 * @Description: 对一个url进行解析
 * http://www.sohu.com:8080/abc/index.htm
 * (1)协议 http
 * (2)域名 www.sohu.com
 * (3)端口号 8080
 * (4)文件名 index.htm
 */
public class Homework03 {
    public static void main(String[] args) {
        //将 需要提取的 子字符串，分组
        String content = "http://www.sohu.com:8080/abc/zz/yy/index@.htm";
        String regStr = "^([A-Za-z]+)://([a-zA-Z.]+):(\\d+)[\\w-/]*/([\\w.@]+)$";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            System.out.println("整体匹配：" + matcher.group(0));
            System.out.println("协议：" + matcher.group(1));
            System.out.println("域名：" + matcher.group(2));
            System.out.println("端口号：" + matcher.group(3));
            System.out.println("文件名：" + matcher.group(4));
        }
    }
}
