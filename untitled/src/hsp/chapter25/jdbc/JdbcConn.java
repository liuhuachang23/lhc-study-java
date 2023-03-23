package hsp.chapter25.jdbc;

import com.mysql.jdbc.Driver;
import org.junit.Test;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/5 20:26 星期四
 * @Operating： lhc_db01数据库
 * @Description: 分析java 连接mysql 的5种方式
 */
public class JdbcConn {

    //方式1
    @Test
    public void connect01() throws SQLException {
        //1. 注册驱动 (直接创建 Driver)
        Driver driver = new Driver();
        //2. 获取连接
        String url = "jdbc:mysql://localhost:3306/lhc_db01";
        //将用户名和密码放入到Properties对象中
        Properties properties = new Properties();
        //说明：user 和 password 是规定好的，后面的值 填入正确的即可
        properties.setProperty("user","root"); //用户名
        properties.setProperty("password","lhc"); //密码
        //连接
        Connection connect = driver.connect(url, properties);
        System.out.println("方式1 " + connect);
    }

    @Test
    //方式2（通过反射得到 Driver对象，动态加载，更加的灵活，减少依赖性）
    public void connect02() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        //1. 使用反射加载Driver类
        //1.1 加载类 得到Driver类对象
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        //1.2 创建对象实例
        Driver driver = (Driver) aClass.newInstance();
        //2. 获取连接
        String url = "jdbc:mysql://localhost:3306/lhc_db01";
        //将用户名和密码放入到Properties对象中
        Properties properties = new Properties();
        //说明：user 和 password 是规定好的，后面的值 填入正确的即可
        properties.setProperty("user","root"); //用户名
        properties.setProperty("password","lhc"); //密码
        //连接
        Connection connect = driver.connect(url, properties);
        System.out.println("方式2 " + connect);
    }

    @Test
    //方式3（使用DriverManager 替换 Driver 进行统一管理，增强扩展性）
    public void connect03() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        //使用反射加载Driver类
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        //创建 url 和 用户名 密码
        String url = "jdbc:mysql://localhost:3306/lhc_db01";
        String user = "root";
        String password = "lhc";
        //使用DriverManager 替换 Driver，注册Driver驱动
        DriverManager.registerDriver(driver);
        //获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("方式3 " + connection);
    }

    @Test
    //方式4（使用 Class.forName 自动完成注册驱动，简化代码）
    public void connect04() throws ClassNotFoundException, SQLException {
        //使用反射加载 Driver类
        //在加载 Driver类时，会自动完成注册
        /* 我们来分析一下 com.mysql.jdbc.Driver 类 源码：
                //1. 静态代码块，在类加载时，会执行一次
                static {
                    try {
                        //2. 这里 就是使用了我们的第3种方式 完成了 Driver驱动 注册
                        DriverManager.registerDriver(new Driver());
                    } catch (SQLException var1) {
                        throw new RuntimeException("Can't register driver!");
                    }
                }
         */
        //通过源码方式，得知 Class.forName 底层 会完成注册驱动
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        // 说明：
        // 1. mysql驱动5.1.6可以无需Class.forName("com.mysql.jdbc.Driver");
        // 2. 从jdk1.5 以后使用了jdbc4，不再需要显示调用class.forName() 注册驱动，
        //    而是自动调用驱动 jar包下 META-INF\services\java.sql.Driver 文本中的类名称去注册
        // 3. 我们还是建议 写上 Class.forName() 使之更加明确

        //创建 url 和 用户名 密码
        String url = "jdbc:mysql://localhost:3306/lhc_db01";
        String user = "root";
        String password = "lhc";

        //获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("方式4 " + connection);
    }

    @Test
    //方式5 （d对方式4改进，增加配置文件，让连接数据库更灵活）
    public void connect05() throws SQLException, ClassNotFoundException, IOException {

        //通过Properties对象获取配置文件信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\hsp\\chapter25\\jdbc\\mysql.properties"));
        //读取配置文件，获取相关的值
        //如果我们想要得到其他连接时，我们只要修改配置文件信息就行，不动源码
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        //注册驱动
        Class<?> aClass = Class.forName(driver);
        //获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("方式5 " + connection);
    }
}
