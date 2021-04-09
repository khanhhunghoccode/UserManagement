/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungkd.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author PC
 */
public class DBUtils {
    public static Connection getConnection1() throws ClassNotFoundException, SQLException{//kết nỗi tĩnh
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=User_Management";
        conn = DriverManager.getConnection(url, "sa", "140383");
        return conn;
    }
    
    public static Connection getConnection() throws NamingException, SQLException {//kết nối động
        Connection conn = null;
        Context context = new InitialContext();
        Context end = (Context) context.lookup("java:comp/env");//remember
        DataSource ds = (DataSource) end.lookup("DBConn");
        conn = ds.getConnection();
        return conn;
    }

}
