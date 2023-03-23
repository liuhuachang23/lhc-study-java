package hsp.chapter27.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/16 19:32 星期一
 * @Operating:
 * @Description: 反向引用 例题演示
 */
public class RegSign05 {
    public static void main(String[] args) {

        String content = "我....我要....学学学....编程java!";

        //1. 去掉所有的.
        Pattern pattern = Pattern.compile("\\.");
        Matcher matcher = pattern.matcher(content);
        content = matcher.replaceAll("");
        System.out.println(content);

        //2. 去重

        //(1) 使用 (.)\1+ 匹配连续相同的字符
        //注意：小括号的内容 即第一个分组中捕获内容 会记录到 $1 第(2)步替换时 需要用到
        //解释：我们可以进行反向引用 $1（因为 外部反向引用是 $分组号 ，即 $1 就是代表 反向引用 第一个分组里的内容）
        pattern = Pattern.compile("(.)\\1+");
        //因为正则表达式变化了，需要重置matcher
        matcher = pattern.matcher(content);
        while (matcher.find()){
            System.out.println("找到：" + matcher.group(0)); // 我我、学学学
        }

        //(2) 使用 反向引用$1 来替换匹配到的内容, 将 我-->我我、学-->学学学
        content = matcher.replaceAll("$1");
        System.out.println(content); //我要学编程java!

        //3. 综合 去重步骤
        //正则表达式对象.匹配器对象.替换方法
        content = Pattern.compile("(.)\\1+").matcher(content).replaceAll("$1");
        System.out.println(content);
    }
}
