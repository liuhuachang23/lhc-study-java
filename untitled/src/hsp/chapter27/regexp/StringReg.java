package hsp.chapter27.regexp;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/16 21:07 星期一
 * @Operating:
 * @Description:
 */
public class StringReg {
    public static void main(String[] args) {

        //1. 替换功能：
        //使用正则表达式，将 JDK1.3、JDK1.4、J2SE1.3 --替换成--> JDK
        String content = "2000年5月，JDK1.3、JDK1.4和J2SE1.3相继发布，几周后其获得了Apple公司Mac OS X的工业标准的支持";
        content = content.replaceAll("JDK1\\.3|JDK1\\.4|J2SE1\\.3", "JDK");
        System.out.println(content);

        System.out.println("========================");

        //2. 判断功能
        //验证一个手机号，要求必须是 138、139 开头的
        content = "13777908902";
        boolean matches = content.matches("1(37|38)\\d{8}");
        if (matches) {
            System.out.println("验证成功");
        } else {
            System.out.println("验证失败");
        }

        System.out.println("========================");

        //3. 分割功能
        //要求按照 #、~、数字 来分割
        content = "hello#abc-jack12smith~北京";
        String[] split = content.split("#|-|~|\\d+");
        for (String s : split) {
            System.out.println(s);
        }

        //4. 整体匹配

        content = "liu_hua_chang@java.com";
        String regStr = "[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+";
        //使用matches判断
        //整体匹配，可以不加定位符
        if (content.matches(regStr)) {
            System.out.println("满足格式");
        } else {
            System.out.println("不满足格式");
        }

        //为什么是整体匹配 我们来看一下 String.matches() 的底层源码：
        /**
         * //String.matches() 底层就是调用  Pattern.matches() 在调用 matcher.matches();
         *
         * String.matches()：
         *      //调用Pattern.matches()
         *      public boolean matches(String regex) {
         *          return Pattern.matches(regex, this);     // this 就是他的调用者 content
         *      }
         *
         * Pattern.matches()：
         *      //创建 Pattern正则表达式对象，和 Matcher匹配器对象，再调用 matcher.matches()
         *      public static boolean matches(String regex, CharSequence input) {
         *          Pattern p = Pattern.compile(regex);
         *          Matcher m = p.matcher(input);
         *          return m.matches();
         *      }
         *
         * matcher.matches()：
         *      //这个方法源码的注解为：尝试将整个区域与模式匹配 即完整匹配
         *      public boolean matches() {
         *          return match(from, ENDANCHOR);
         *      }
         */

    }
}
