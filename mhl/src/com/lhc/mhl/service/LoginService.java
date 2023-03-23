package com.lhc.mhl.service;

import com.lhc.mhl.dao.LoginDAO;
import com.lhc.mhl.domain.Login;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/13 15:34 星期五
 * @Operating:
 * @Description:
 */
public class LoginService {

    private LoginDAO loginDAO = new LoginDAO();

    //通过传入的 用户名和密码 查询Login表中是否存在该员工
    public Login checkLogin(String empId, String pwd) {
        return loginDAO.querySingle("select * from employee where empId = ? and pwd = MD5(?)",
                Login.class, empId, pwd);
    }

    //招聘员工
    public boolean addLogin(String empId, String pwd){
        int update = loginDAO.update("insert into login values(?,md5(?))"
                ,empId,pwd);
        return update > 0;
    }

    //通过员工编号开除员工
    public boolean deleteLogin(String empId){
        int update = loginDAO.update("delete from login where empId = ?", empId);
       return update > 0;
    }
}
