package hsp.chapter22.zoon;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/20 15:44
 * @Description:
 */
public class Cat {

    private String name = "招财猫";
    public int age = 2;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public void hi(String s) {
        System.out.println("hi " + name);
    }

    public void cry() {
        System.out.println(name + " 喵喵叫...");
    }

    public void play() {

    }

}
