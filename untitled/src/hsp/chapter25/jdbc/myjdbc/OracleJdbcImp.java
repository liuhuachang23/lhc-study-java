package hsp.chapter25.jdbc.myjdbc;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/5 18:29 星期四
 * @Description: 模拟Oracle数据库实现JDBC
 */
public class OracleJdbcImp implements JdbcInterface{
    @Override
    public Object getConnection() {
        System.out.println("得到 oracle 的连接");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成 oracle 增删改查");
    }

    @Override
    public void close() {
        System.out.println("关闭 oracle 的连接");
    }
}
