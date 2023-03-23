package djb.section5.接口.Test05;

public class AmericCooker implements FoodMenu {

    //一个非抽象类继承一个抽象类，必须将抽象类中的抽象方法进行实现（覆盖/重写）
    public void xiHongShiChaoJiDan() {

    }

    public void yuXiangRouSi() {

    }

    //披萨
    public void pizza(){
        System.out.println("西餐师傅做的披萨");
    }

    public void steak(){
        System.out.println("西餐师傅做的牛排");
    }
}
