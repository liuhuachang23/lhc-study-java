package hsp.chapter11.enum_;
/*
1、不需要通过set方法，因为枚举对象值通常为只读
2、对枚举对象/属性使用 final static 共同修饰，实现底层优化
3、枚举对象名通常使用全部大写（常量名的规范）
4、枚举对象根据需要，也可以有多个属性

演示自定义枚举实现
    步骤：
    1）将构造器私有化
    2）去掉set方法,防止属性被修改
    3）在Season内部,直接创建对象
    4）优化，可以加入 final 修饰，实现底层优化
*/

public class Enumeration01 {
    public static void main(String[] args) {
        System.out.println(Season1.AUTUMN);
    }

}

class Season1 {

    private String name;
    private String desc;

    //定义了1个对象
    //public static Season1 SPRING = new Season1("春天", "温暖");
    //加final修饰,优化代码
    public static final Season1 SPRING = new Season1("春天", "温暖");
    public static final Season1 WINTER = new Season1("冬天", "寒冷");
    public static final Season1 AUTUMN = new Season1("秋天", "凉爽");
    public static final Season1 SUMMER = new Season1("夏天", "炎热");

    private Season1(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season2{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
