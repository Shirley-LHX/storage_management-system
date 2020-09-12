package sqlTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import connectdb.Database;
import entities.Input;
import entities.Commodities;

public class InputTools {
	
/*������������¼*/
	public List<Input> AllIn()
	{
		String sql="select * from input";
		List<Input> ls=new ArrayList<Input>();
		Traverse(ls,sql);
		return ls;
	}
	
/*������Ʒ��Ų��������Ϣ*/
	public static List<Input> SearchIn(String id)
	{
		String sql="select * from input where commodities_c_id like'%"+id+"%'";
		List<Input> ls=new ArrayList<Input>();
		Traverse(ls,sql);
		return ls;
	}
	
	
/*���_�������¼*/
	
	public static int AddInRecord(Input in)
	{
		int i=0;
		String sql="insert into input "
				+"(commodities_c_id,provider_p_id,inputmoney,inputquantities,inputtime)"
				+"values(?,?,?,?,CURRENT_DATE())";
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1, in.getcommodities_id());
			st.setString(2, in.getprovider_id());
			st.setDouble(3, in.getInputMoney());
			st.setInt(4, in.getInputQuantities());
			i=st.executeUpdate();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return i;
	}
	
/*�޸�����¼(��Ǯ������)��������Ʒ���ͻ����*/
	public static int AlterInRecord(Input in)
	{
		int i=0;
		String sql="update input set inputmoney=?,inputquantities=?"
				  +" where inputtime=? and commodities_c_id=?;";
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st =con.prepareStatement(sql);
			st.setDouble(1, in.getInputMoney());
			st.setInt(2, in.getInputQuantities());
			st.setString(3, in.getInputTime());
			st.setString(4, in.getcommodities_id());
			i=st.executeUpdate();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return i;
	}
	
	public static int UpdateIn(Commodities com)
	{
		int i=0;
		String sql="update input set inputmoney=? " 
				+ "where commodities_c_id=?";
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st =con.prepareStatement(sql);
			st.setDouble(1,com.getinmoney());
			st.setString(2, com.getid());
			i=st.executeUpdate();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return i;
	}
	
/*ɾ������¼*/
	public static int DeleteInRecord(String t,String cid)
	{
		int i=0;
		String sql="delete from input where inputtime=? and commodities_c_id=?";
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
	
	public static int DeleteInRecord(String cid) {
		int i=0;
		String sql="delete from input where commodities_c_id=?";
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
	
	public static int DeleteInRecord2(String pid) {
		int i=0;
		String sql="delete from input where provider_p_id=?";
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1, pid);
			i=st.executeUpdate();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return i;
	}
	
/*��������*/
	static void Traverse(List<Input> list,String sql)
	{
		Database db=new Database();
		Connection con=db.getcon();
		ResultSet rs=null;
		try {
			PreparedStatement st=con.prepareStatement(sql);
			rs=st.executeQuery(sql);
			while(rs.next()) {
				String pid=rs.getString("commodities_c_id");
				String id=rs.getString("provider_p_id");
				double im=rs.getDouble("inputmoney");
				int iq=rs.getInt("inputquantities");
				String it=rs.getString("inputtime");
				Input in=new Input(pid,id,im,iq,it);
				list.add(in);
			}
			rs.close();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
