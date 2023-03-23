package hsp.chapter27.homework;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/17 14:42 星期二
 * @Operating:
 * @Description: 验证是不是整数或者小数，考虑正数和负数,并且不能写不符合常理的数 比如 -001.1 或者 0.100
 */
public class Homework02 {
    public static void main(String[] args) {

        String content = "-0.01";
        String regStr = "^[-+]?([1-9]\\d*|0)(\\.\\d*[1-9])?$";
        //
        //使用matches判断
        //整体匹配，可以不加定位符
        if (content.matches(regStr) ){
            System.out.println("满足格式");
        } else {
            System.out.println("不满足格式");
        }

    }
}
