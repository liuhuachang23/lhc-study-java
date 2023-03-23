package hsp.chapter27.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/15 14:21 星期日
 * @Operating:
 * @Description: 定位符
 *
 *
 */
public class RegSign01 {
    public static void main(String[] args) {

//        ^ 指定起始字符                ^[0-9]+[a-z]*               至少以一个数字开头，后面接任意个小写字母 的字符串
//        $ 指定结束字符                ^[0-9]\\-[a-z]+$            至少以一个数字开头 接一个连字符"-" 至少以一个小写字母结尾 的字符串
//        \\b 匹配目标字符串的边界        han\\b                     它会去content中找 处于空格前的han 或者content结尾的han，有就匹配
//        \B 匹配目标字符串的非边界       han\\B                     和\\b相反，处于上面两种情况的han不会匹配，匹配其他位置上的han

        //1. ^ 的使用：
        //匹配结果：123abc
        String content1 = "123abc123abc123";
        String regStr1 = "^[0-9]+[a-z]*";
        //匹配结果：无
        String content2 = "a123abc123abc123";
        String regStr2 = "^[0-9]+[a-z]*";

        //2. $ 的使用：
        //匹配结果：abc（结尾处的abc）
        String content3 = "123abc123abc";
        String regStr3 = "[a-z]+$";
        //匹配结果：无
        String content4 = "123abc123";
        String regStr4 = "[a-z]+$";

        //3. ^ 和 $ 通常一起使用：
        //匹配结果：无
        String content5 = "123abc123abc";
        String regStr5 = "^[0-9]+[a-z]+$";
        //匹配结果：123abc
        String content6 = "123abc";
        String regStr6 = "^[0-9]+[a-z]+$";

        //4. \\b 的使用：
        //匹配结果：liu 和 liu （空格前的liu 和结尾的liu）
        String content7 = "liuhuachangliu huachangliu";
        String regStr7 = "liu\\b";

        //5. \\B 的使用
        //匹配结果：liu（除： 空格前的liu 和结尾的liu）
        String content8 = "liuhuachangliu huachangliu";
        String regStr8 = "liu\\B";


        Pattern pattern = Pattern.compile(regStr8);
        Matcher matcher = pattern.matcher(content8);
        while (matcher.find()){
            System.out.println("找到：" + matcher.group(0));
        }
    }
}
