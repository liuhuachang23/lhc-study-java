package hsp.chapter27.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/13 19:43 星期五
 * @Operating:
 * @Description: 体验正则表达式操作文本的便捷
 */
public class Regexp_ {
    public static void main(String[] args) {
        //假定，编写爬虫从百度页面得到了如下文本
        /*String content = "勒布朗·詹姆斯在2003年NBA选秀中于首轮第1顺位被克利夫兰骑士队选中，" +
                "在2009年与2010年蝉联NBA常规赛最有价值球员（MVP）。2010年，詹姆斯转会至迈阿密热火队。" +
                "2012年，詹姆斯得到NBA个人生涯的第3个常规赛MVP，第1个总冠军以及总决赛MVP，并代表美国男篮夺得了伦敦奥运会金牌，追平了迈克尔·乔丹在1992年所创的纪录。" +
                "2013年，詹姆斯夺得第4个常规赛MVP、第2个NBA总冠军和第2个总决赛MVP，实现两连冠。" +
                "2014年，詹姆斯回归骑士队。2016年，詹姆斯带领骑士队逆转战胜卫冕冠军金州勇士队夺得队史首个总冠军和个人第3个总决赛MVP。" +
                "2018年7月10日，詹姆斯正式与洛杉矶湖人队签下4年1.53亿美元的合同。2019-20赛季，" +
                "詹姆斯当选NBA助攻王并带领湖人队夺得第4次总冠军以及个人第4个总决赛MVP。";*/

        /*String content = "<div><a href=\"/calendar/\" target=\"_blank\">历史上的今天</a></div>\n" +
                "<div><a href=\"/vbaike/\" target=\"_blank\">百科冷知识</a></div>\n" +
                "<div><a href=\"/vbaike#gallary\" target=\"_blank\">图解百科</a></div>\n" +
                "<div><a href=\"https://child.baidu.com/\" target=\"_blank\">懂啦</a></div>\n" +
                "<div><a href=\"/item/秒懂本尊答\" target=\"_blank\">秒懂本尊答</a></div>\n" +
                "<div><a href=\"/item/秒懂大师说\" target=\"_blank\">秒懂大师说</a></div>\n" +
                "<div><a href=\"/item/秒懂看瓦特\" target=\"_blank\">秒懂看瓦特</a></div>\n" +
                "<div><a href=\"/item/秒懂五千年\" target=\"_blank\">秒懂五千年</a></div>\n" +
                "<div><a href=\"/item/秒懂全视界\" target=\"_blank\">秒懂全视界</a></div>\n" +
                "<div><a href=\"/museum\" target=\"_blank\">数字博物馆</a></div>\n" +
                "<div><a href=\"/feiyi?fr=dhlfeiyi\" target=\"_blank\">非遗百科</a></div>\n" +
                "<div><a href=\"/wikicategory/view?categoryName=恐龙大全\" target=\"_blank\">恐龙百科</a></div>\n" +
                "<div><a href=\"/wikicategory/view?categoryName=多肉植物\" target=\"_blank\">多肉百科</a></div>\n" +
                "<div><a href=\"/art\" target=\"_blank\">艺术百科</a></div>\n" +
                "<div><a href=\"/science\" target=\"_blank\">科学百科</a></div>\n" +
                "<div><a href=\"/kedou/\" target=\"_blank\">蝌蚪团</a></div>\n" +
                "<div><a href=\"/item/百科热词团队\" target=\"_blank\">热词团</a></div>\n" +
                "<div><a href=\"/campus\" target=\"_blank\">百科校园</a></div>\n" +
                "<div><a href=\"https://baike.baidu.com/talent/home/index\" target=\"_blank\">分类达人</a></div>\n" +
                "<div><a href=\"/task/\" target=\"_blank\">百科任务</a></div>\n" +
                "<div><a href=\"/mall/\" target=\"_blank\">百科商城</a></div>\n";*/
        String content = "以下列出留用的内部私有地址\n" +
                "A类 10.0.0.0--10.255.255.255\n" +
                "B类 172.16.0.0--172.31.255.255\n" +
                "C类 192.168.0.0--192.168.255.255";



        //想要对文本进行相应的操作(具体操作下面介绍)
        //1. 传统方法，使用遍历的方式，代码量大，效率第
        //2. 使用正则表达式

        //(1) 创建一个Pattern对象，模式对象，可以理解成就是一个正则表达式对象
        //Pattern pattern = Pattern.compile("[a-zA-Z]+");                       //提取文章中所有的英文单词
        //Pattern pattern = Pattern.compile("[0-9]+");                          //提取文章中所有的数字
        //Pattern pattern = Pattern.compile("([0-9]+)|([a-zA-Z]+)");            //提取文章中所有的数字和英文单词
        //Pattern pattern = Pattern.compile("target=\"_blank\">(\\S*)</a>");    //提取文章中所有的标题
        Pattern pattern = Pattern.compile("\\d+\\.\\d+\\.\\d+\\.\\d+");         //提取文章中所有的ip地址

        //(2) 创建一个匹配器对象
        //    理解：就是 matcher匹配器按照 pattern（模式、样式），到 content文本 中去匹配
        //    找到就返回true 否则false
        Matcher matcher = pattern.matcher(content);
        //(3) 循环匹配
        while (matcher.find()){
            //匹配到的内容，放到 m.group(0)
            System.out.println("找到：" + matcher.group(0));
        }


    }
}
