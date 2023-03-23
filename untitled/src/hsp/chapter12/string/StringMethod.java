package hsp.chapter12.string;

public class StringMethod {
    public static void main(String[] args) {

        //返回 char指定索引处的值。
        char c = "中国人".charAt(1);
        System.out.println(c); //国

        //2、int compareTo(String anotherString)
        //按字典顺序比较两个字符串(按顺序一个个依次比较,排前面的先比较,能出结果就不变往下比较了)
        //返回值: 看如下例题
        String a = "jack";
        String b = "jcckk";
        System.out.println(a.compareTo(b)); // 返回值为 'a' - 'c' = -2
        String a1 = "jack";
        String a2 = "jac";
        System.out.println(a1.compareTo(a2)); //返回值为 a1.length() - a2.length() = 1

        //3、boolean contains(CharSequence s)
        //当且仅当此字符串包含指定的char值序列时才返回true。
        System.out.println("HelloWorld.java".contains(".java")); //true
        System.out.println("http://www.baidu.com".contains("https://")); //false

        //4、boolean endsWith(String suffix)
        //测试此字符串是否以指定的后缀结尾。
        System.out.println("test.txt".endsWith(".txt")); //true
        System.out.println("test.txt".endsWith("xt")); //true
        System.out.println("test.txt".endsWith(".java")); //false

        //5、boolean equals(Object anObject)
        //将此字符串与指定对象进行比较。
        System.out.println("abc".equals("abc")); //true

        //6、boolean equalsIgnoreCase(String anotherString)
        //将此 String与其他 String比较，忽略大小写。
        System.out.println("abC".equalsIgnoreCase("ABc")); //true

        //7、byte[] getBytes()
        //使用平台的默认字符集将此 String编码为字节序列，将结果存储到新的字节数组中（将字符串对象转换成字节数组）
        //97 98 99 100 101 102
        byte[] bytes = "abcdef".getBytes();
        for (int i = 0; i <bytes.length ; i++) {
            System.out.print(bytes[i] + " ");
        }
        System.out.println();

        //8、int indexOf(String str)
        //返回指定 子字符串第一次出现在当前字符串内的索引。没找到则返回-1
        System.out.println("oracle.java.c++.net.c#".indexOf(".java")); //6

        //9、boolean isEmpty()
        //判断某个字符串是否为空字符串 空为true,否则为false
        //底层调用的应该是字符串的length()方法, length()为0时返回true
        System.out.println("".isEmpty()); //true
        System.out.println("0".isEmpty()); //false

        //10、int length()
        //面试题：判断数组长度和判断字符串长度不一样
        //判断数组长度是length属性,判断字符串长度是length()方法
        int[] arr = new int[3];
        System.out.println(arr.length); //3
        System.out.println("abc".length()); //3
        //空字符串
        System.out.println("".length()); //0

        //11、int lastIndexOf(String str)
        //返回指定子字符串最后一次出现的字符串中的索引。
        System.out.println("oracle.java.c++.net.c#.java.python".lastIndexOf(".java")); //22

        //12、String replace(CharSequence target, CharSequence replacement)
        //替换
        // String的父类的接口就是：CharSequence
        String newString = "http://www.baidu.com".replace("http://","https://");
        System.out.println(newString); //https://www.baidu.com
        String newString2 = "name=zhangsan password=123 age=20".replace("=","：");
        System.out.println(newString2); //name：zhangsan password：123 age：20

        //13、String[] split(String regex)
        //拆分字符串
        //1999 09 05
        String[] ymd = "1999-09-05".split("-"); //"1999-09-05" 以 "-"作为分隔符进行拆分
        for (int i = 0; i <ymd.length ; i++) {
            System.out.print(ymd[i] + " ");
        }
        System.out.println();
        //如果有特殊字符,需要加入转义符
        // E: aaa bbb
        String[] split = "E:\\aaa\\bbb".split("\\\\"); //以"\\"作为分隔符
        for (int i = 0; i <split.length ; i++) {
            System.out.print(split[i] + " ");
        }
        System.out.println();
        //14、boolean startsWith(String prefix)
        //测试此字符串是否以指定的前缀开头。
        System.out.println("http://www.baidu.com".startsWith("http")); //true
        System.out.println("http://www.baidu.com".startsWith("https")); //false

        //15、String substring(int beginIndex)
        //截取字符串
        System.out.println("http://www.baidu.com".substring(7)); //www.baidu.com

        //16、String substring(int beginIndex, int endIndex)
        //int beginIndex起始位置（包括）
        //int endIndex结束位置（不包括）
        System.out.println("http://www.baidu.com".substring(7,10)); //www

        //17、char[] toCharArray()
        //将此字符串转换为新的字符数组。
        //我 是 中 国 人
        char[] chars = "我是中国人".toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            System.out.print(chars[i] + " ");
        }
        System.out.println();

        //18、String toLowerCase()
        //转换成小写
        System.out.println("ABCdEfgHiJkLmn".toLowerCase()); //abcdefghijklmn

        //19、String toUpperCase()
        //转换成大写
        System.out.println("ABCdEfgHiJkLmn".toUpperCase()); //ABCDEFGHIJKLMN

        //20、String trim()
        //返回一个字符串，其值为此字符串，并删除任何前导和尾随空格。
        System.out.println("    Hello   World    ".trim()); //Hello   World

        //21、static String valueOf()
        //将非字符串转换为字符串
        //String中只有一个方法是静态的,不需要new对象,就是valueOf()
        /*
        String s1 = String.valueOf(true);
        String s2 = String.valueOf(100);
        String s3 = String.valueOf(3.14);
        System.out.println(s1); //true
        System.out.println(s2); //100
        System.out.println(s3); //3.14
        */
        String s4 = String.valueOf(new Customer());
        //System.out.println(s4); // 没有重写toString()方法 : String.Customer@14ae5a5
        System.out.println(s4); //重写了toString()方法 : 我是一个vip客户

        //我们是不是可以研究一下println()方法的源代码了
        System.out.println(100);
        Object obj = new Object();
        //通过源代码可以看出为什么输出一个引用的时候会自动调用toString()方法
        //本质上System.out.println();这个方法在输出任何数据的时候都是先转换成字符串,在输出.
        System.out.println(obj);

        //22 String concat 拼接字符串
        String s5 = "宝玉";
        s5 = s5.concat("林黛玉").concat("薛宝钗").concat("together");
        System.out.println(s5);

        //23.String format() 格式字符串
        //占位符有: %s(String) %c(char) %d(整型) %.2f(浮点型)
        //例题: 将下面信息拼接成一个字符串
        //要求输出:
        String name = "john";
        int age = 18;
        double score = 56.423;
        char sex = '男';
        String formatStr = "我的姓名是%s 年龄是%d 成绩是%.2f 性别是%c 希望大家喜欢我!";
        
        String info = String.format(formatStr,name,age,score,sex);
        System.out.println(info);
    }
}

class Customer {
    public String toString(){
        return "我是一个vip客户";
    }

}