package djb.section5.接口.Test05;

public class Customer {

    //顾客有一个菜单
    private FoodMenu foodMenu;

    //构造函数
    public Customer(){
    }

    public Customer(FoodMenu foodMenu) {
        this.foodMenu = foodMenu;
    }

    //getter and setter
    public FoodMenu getFoodMenu() {
        return foodMenu;
    }

    public void setFoodMenu(FoodMenu foodMenu) {
        this.foodMenu = foodMenu;
    }

    //点菜方法
    public void order() {
        this.getFoodMenu().pizza();
        this.getFoodMenu().steak();
        this.getFoodMenu().xiHongShiChaoJiDan();
        this.getFoodMenu().yuXiangRouSi();
    }

}
