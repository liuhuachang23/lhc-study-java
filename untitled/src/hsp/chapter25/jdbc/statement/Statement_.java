package hsp.chapter25.jdbc.statement;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/6 15:14 星期五
 * @Description: 演示 statement 注入问题：
 * 不管你是设置什么样的用户名和密码，利用statement的注入问题，输入以下，就可以直接访问数据库
 * 输入管理员名字： 1' or
 * 输入万能密码： or '1'= '1
 */
public class Statement_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        Scanner scanner = new Scanner(System.in);

        //让用户输入管理员名和密码
        System.out.println("请输入管理员的名字：");
        //说明：如果希望看到注入效果，这里需要使用nextLine() 替换next()
        //因为next() 在控制台输入 空格 或者'  会认为输入完毕
        //nextLine() 是按 换行回车 才认为输入完毕
        String admin_name = scanner.nextLine();
        System.out.println("请输入管理员的密码：");
        String admin_pwd = scanner.nextLine();

        //1. 通过Properties对象获取配置文件信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\hsp\\chapter25\\jdbc\\mysql.properties"));
        //获取相关的值
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        //2.注册驱动
        Class<?> aClass = Class.forName(driver);
        //3. 获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        //4. 得到Statement
        Statement statement = connection.createStatement();
        //5. 组织sql语句（利用statement的注入问题,组织这样的sql语句）
        //填入 "万能管理员名"和"万能密码" 后，sql语句就变成：
        // select name, pwd from admin where `name` ='1' OR ' and pwd = ' OR '1'= '1'
        // '1'= '1'永远成立，这样就可以直接访问数据库(表)的信息
        String sql = "select name, pwd from admin where `name` ='" + admin_name + "' and pwd = '" + admin_pwd + "'";

        //6. 使用Statement.executeQuery(sql) 查询
        ResultSet resultSet = statement.executeQuery(sql);
        //7. 验证
        //resultSet.next()=true 表示存在下一条记录，说明键盘输入的 admin_name 和 admin_pwd 是正确的
        if (resultSet.next()){
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

        //关闭连接
        statement.close();
        resultSet.close();
        connection.close();
    }
}
