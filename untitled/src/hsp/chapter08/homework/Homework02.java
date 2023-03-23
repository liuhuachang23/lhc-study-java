package hsp.chapter08.homework;

//编写类A02，定义方法find，实现查找某字符串数组中的元素查找
//并返回索引，如果找不到，返回-1
public class Homework02 {
    public static void main(String[] args) {
        //静态初始化一个字符串数组
        String[] str = {"abc", "def" , "qwe" , "rel"};

        //创建对象
        A02 a = new A02();

        int index = a.find(str, "abd");
        if (index >= 0){
            System.out.println("查找的字符串的下标为: " + index);
        } else if (index == -1){
            System.out.println("数组中不存在该字符串");
        }
    }
}

class A02{
    public int find(String[] str, String strings){

        for (int i = 0; i <str.length ; i++) {
            if (strings.equals(str[i])) {
                return i;
            }
        }
        return -1;
    }
}
