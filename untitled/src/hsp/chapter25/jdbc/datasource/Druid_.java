package hsp.chapter25.jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;


import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/8 15:54 星期日
 * @Operating:
 * @Description: 演示 Druid的使用
 */
public class Druid_ {

    @Test
    public void testDruid_01() throws Exception {

        //1. 加入 Druid jar包
        //2. 加入配置文件 druid.properties

        //3. 创建Properties对象，读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties"));

        //4. 创建一个指定参数的数据库连接池, Druid连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //5. 连接
        //测试连接50000次数据库
        long start = System.currentTimeMillis();
        for (int i = 0; i <5000000 ; i++) {
            Connection connection = dataSource.getConnection();
            //关闭连接（不是真正的关闭，而是返回到连接池中）
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("使用Druid连接池 连接500000从数据库 耗时：" + (end - start)); //412
    }
}
