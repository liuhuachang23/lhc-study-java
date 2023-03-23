package hsp.chapter12.stringbuffer;

//StringBuffer常用方法

public class StringBufferMethod {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("hello");

        //增
        s.append(',');
        s.append("张三丰");
        s.append("赵敏").append(100).append(true).append(10.5);
        System.out.println(s); //hello,张三丰赵敏100true10.5

        //删
        //删除索引为 >=start && <end 即[11,14)处的字符
        s.delete(11, 14);
        System.out.println(s); //hello,张三丰赵敏true10.5

        //改
        //修改:使用 周芷若 替换索引[9,11)的字符
        s.replace(9, 11, "周芷若");
        System.out.println(s); //hello,张三丰周芷若true10.5

        //查
        //查找指定的子串再字符串第一次出现的索引，如果找不到，则返回-1
        int indexOf = s.indexOf("张三丰");
        System.out.println(indexOf); //6

        //插入
        //再索引为9的位置插入"赵敏",后面的字符自动后移
        s.insert(9, "赵敏");
        System.out.println(s); //hello,张三丰赵敏周芷若true10.5

        //长度
        System.out.println(s.length()); //22
        System.out.println(s); //hello,张三丰赵敏周芷若true10.5

    }
}
