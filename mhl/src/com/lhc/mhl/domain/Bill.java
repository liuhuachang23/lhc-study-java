package com.lhc.mhl.domain;

import java.util.Date;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/12 15:51 星期四
 * @Operating:
 * @Description: 账单类（JavaBan），对应数据库中的 bill表
 */
public class Bill {
    private Integer id;                 //id
    private String billId;              //账单编号
    private Integer menuId;             //菜品编号
    private Integer nums;                //份数
    private double money;               //金额
    private Integer diningTableId;      //餐桌编号
    private Date billDate;              //订单日期
    private String state;               //账单状态

    public Bill() { //反射需要
    }

    /*public Bill(Integer id, String billId, Integer menuId, Integer nums, double money, Integer diningTableId, Date billDate, String state) {
        this.id = id;
        this.billId = billId;
        this.menuId = menuId;
        this.nums = nums;
        this.money = money;
        this.diningTableId = diningTableId;
        this.billDate = billDate;
        this.state = state;
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

    @Override
    public String toString() {
        return getId() + "\t\t" +
                getMenuId() + "\t\t" +
                getNums() + "\t\t" +
                getMoney() + "\t\t" +
                getDiningTableId() + "\t\t" +
                getBillDate() + "\t\t" +
                getState();
    }
}
