package hsp.chapter27.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/16 10:16 星期一
 * @Operating:
 * @Description: 正则表达式语法 应用实例
 */
public class RegSign04 {
    public static void main(String[] args) {

        String content = "https://www.bilibili.com/video/BV1fh411y7R8?from=search&seid=1831060912083761326";


        //1. 汉字
        String regStr1 = "^[\u0391-\uffe5]+$";
        //2. 邮政编码（是1-9开头的一个 6位数字组成）
        String regStr2 = "^[1-9]\\d{5}$";
        //3. QQ号码（是1-9开头的一个 5到10位数字组成）
        String regStr3 = "^[1-9]\\d{4,9}$";
        //4. 手机号码（必须以13、14、15、18 开头的11为数字组成）
        //String regStr4 = "^1[3|4|5|8]\\d{9}$";
        String regStr4 = "^1(?:3|4|5|8)\\d{9}$";

        //5. URL（如 https://www.bilibili.com/video/BV1fh411y7R8?from=search&seid=1831060912083761326）
        /**
         * 解析
         * 1. https:// 部分（可能是 https:// 或 http://）            --> ((http|https)://)
         * 2. www.bilibili.com 部分
         *    (1) www. 部分 (可能是多个 字母数字 、连字符)            --> ([\\w-]+\\.)
         *    (2) bilibili. 部分 (可能是多个 字母数字、连字符)        --> ([\\w-]+\\.)
         *    (3)com 部分 (可能是多个 字母数字、连字符 )              --> [\\w-]+
         * 3. 其余部分 (可能是 字母数字、连字符、？、=、&、/、%、.、#)   --> (\\/[\\w-?=&/%.#]*)?
         *
         *    说明：(1)特殊符号（？、=、&、/、%、.、#） 写在 [] 内就是表示字符本身，没有其他含义
         *              即 代表单纯的字符符号，不是正则表达式语法符号了
         *         (2)有些部分是 可能有可能没有的所以结尾加个 "?" 表示0到1
         *                      "+" 表示 1到多
         *                      "*" 表示 0到多
         */
        String regStr5 = "^((http|https)://)?([\\w-]+\\.)+[\\w-]+(/[\\w-?=&/%.#]*)?$";


        Pattern pattern = Pattern.compile(regStr5);
        Matcher matcher = pattern.matcher(content);

        //定位符^ 和 $ 是整体匹配，只能匹配出一个结果或没有结果
        if (matcher.find()) {
            System.out.println("满足格式");
        } else {
            System.out.println("不满足格式");
        }


    }
}
