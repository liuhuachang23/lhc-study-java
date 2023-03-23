package com.lhc.mhl.domain;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/11 20:59 星期三
 * @Operating:
 * @Description: 员工类（JavaBan），对应数据库中的 employee表
 */
public class Employee {
    private Integer id;         //id
    private String empId;       //员工号
    private String pwd;         //密码
    private String name;        //姓名
    private String job;         //职位

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return getId() + "\t\t" + getEmpId() + "\t\t" + getName() + "\t\t\t" + getJob();
    }
}
