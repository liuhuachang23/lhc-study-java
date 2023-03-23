package hsp.chapter27.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/15 16:15 星期日
 * @Operating:
 * @Description: 演示 非捕获分组
 *
 */
public class RegSign03 {
    public static void main(String[] args) {

        String content = "hello韩顺平教育 jack韩顺平老师 韩顺平同学hello";

        //说明：非捕获分组，它只匹配 不捕获，所以后期在遍历时，只能用matcher.group(0)，不能使用matcher.group(1)...去捕获分组中的内容

        //1. 找到 韩顺平教育、韩顺平老师、韩顺平同学 子字符串
        String regStr1 = "韩顺平(?:教育|老师|同学)";

        //2. 找到 韩顺平 这个关键字，但是要求只能查找 韩顺平教育、韩顺平老师 中的 韩顺平
        String regStr2 = "韩顺平(?=教育|老师)";

        //3. 找到 韩顺平 这个关键字，但是要求只能查找 韩顺平教育、韩顺平老师 之外的 韩顺平
        String regStr3 = "韩顺平(?!教育|老师)";

        Pattern pattern = Pattern.compile(regStr3);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("得到：" + matcher.group(0));
        }
    }
}
