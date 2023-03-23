package hsp.chapter25.jdbc.preparedstatement;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/6 18:01 星期五
 * @Operating： lhc_db01数据库中 admin表
 * @Description: 演示 PreparedStatement 使用
 * 测试：
 * 输入管理员名字： 1' or
 * 输入万能密码： or '1'= '1
 * 登录失败，这个就解决了sql注入问题
 */
@SuppressWarnings({"all"})
public class PreparedStatement_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        //看看 PreparedStatement类图
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

        //4. 得到PrepaerStatement
        //4.1 组织sql语句（使用占位符）
        String sql = "select name, pwd from admin where name = ? and pwd = ?";
        //4.2 preparedSatement对象 实现了 PreparedStatement接口
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //4.3 给？ 赋值
        preparedStatement.setString(1, admin_name);
        preparedStatement.setString(2, admin_pwd);
        //5 执行qsl语句（select语句使用excuteQuery，dml语句使用executeUpdate）
        ResultSet resultSet = preparedStatement.executeQuery();

        //7. 验证
        //resultSet.next()=true 表示存在下一条记录，说明键盘输入的 admin_name 和 admin_pwd 是正确的
        if (resultSet.next()){
            System.out.println("恭喜登录成功！");
        } else {
            System.out.println("登录失败~");
        }

        //关闭连接
        preparedStatement.close();
        resultSet.close();
        connection.close();
    }
}
