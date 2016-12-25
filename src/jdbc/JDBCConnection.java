package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Line;
import model.PageModel;

public class JDBCConnection {
	
	public static final String DBDRIVER = "com.mysql.jdbc.Driver" ;
	public static final String DBURL = "jdbc:mysql://127.0.0.1:3306/caic" ;
	public static final String DBUSER = "root" ;
	public static final String DBPASS = "admin" ;
	
	
private static Connection conn;
	
	public static Connection getConnection(){
		try {
			Class.forName(DBDRIVER);  // 加载驱动程序
			conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);  //  获得连接的数据库
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement pstm){
		try {
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs){
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
