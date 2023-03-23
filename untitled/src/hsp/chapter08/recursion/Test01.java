package hsp.chapter08.recursion;
/*
使用递归方法：猴子吃桃
    有一堆桃，第一天猴子吃了其中的一半还多吃了一个，第二天又是多次了其中的一半又多吃了一个，
    以后每天都是这样当到第10天时（还没吃），发现只剩下一个桃子了
    问：原本有多少个桃？

思路分析
    day = 10 时 有1个桃子
    day = 9 时 有 （day10 + 1）*2 = 4 个桃子。
    前一天的桃子数 = （当天的桃子 + 1）*2
*/
public class Test01 {
    public static void main(String[] args) {

        Monkey monkey = new Monkey();
        int peachNum = monkey.peach(1);
        if (peachNum != -1){
            System.out.println("第1天有 " + peachNum + " 个桃");
        }
    }
}

class Monkey{
    public int peach(int day){
        if (day == 10){
            return 1;
        }
        if (day >= 1 && day < 10){
            return (peach(day + 1) + 1) * 2;
        } else {
            System.out.println("day=1~10");
            return -1;
        }
    }
}
