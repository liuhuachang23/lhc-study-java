package hsp.chapter25.jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/8 16:17 星期日
 * @Operating:
 * @Description: 基于 Druid数据连接池的工具类
 */
public class JDBCUtilsByDruid {
    private static DataSource ds;

    //在静态代码块完成 ds初始化
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            //将编译异常，转换为运行异常
            throw new RuntimeException(e);
        }
    }

    // 编写getConnection方法
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    //关闭连接方法（不是真正的关闭连接，只是将connection 放回到连接池）
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            //将编译异常，转换为运行异常
            throw new RuntimeException(e);
        }
    }

}
