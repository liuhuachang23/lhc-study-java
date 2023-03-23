package com.lhc.mhl.service;

import com.lhc.mhl.dao.EmployeeDAO;
import com.lhc.mhl.domain.Employee;

import java.util.List;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/11 21:19 星期三
 * @Operating:
 * @Description: Employee业务类
 * 通过调用EmployeeDAO对象，完成对employee表的操作
 */
public class EmployeeService {

    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private LoginService loginService = new LoginService();

    //通过员工号查询员工所有信息
    public Employee infoOfEmp(String empId) {
        return employeeDAO.querySingle("select * from employee where empId = ?",
                Employee.class, empId);
    }

    //通过员工号查询员工职位
    public Object getJob(String empId) {
        return employeeDAO.queryScalar("select job from employee where empId = ?", empId);
    }

    //显示所有员工信息
    public List<Employee> allEmployee(){
        return employeeDAO.queryMulti("select * from employee",Employee.class);
    }

    //招聘员工
    public boolean addEmployee(String empId, String pwd, String name, String job){
        //更新员工表
        int update = employeeDAO.update("insert into employee values(null,?, md5(?),?,?)"
                ,empId,pwd,name,job);
        if (update <= 0){
            return false;
        }
        //更新登录表
        return loginService.addLogin(empId, pwd);
    }

    //通过员工编号开除员工
    public boolean deleteEmployee(String empId){
        //更新员工表
        int update = employeeDAO.update("delete from employee where empId = ?", empId);
        if (update <= 0){
            return false;
        }
        //更新登录表
        return loginService.deleteLogin(empId);
    }

}
