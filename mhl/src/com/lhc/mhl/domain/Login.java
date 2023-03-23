package com.lhc.mhl.domain;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/13 15:26 星期五
 * @Operating:
 * @Description: 完成登录验证
 */
public class Login {
    private String empId;   //员工号
    private String pwd;     //密码

    public Login() {
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
}
