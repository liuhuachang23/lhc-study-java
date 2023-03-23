package hsp.chapter11.enum_;

public class EnumExercise02 {
    public static void main(String[] args) {
        Week monday = Week.MONDAY;
        //toString：Enum类已经重写过了，返回的是当前对象名。（子类也可以重写toString，用于返回对象的属性信息）
        System.out.println(monday);
        System.out.println(monday.name());
        System.out.println(monday.ordinal());
        Week week1 = Week.valueOf("MONDAY");
        System.out.println(week1);
        System.out.println("=========================");
        Week[] values = Week.values();
        for (Week week : values) {
            System.out.println(week);
        }

    }
}

enum Week{

    MONDAY("星期一"),TUESDAY("星期二"),WEDNESDAY("星期三"),THURSDAY("星期四"),
    FRIDAY("星期五"),SATURDAY("星期六"),SUNDAY("星期日");

    private String weekday;

    private Week(String weekday) {
        this.weekday = weekday;
    }

    public String getWeekday() {
        return weekday;
    }

    @Override
    public String toString() {
        return weekday;
    }
}
