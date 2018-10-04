package serverUtils;

import  java.sql.Connection;


public interface DbInterface {
	public void close(Connection con);
    public Connection getConnection();
}