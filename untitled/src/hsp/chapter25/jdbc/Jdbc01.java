package hsp.chapter25.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/5 19:01 星期四
 * @Operating： lhc_db01数据库中 actor表
 * @Description: JDBC 第一个程序
 */
public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        //前置工作：在项目下创建一个文件夹(libs)
        //将 mysql.jar 拷贝到该目录下，右键点击 add as Library （导入到项目中）
        //1. 注册驱动
        Driver driver = new Driver(); // 创建driver对象

        //2. 获取连接
        //2.1 数据库地址
        /*
            解读：
            (1) jdbc:mysql://  规定好的表示协议，通过jdbc的方式连接mysql
            (2) localhost 主机，也可以是 ip地址
            (3) 3306 表示监听的端口
            (4) lhc_db01 表示连接到 mysql dbms 的 lhc_db01数据库
            (5) mysql连接的本质就是之前学的socket连接
         */
        String url = "jdbc:mysql://localhost:3306/lhc_db01";
        //2.2 写入数据库的用户名和密码，放入到Properties对象中
        Properties properties = new Properties();
        properties.setProperty("user","root"); //用户名
        properties.setProperty("password","lhc"); //密码
        //2.3 连接
        Connection connect = driver.connect(url, properties);

        //3. 组织sql语句
        //String sql = "insert into actor values(null, '刘德华', '男', '1970-11-11', '100')";
        //String sql = "delete from actor where id = 2";
        String sql = "update actor set name = '周星驰' where id = 1";

        //4. 得到一个statement
        Statement statement = connect.createStatement();
        //5. 调用 executeUpdate() 执行sql语句(dml语句) 并返回数据库(表)影响的行数
        int rows = statement.executeUpdate(sql);
        System.out.println(rows > 0 ? "成功" : "失败");

        //6. 释放连接
        statement.close();
        connect.close();
    }
}
