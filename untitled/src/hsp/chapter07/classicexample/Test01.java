package hsp.chapter07.classicexample;
/*
* 某小伙想定一份外卖，商家的优惠方式如下：鱼香肉丝单点24元，
* 油炸花生米单点8元，米饭单点3元。订单满30元8折优惠。鱼香
* 肉丝优惠价16元，但是优惠价和折扣不能同时使用。那么这个小
* 伙要点这三样东西，最少要花多少钱？
* */
public class Test01 {
    public static void main(String[] args) {
        //计算不使用优惠卷的价格
        double money1 = 24 + 8 + 3;
        //判断折后总价
        money1 = money1 >= 30 ? money1 * 0.8 : money1;
        //使用优惠卷的价格
        double money2 = 16 + 8 + 3;
        //判断哪个选择最优
        double money = money1 > money2 ? money2 : money1;
        //打印最终消费结果
        System.out.println(money);

    }
}
