package hsp.chapter08.recursion;
//使用递归：汉诺塔
public class Test03 {
    public static void main(String[] args) {
        Tower tower = new Tower();
        tower.move(3, 'A', 'B', 'C');
    }
}

class Tower {
    //方法
    //num 表示要移动的个数，a，b，c 分别表示A塔，B塔，C塔
    public void move(int num, char a, char b, char c){
        if (num == 1){
            System.out.println(a + "-->" + c);
        } else {
            move(num-1, a, c, b);
            System.out.println(a + "-->" + c);
            move(num-1, b, a, c);
        }
    }
}
