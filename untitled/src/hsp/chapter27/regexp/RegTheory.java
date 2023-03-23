package hsp.chapter27.regexp;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/14 14:07 星期六
 * @Operating:
 * @Description: 分析java的正则表达式的底层实现
 * 案例演示：
 */
@SuppressWarnings({"all"})
public class RegTheory {
    public static void main(String[] args) {
    }

    @Test
    //不分组匹配所有四个数字
    public void RegTheory01() {

        String content = "1996年1月，SUN公司推出了JDK1.0，1998年12月8日，" +
                "JDK1.2——第二代Java平台的企业版J2EE发布.1999年6月，Sun公司把Java体系分为三个方向：" +
                "J2ME（Java2 Micro Edition，Java2平台的微型版），应用于移动、无线及有限资源的环境；" +
                "J2SE（Java 2 Standard Edition，Java 2平台的标准版），应用于桌面环境；" +
                "J2EE（Java 2Enterprise Edition，Java 2平台的企业版），应用于基于Java的应用服务器";

        //说明：\\d 表示任意数字
        String regStr = "\\d\\d\\d\\d";
        //1. 创建模式对象（正则表达式对象）
        Pattern pattern = Pattern.compile(regStr);
        //2. 创建匹配器
        //说明：使用正则表达式对象，创建匹配器matcher，按照 该正则表达式规则 去匹配 content字符串
        Matcher matcher = pattern.matcher(content);

        //3. 开始匹配
        /**
         * 匹配规则：String regStr = "\\d\\d\\d\\d";
         *
         * matcher.find() 完成的任务
         *  1. 根据指定的规则，定位满足规则的子字符串
         *  2. 第一次执行find() 匹配到 （1996）
         *    （1）将匹配到的 子字符串的索引值 记录到 matcher对象的属性 int[] groups 数组中 （该数组起始值都为-1）
         *          - 把子字符串 开始的索引值 记录到 groups[0]中（即 groups[0] = 0）
         *          - 把子字符串 结束的索引值+1 记录到 groups[1]中（即 groups[1] = 4）
         *    （2）同时记录 oldLast的值为 子字符串结束的索引值+1 （即 oldLast = 4）
         *          作为下次执行 find()匹配 的起点
         *
         *  3. 第二次执行find() 匹配到(1998)
         *      （1）第二次匹配开始前，会将 int[] groups 清空，再开始类似操作：
         *      （2）子字符串的索引值 记录到 matcher对象的属性 int[] groups 数组中;
         *            - 把子字符串 开始的索引值 记录到 groups[0]中（即 groups[0] = 23）
         *            - 把子字符串 结束的索引值+1 记录到 groups[1]中（即 groups[1] = 27）
         *      （3）同时记录 oldLast的值为 子字符串结束的索引值+1 （即 oldLast = 27） 作为下次执行 find()匹配 的起点
         *
         * matcher.group() 完成的任务
         * 1.答案： group(0)完成的任务为  从content中截取索引为 [groups[0],groups[1]) 的子字符串 并返回
         *          第一次执行返回 [0,4) = 1996
         *          第二次执行返回 [23,27) = 1998
         *
         * 2. group()源码 分析：
         *      public String group(int group) {
         *          if (first < 0)
         *              throw new IllegalStateException("No match found");
         *          if (group < 0 || group > groupCount())
         *              throw new IndexOutOfBoundsException("No group " + group);
         *          if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
         *              return null;
         *          return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
         *      }，
         *
         *      解读：return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
         *      （2）matcher.group(0) 即 group = 0
         *      （3）根据上面推导出：return getSubSequence(groups[0], groups[1]).toString();
         *
         */
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }

