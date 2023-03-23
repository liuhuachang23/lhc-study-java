package hsp.chapter25.jdbc.preparedstatement;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/7 16:07 星期六
 * @Operating： lhc_db01数据库中 admin表
 * @Description: 使用预处理 执行dml语句
 */
@SuppressWarnings({"all"})
public class PreparedStatement01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        Scanner scanner = new Scanner(System.in);
        //接收用户输入
        System.out.println("请输入管理员的名字：");
        String admin_name = scanner.nextLine();
        //System.out.println("请输入管理员的新密码：");
        //String admin_pwd = scanner.nextLine();

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


        //4 组织sql语句（使用占位符）
        //4.1 添加记录
        //String sql = "insert into admin values(?,?)";
        //4.2 修改记录
        //String sql = "update admin set pwd = ? where name = ?";
        //4.3 删除记录
        String sql = "delete from admin where name = ?";

        //5. 得到PrepaerStatement
        //5.1 preparedSatement对象 实现了 PreparedStatement接口
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //5.2 给？ 赋值
        //preparedStatement.setString(1, admin_pwd);
        preparedStatement.setString(1, admin_name);

        //6 执行qsl语句（select语句使用excuteQuery，dml语句使用executeUpdate）
        int rows = preparedStatement.executeUpdate();
        System.out.println(rows > 0 ? "执行成功" : "执行失败");

        //关闭连接
        preparedStatement.close();
        connection.close();
    }
}
