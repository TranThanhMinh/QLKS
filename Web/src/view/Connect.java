package view;

import java.sql.DriverManager;
import java.sql.Connection;
public class Connect {
	public static  Connection  conn=null;
public static Connection getConnect() {
		try {
		     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");		
		        // Cấu trúc URL Connection dành cho SQLServer
		        // Ví dụ:
		        // jdbc:sqlserver://ServerIp:1433/SQLEXPRESS;databaseName=simplehr		  
		        conn=  DriverManager.getConnection("jdbc:sqlserver://DESKTOP-8CI2VQQ\\SQLEXPRESS:1433;databaseName=QLKS", "sa", "123456");
		       
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		return conn;
}
}
