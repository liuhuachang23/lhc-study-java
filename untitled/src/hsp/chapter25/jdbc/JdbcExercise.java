package hsp.chapter25.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/6 8:32 星期五
 * @Operating： lhc_db01数据库 中news表
 * @Description: 练习使用方式5完成 对 lhc_db01数据库中news表 的操作
 */
@SuppressWarnings({"all"})
public class JdbcExercise {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        //1. 通过Properties对象获取配置文件信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\hsp\\chapter25\\jdbc\\mysql.properties"));
        //获取相关的值
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        //2. 注册驱动
        Class<?> aClass = Class.forName(driver);
        //3. 获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        //4. 得到一个 statement
        Statement statement = connection.createStatement();

        //5. 组织sql语句
        //添加记录
        //String sql = "insert into news values(null, '江西早报', '2022-05-05 08:00:00')";
        //String sql = "insert into news values(null, '上海早报', '2022-05-05 09:00:00')";
        //String sql = "insert into news values(null, '北京早报', '2022-05-05 08:30:00')";
        //String sql = "insert into news values(null, '湖南早报', '2022-05-05 07:30:00')";
        //String sql = "insert into news values(null, '广东早报', '2022-05-05 09:30:00')";
        //修改记录
        //String sql = "update news set content = '山东新闻' where id = 2 ";
        //删除记录
        String sql = "delete from news where id = 3";

        //6. 执行 sql语句
        // executeUpdate(sql) 执行静态sql语句(dml) 并返回数据库生效的行数
        int rows = statement.executeUpdate(sql);

        //判断执行是否成功
        System.out.println(rows > 0 ? "成功" : "失败");

        //4. 释放连接
        statement.close();
        connection.close();

    }
}
