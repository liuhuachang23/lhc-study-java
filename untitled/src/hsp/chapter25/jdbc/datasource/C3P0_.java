package hsp.chapter25.jdbc.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;


import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/8 14:28 星期日
 * @Operating: lhc_db01
 * @Description: 演示C3PO的使用
 */
@SuppressWarnings({"all"})
public class C3P0_ {

    // 加入 C3P0 jar包

    //方式一：相关参数，在程序中指定user、url、password、driver等
    @Test
    public void testC3P0_01() throws IOException, PropertyVetoException, SQLException {
        //1. 创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //2. 通过配置文件 获取相关信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\hsp\\chapter25\\jdbc\\mysql.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        //3. 给数据源 comboPooledDataSource 设置相关的参数
        //因为，连接数据库是由 comboPooledDataSource 来管理
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        //4. 设置连接数
        //初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //最大连接数
        comboPooledDataSource.setMaxPoolSize(50);

        //连接
        //getConnection()方法就是从 DataSource 接口实现的
        //测试C3P0 连接池的效率，连接5000次
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            //关闭连接（不是真正的关闭，而是返回到连接池中）
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("C3P0 连接数据库5000次 耗时：" + (end - start)); //429ms
    }


    //方式二：使用配置文件模板来完成
    @Test
    public void testC3P0_02() throws SQLException {

        //1. 将C3P0提供的 c3p0.config.xml 拷贝到 src目录下
        //   该文件指定了连接数据库和连接池的相关参数

        //2. 创建一个数据源对象,将数据源（c3p0.config.xml）的名称填入
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("lhc_pool");

        //3. 连接/
        //测试C3P0 连接池的效率，连接500000次
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            //关闭连接（不是真正的关闭，而是返回到连接池中）
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("C3P0 连接数据库500000次 耗时：" + (end - start)); //2009
    }
}
