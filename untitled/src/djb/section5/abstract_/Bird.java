package djb.section5.abstract_;

class Bird extends Animal{

    //一个非抽象类继承一个抽象类，必须将抽象类中的抽象方法实现（覆盖/重写）。
    public void move() {
        System.out.println("鸟儿在飞翔");
    }
}