    @Test
    //考虑分组2组 匹配所有四个数字
    public void RegTheory02() {

        //什么是分组，比如 (\d\d)(\d\d)，正则表达式中有() 表示分组，第1个括号表示第一组，第2个括号表示第二组...

        String content = "1996年1月，SUN公司推出了JDK1.0，1998年12月8日，" +
                "JDK1.2——第二代Java平台的企业版J2EE发布.1999年6月，Sun公司把Java体系分为三个方向：" +
                "J2ME（Java2 Micro Edition，Java2平台的微型版），应用于移动、无线及有限资源的环境；" +
                "J2SE（Java 2 Standard Edition，Java 2平台的标准版），应用于桌面环境；" +
                "J2EE（Java 2Enterprise Edition，Java 2平台的企业版），应用于基于Java的应用服务器";

        //分组2组 匹配所有四个数组：
        String regStr = "(\\d\\d)(\\d\\d)";
        //1. 创建模式对象（正则表达式对象）
        Pattern pattern = Pattern.compile(regStr);
        //2. 创建匹配器
        //说明：使用正则表达式对象，创建匹配器matcher，按照 该正则表达式规则 去匹配 content字符串
        Matcher matcher = pattern.matcher(content);

        //3. 开始匹配
        /**
         * 匹配规则：String regStr = "(\\d\\d)(\\d\\d)";
         *
         * matcher.find() 完成的任务
         *  1. 根据指定的规则，定位满足规则的子字符串
         *  2. 第一次执行find() 匹配到 （ (19)(96) ）
         *    （1）将匹配到的 子字符串的索引值 记录到 matcher对象的属性 int[] groups 数组中（该数组起始值都为-1）
         *         - 把子字符串 开始的索引值 记录到 groups[0]中                   （即 groups[0] = 0）
         *         - 把子字符串 结束的索引值+1 记录到 groups[1]中                 （即 groups[1] = 4）
         *         - 把第一个括号匹配到的字符串 开始的索引值 记录到 groups[2]中      （即 groups[2] = 0）
         *         - 把第一个括号匹配到的字符串 结束的索引值+1 记录到 groups[3]中    （即 groups[3] = 2）
         *         - 把第二个小括号匹配到的字符串 开始的索引值 记录到 groups[4]中    （即 groups[4] = 2）
         *         - 把第二个小括号匹配到的字符串 结束的索引值+1 记录到 groups[5]中  （即 groups[5] = 4）
         *         //更多分组以此类推...
         *    （2）同时记录 oldLast的值为 子字符串结束的索引值+1 （即 oldLast = 4） 作为下次执行 find()匹配 的起点
         *
         *  3. 第二次执行find() 匹配到（ (19)(98) )
         *      （1）第二次匹配开始前，会将 int[] groups 清空，再开始类似操作
         *      （2）将匹配到的 子字符串的索引值 记录到 matcher对象的属性 int[] groups 数组中
         *          - 把子字符串 开始的索引值 记录到 groups[0]中                   （即 groups[0] = 23）
         *          - 把子字符串 结束的索引值+1 记录到 groups[1]中                 （即 groups[1] = 27）
         *          - 把第一个括号匹配到的字符串 开始的索引值 记录到 groups[2]中      （即 groups[2] = 23）
         *          - 把第一个括号匹配到的字符串 结束的索引值+1 记录到 groups[3]中    （即 groups[3] = 25）
         *          - 把第二个小括号匹配到的字符串 开始的索引值 记录到 groups[4]中    （即 groups[4] = 25）
         *          - 把第二个小括号匹配到的字符串 结束的索引值+1 记录到 groups[5]中  （即 groups[5] = 27）
         *          //更多分组以此类推...
         *      （3）同时记录 oldLast的值为 子字符串结束的索引值+1 （即 oldLast = 27） 作为下次执行 find()匹配 的起点
         *
         *
         * matcher.group() 完成的任务
         *  1. 先说答案：
         *      (1) group(0) : 从content中截取索引为 [groups[0],groups[1]) 的子字符串 并返回
         *              第一次执行返回 [0,4) = 1996
         *              第二次执行返回 [23,27) = 1998
         *      (2) group(1) : 从content中截取索引为 [groups[2],groups[3]) 的子字符串 并返回
         *              第一次执行返回 [0,4) = 19
         *              第二次执行返回 [23,27) = 19
         *      (3) group(3) : 从content中截取索引为 [groups[4],groups[5]) 的子字符串 并返回
         *              第一次执行返回 [0,4) = 96
         *              第二次执行返回 [23,27) = 98
         *
         *  2. 分析group()源码：
         *      public String group(int group) {
         *          if (first < 0)
         *              throw new IllegalStateException("No match found");
         *          if (group < 0 || group > groupCount())
         *              throw new IndexOutOfBoundsException("No group " + group);
         *          if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
         *              return null;
         *          return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
         *      }，
         *
         *      解读：return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
         *
         *      （1）matcher.group(0) 即 group = 0
         *          return getSubSequence(groups[0], groups[1]).toString();
         *          从content中截取索引为 [groups[0],groups[1]) 的子字符串 并返回
         *
         *      （2）matcher.group(1) 即 group = 1
         *          return getSubSequence(groups[2], groups[3]).toString();
         *          从content中截取索引为 [groups[2],groups[3]) 的子字符串 并返回
         *
         *      （3）matcher.group(2) 即 group = 2
         *          return getSubSequence(groups[4], groups[5]).toString();
         *          从content中截取索引为 [groups[4],groups[5]) 的子字符串 并返回
         *
         */
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
            System.out.println("第一组括号匹配到的值= " + matcher.group(1));
            System.out.println("第二组括号匹配到的值= " + matcher.group(2));

        }
    }
}
