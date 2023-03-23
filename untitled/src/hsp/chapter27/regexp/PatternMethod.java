package hsp.chapter27.regexp;

import java.util.regex.Pattern;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/16 15:54 星期一
 * @Operating:
 * @Description: 演示 matches方法，用于整体匹配，验证输入的字符串是否满足条件使用
 */
public class PatternMethod {

    public static void main(String[] args) {

        String content = "10https://www.bilibili.com/video/BV1fh411y7R8?from=search&seid=1831060912083761326";
        String regStr = "((http|https)://)?([\\w-]+\\.)+[\\w-]+(\\/[\\w-?=&/%.#]*)?";

        //整体匹配，验证输入的字符串是否满足条件使用
        //所以在验证上面这个，不需要 regStr 加 ^ 和 $ 定位符
        //而通过 matcher.find() 验证时，必须加上定位符
        boolean matches = Pattern.matches(regStr, content);
        /**
         * Pattern.matches() 源码：
         *      //创建 Pattern正则表达式对象，和 Matcher匹配器对象，再调用 matcher.matches()
         *      public static boolean matches(String regex, CharSequence input) {
         *          Pattern p = Pattern.compile(regex);
         *          Matcher m = p.matcher(input);
         *          return m.matches();
         *     }
         *
         * matcher.matches()：
         *      //这个方法源码的注解为：尝试将整个区域与模式匹配 即完整匹配
         *      public boolean matches() {
         *          return match(from, ENDANCHOR);
         *      }
         *
         */
        System.out.println("整体匹配：" + matches);
    }

}
