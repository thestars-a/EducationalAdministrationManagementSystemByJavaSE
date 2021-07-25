package Util;

import java.sql.*;

/**
 * 注解来替代文件,填写Mysql的用户名和密码
 */
@Pro(url = "jdbc:mysql:///db_stu_sys",user = "",password ="")
public class JDBCUtils {

    private static String url;
    private static String user;
    private static String password;

    /**
     * 文件的读取使用静态代码块只要调用就会执行，这样在调用函数链接数据库时就已经可以直接链接
     */
    static {
        Pro annotation = JDBCUtils.class.getAnnotation(Pro.class);
        url = annotation.url();
        user = annotation.user();
        password = annotation.password();
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    public static void close(Statement stmt,Connection conn)
    {
        close(null,stmt,conn);
    }
    public static void close(ResultSet rs, Statement stmt, Connection conn){
        if (rs!=null)
        {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt!=null)
        {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null)
        {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
