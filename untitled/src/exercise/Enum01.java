package exercise;

/**
 * @Author: 刘华昌
 * @DATE: 2022/7/5 11:16 星期二
 * @Operating:
 * @Description:
 */
public class Enum01 {

    public static void main(String[] args) {

        Week[] values = Week.values();
        for (Week week :values) {
            System.out.println(week);
        }

    }

}

enum Week{

    MONDAY(1,"星期一"),TUESDAY(2,"星期二"),WEDNESDAY(3,"星期三"),THURSDAY(4,"星期四"),
    FRIDAY(5,"星期五"),SATURDAY(6,"星期六"),SUNDAY(7,"星期日");

    private int i;
    private String weekday;

    Week(int i, String weekday) {
        this.i = i;
        this.weekday = weekday;
    }

    @Override
    public String toString() {
        return "Week[" + i +", "+ weekday +"]";
    }
}