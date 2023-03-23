package com.lhc.mhl.domain;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/12 14:25 星期四
 * @Operating:
 * @Description: 菜谱类（JavaBean），对应数据库中的 menu表
 */
public class Menu {

    private Integer id;
    private String name;
    private String type;
    private double price;

    public Menu() { //反射需要
    }

   /* public Menu(Integer id, String name, String type, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
