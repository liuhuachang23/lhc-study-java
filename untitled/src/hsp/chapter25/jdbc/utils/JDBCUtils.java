package hsp.chapter25.jdbc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/7 18:44 星期六
 * @Description: 工具类，完成 mysql连接和关闭相关资源
 */
public class JDBCUtils {

    //定义相关属性
    private static String user; //数据库用户名
    private static String password; //数据库密码
    private static String url; //数据库位置
    private static String driver; //驱动名

    //在static代码块中完成初始化
    static {
        Properties properties = new Properties();
        try {
            //读取配置文件
            properties.load(new FileInputStream("src\\hsp\\chapter25\\jdbc\\mysql.properties"));
            //读取数据，给相关属性赋值
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            //在实际开发中，我们可以这样处理
            //1. 将编译异常转换为运行异常
            //2. 这时调用者可以选择捕获该异常，也可以选择默认处理，比较方便
            throw new RuntimeException(e);
        }
    }

    //连接数据库，返回Connection
    public static Connection getConnection() {
        try {

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            //在实际开发中，我们可以这样处理
            //1. 将编译异常转换为运行异常
            //2. 这时调用者可以选择捕获该异常，也可以选择默认处理，比较方便
            throw new RuntimeException(e);
        }
    }


    /**
     * 关闭资源
     *
     * @param set        结果集
     * @param statement  Statement 或者 PreparedStatement
     * @param connection 连接
     */
    public static void close(ResultSet set, Statement statement, Connection connection) {

        //如果调用者转来的参数为空则表示不需要关闭
        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            //在实际开发中，我们可以这样处理
            //1. 将编译异常转换为运行异常
            //2. 这时调用者可以选择捕获该异常，也可以选择默认处理，比较方便
            throw new RuntimeException(e);
        }
    }
}
