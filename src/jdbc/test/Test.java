package jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import jdbc.JDBCConnection;

import manager.LineManager;
import model.PageModel;

public class Test {
	public static void main(String[] args) throws SQLException{
		//testGetTotalRecords();
		testFindAllLine();
	}
	
	
	public static void testFindAllLine(){
		int pageNo =1;
		int pageSize=5;
		PageModel pm=LineManager.findAllLine(pageNo, pageSize);
		List list=pm.getList();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	
	public static void testGetTotalRecords() throws SQLException{
		String sql="select count(id)   from iep_line_loss_primit";
		Connection conn=JDBCConnection.getConnection();
		PreparedStatement pstm=conn.prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		rs.next();
		int totalRecords=rs.getInt(1);
		System.out.println( "totalRecords:"+totalRecords);
	}
}
