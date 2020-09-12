package sqlTools;
import java.sql.Connection; //连接
import java.sql.PreparedStatement; //语句
import java.sql.ResultSet; //结果遍历集
import java.sql.SQLException; //异常处理

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import connectdb.Database;
import entities.Output;
import entities.Commodities;
import entities.Input;

public class OutputTools {
	
/*返回所有出库记录*/
	public List<Output> AllOut()
	{
		String sql="select * from output";
		List<Output> ls=new ArrayList<Output>();
		Traverse(ls,sql);
		return ls;
	}
	
/*根据商品编号查询出库信息*/
	public static List<Output> SearchOut(String id)
	{
		String sql="select * from output where commodities_c_id like'%"+id+"%'";
		List<Output> ls=new ArrayList<Output>();
		Traverse(ls,sql);
		return ls;
	}
	
	
/*出库_添加出库记录*/
	public static int AddOutRecord(Output o)
	{
		int i=0;
		String sql="insert into output "
				+"(commodities_c_id,client_cl_id,outputmoney,outputquantities,outputtime)"
				+"values(?,?,?,?,CURRENT_DATE())";
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1, o.getcommodities_id());
			st.setString(2, o.getclient_id());
			st.setDouble(3, o.getOutputMoney());
			st.setInt(4, o.getOutputQuantities());
			i=st.executeUpdate();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return i;
	}
	
/*修改出库记录(价钱及数量)—根据商品及客户编号*/
	public static int AlterOutRecord(Output o)
	{
		int i=0;
		String sql="update output set outputmoney=?,outputquantities=?"
				  +" where outputtime=? and commodities_c_id=?;";
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st =con.prepareStatement(sql);
			st.setDouble(1, o.getOutputMoney());
			st.setInt(2, o.getOutputQuantities());
			st.setString(3, o.getOutputTime());
			st.setString(4, o.getcommodities_id());
			i=st.executeUpdate();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return i;
	}
	
	public static int UpdateOut(Commodities com)
	{
		int i=0;
		String sql="update output set outputmoney=? " 
				+ "where commodities_c_id=?";
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st =con.prepareStatement(sql);
			st.setDouble(1,com.getoutmoney());
			st.setString(2, com.getid());
			i=st.executeUpdate();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return i;
	}
	
	
/*删除出库记录*/
	public static int DeleteOutRecord(String t,String cid)
	{
		int i=0;
		String sql="delete from output where outputtime=? and commodities_c_id=?";
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1, t);
			st.setString(2, cid);
			i=st.executeUpdate();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return i;
	}
	public static int DeleteOutRecord(String cid)
	{
		int i=0;
		String sql="delete from output where commodities_c_id=?";
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1, cid);
			i=st.executeUpdate();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return i;
	}
	
	public static int DeleteOutRecord2(String clid)
	{
		int i=0;
		String sql="delete from output where client_cl_id=?";
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1, clid);
			i=st.executeUpdate();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return i;
	}
	
/*遍历函数*/
	static void Traverse(List<Output> list,String sql)
	{
		Database db=new Database();
		Connection con=db.getcon();
		ResultSet rs=null;
		try {
			PreparedStatement st=con.prepareStatement(sql);
			rs=st.executeQuery(sql);
			while(rs.next()) {
				String cid=rs.getString("commodities_c_id");
				String id=rs.getString("client_cl_id");
				double om=rs.getDouble("outputmoney");
				int oq=rs.getInt("outputquantities");
				String ot=rs.getString("outputtime");
				Output o=new Output(cid,id,om,oq,ot);
				list.add(o);
			}
			rs.close();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
