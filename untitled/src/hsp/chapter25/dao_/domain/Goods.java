package hsp.chapter25.dao_.domain;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/11 16:20 星期三
 * @Operating:
 * @Description:
 */
public class Goods {

    private int id;
    private String goods_name;
    private double price;

    public Goods() {
    }

    public Goods(int id, String goods_name, double price) {
        this.id = id;
        this.goods_name = goods_name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goods_name='" + goods_name + '\'' +
                ", price=" + price +
                '}';
    }
}
