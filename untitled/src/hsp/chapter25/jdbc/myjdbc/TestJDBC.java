package hsp.chapter25.jdbc.myjdbc;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/5 18:19 星期四
 * @Description: 测试
 */
public class TestJDBC {
    public static void main(String[] args) {
        //完成对mysql的操作
        JdbcInterface jdbcInterface = new MysqlJdbcImp();
        jdbcInterface.getConnection();
        jdbcInterface.crud();
        jdbcInterface.close();

        System.out.println("=====================================");
        //完成对oracle的操作
        jdbcInterface = new OracleJdbcImp();
        jdbcInterface.getConnection();
        jdbcInterface.crud();
        jdbcInterface.close();
    }

}
