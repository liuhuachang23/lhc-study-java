package hsp.chapter11.enum_;

/*
Season2 枚举类，在控制台上反编译：javap Season2.class
Compiled from "Enumeration02.java"
final class hsp.chapter11.enum_.Season2 extends java.lang.Enum<hsp.chapter11.enum_.Season2> {
    public static final hsp.chapter11.enum_.Season2 SPRING;
    public static final hsp.chapter11.enum_.Season2 WINTER;
    public static final hsp.chapter11.enum_.Season2 AUTUMN;
    public static final hsp.chapter11.enum_.Season2 SUMMER;
    public static final hsp.chapter11.enum_.Season2 WHAT;
    public static hsp.chapter11.enum_.Season2[] values();
    public static hsp.chapter11.enum_.Season2 valueOf(java.lang.String);
    public java.lang.String getName();
    public java.lang.String getDesc();
    public java.lang.String toString();
    static {};
}*/


public class Enumeration02 {
    public static void main(String[] args) {
        System.out.println(Season2.AUTUMN);

    }
}

//1.class替换为enum (枚举类)
enum Season2 {
    //1.当我们使用enum关键字开发一个枚举类时，默认会继承Enum类，enum是一个final类，所以enum类不能被继承(我们可以用 javap 工具来演示)
    //2.public static final Season2 SPRING = new Season2("春天","温暖") 用 SPRING("春天","温暖") 代替
    // 常量名 (实参列表)
    //注意:
    // 1)多个常量对象用逗号隔开
    // 2)将定义常量对象,写在前面
    SPRING("春天", "温暖"), WINTER("冬天", "寒冷"),
    AUTUMN("秋天", "凉爽"), SUMMER("夏天", "炎热"),
    // 3)如果我们是使用无参构造器,创建常量对象,()可以省略
    WHAT(); //可以写为 WHAT;

    private String name;
    private String desc;

    private Season2() {
    }

    private Season2(String name, String desc) {
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
