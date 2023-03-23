package djb.section5.接口.Test05;

public class ChinaCooker implements FoodMenu{

    //一个非抽象类继承一个抽象类，必须将抽象类中的抽象方法进行实现（覆盖/重写）
    public void pizza() {

    }

    public void steak() {

    }

    //西红柿炒鸡蛋
    public void xiHongShiChaoJiDan(){
        System.out.println("中餐师傅做的西红柿炒鸡蛋");
    }

    //鱼香肉丝
    public void yuXiangRouSi(){
        System.out.println("中餐师傅做的鱼香肉丝");
    }

}
