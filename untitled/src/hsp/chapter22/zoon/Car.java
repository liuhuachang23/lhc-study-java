package hsp.chapter22.zoon;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/21 09:24
 * @Description:
 */
public class Car {
    public String brand = "保时捷";
    public int price = 2900000;
    public String color = "黑色";

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
