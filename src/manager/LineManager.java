package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JDBCConnection;
import model.Line;
import model.PageModel;

public class LineManager {
	/**
	 * 分页查询
	 * @param pageNo 第几页
	 * @param pageSize 每页多少条记录
	 * @return 查询的信息
	 */
	public static PageModel findAllLine(int pageNo,int pageSize){
		String sql="select id,city_no,mp_id,data_dt,day_in_e,day_out_e,line_loss,county_no,"
			+"line_id,line_name from iep_line_loss_primit where id >=? and id<=?";
		PageModel pageModel=null;
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			 conn=JDBCConnection.getConnection();
			 pstm=conn.prepareStatement(sql);
			int start=(pageNo-1)*pageSize+1;
			int end=(pageNo)*pageSize;
			pstm.setInt(1, start);
			pstm.setInt(2, end);
			 rs=pstm.executeQuery();
			pageModel=new PageModel();
			List list=new ArrayList();
			while(rs.next()){
				Line line=new Line();
				line.setId(rs.getInt("id"));
				line.setCity_no(rs.getString("city_no"));
				line.setMp_id(rs.getString("mp_id"));
				line.setDate_dt(rs.getDate("data_dt"));
				line.setDay_in_e(rs.getDouble("day_in_e"));
				line.setDay_out_e(rs.getDouble("day_out_e"));
				line.setLine_loss(rs.getDouble("line_loss"));
				line.setCounty_no(rs.getInt("county_no"));
				line.setLine_id(rs.getInt("line_id"));
				line.setLine_name(rs.getString("line_name"));
				list.add(line);
			}
			pageModel.setList(list);
			pageModel.setTotalRecords(getTotalRecords(conn));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCConnection.close(rs);
			JDBCConnection.close(pstm);
			JDBCConnection.close(conn);
		}
		
		return pageModel;
	}
	
	
	private static int getTotalRecords(Connection conn) throws SQLException{
		String sql="select count(id)  from iep_line_loss_primit";
		PreparedStatement pstm=conn.prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		int totalRecords=0;
		if(rs.next()){
			totalRecords=rs.getInt(1);
		}
		return totalRecords;
	}
}
