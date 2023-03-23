package hsp.chapter25.jdbc.myjdbc;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/5 18:15 星期四
 * @Description: 模拟Mysql数据库实现Jdbc接口
 */
public class MysqlJdbcImp implements JdbcInterface {
    @Override
    public Object getConnection() {
        System.out.println("得到 mysql 的连接");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成 mysql 增删改查");
    }

    @Override
    public void close() {
        System.out.println("关闭 mysql 的连接");
    }
}
