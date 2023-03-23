package com.lhc.mhl.domain;

import java.util.Date;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/13 14:15 星期五
 * @Operating:
 * @Description: MultiTable多表类（JavaBean） 和 多张表对应
 */
public class MultiTable {

    //来自bill表
    private Integer id;                 //id
    private String billId;              //账单编号
    private Integer menuId;             //菜品编号
    private Integer nums;                //份数
    private double money;               //金额
    private Integer diningTableId;      //餐桌编号
    private Date billDate;              //订单日期
    private String state;               //账单状态
    //来自menu表
    private String name;                //菜品名称
    private double price;               //菜品价格

    public MultiTable() { //反射需要
    }

    /*public MultiTable(Integer id, String billId, Integer menuId, Integer nums, double money, Integer diningTableId, Date billDate, String state, String name, double price) {
        this.id = id;
        this.billId = billId;
        this.menuId = menuId;
        this.nums = nums;
        this.money = money;
        this.diningTableId = diningTableId;
        this.billDate = billDate;
        this.state = state;
        this.name = name;
        this.price = price;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer num) {
        this.nums = num;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Integer getDiningTableId() {
        return diningTableId;
    }

    public void setDiningTableId(Integer diningTableId) {
        this.diningTableId = diningTableId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getId() + "\t\t" +
                getDiningTableId() + "\t\t" +
                getMenuId() + "\t\t" +
                getName() + "\t\t" +
                getPrice() + "\t\t" +
                getNums() + "\t\t" +
                getBillDate() + "\t\t" +
                getMoney() + "\t\t" +
                getState();
    }
}
