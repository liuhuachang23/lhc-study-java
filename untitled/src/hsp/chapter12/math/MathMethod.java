package hsp.chapter12.math;

//Math常用的方法
public class MathMethod {
    public static void main(String[] args) {
        //1.abs 绝对值
        int abs = Math.abs(-9);
        System.out.println(abs);

        //2.pow 求幂
        double pow = Math.pow(-2, 4);
        System.out.println(pow);

        //3.ceil 向上取整 用double接收(底层代码返回的double类型)
        double ceil = Math.ceil(-2.3);
        System.out.println(ceil);

        //4.floor 向下取整 用double接收(底层代码返回的double类型)
        double floor = Math.floor(2.33);
        System.out.println(floor);

        //5.round 四舍五入
        double round = Math.round(2.34);
        System.out.println(round);

        //6.sqrt 求开方
        double sqrt = Math.sqrt(2);
        System.out.println(sqrt);

        //7.random 求随机数 返回的是[0,1)的随机数
        double random = Math.random();

        //random思考题:打印10个 2~7 的随机整数
        //思路: (int)[2~8)
        for (int i = 0; i < 10; i++) {
            System.out.println((int) (2 + Math.random() * 6));
        }

        //8. max、min 返回两个数中的最大值、最小值
        int max = Math.max(20, 30);
        int min = Math.min(20, 30);

    }
}
