package serverUtils;

import  java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseServices implements DbInterface {
    @Override
    public  Connection getConnection() {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company_management?autoReconnect=true&useSSL=true", "root", "123456");
            System.out.println(con.toString());
            return con;
        } catch (Exception ex) {
            System.out.println("Error: can't make connection with Mysql Server##" + ex.getMessage());
            return null;
        }
    }

    @Override
    public  void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}