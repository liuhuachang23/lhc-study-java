package com.lhc.mhl.domain;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/12 10:24 星期四
 * @Operating:
 * @Description: 餐桌类（JavaBan），对应数据库中的 diningTable表
 */
public class DiningTable {

    private Integer id;             //餐桌编号
    private String state;           //餐桌状态
    private String orderName;       //预定人名字
    private String orderTel;        //预定人电话

    public DiningTable() { //反射需要
    }

    /*public DiningTable(Integer id, String state, String orderName, String orderTel) {
        this.id = id;
        this.state = state;
        this.orderName = orderName;
        this.orderTel = orderTel;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderTel() {
        return orderTel;
    }

    public void setOrderTel(String orderTel) {
        this.orderTel = orderTel;
    }

}
