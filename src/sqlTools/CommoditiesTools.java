package sqlTools;
import java.sql.Connection; //连接
import java.sql.PreparedStatement; //语句
import java.sql.ResultSet; //结果遍历集
import java.sql.SQLException; //异常处理

import java.util.ArrayList;
import java.util.List;
import connectdb.Database;
import entities.Commodities;


public class CommoditiesTools {
	
/*返回所有商品*/
	public List<Commodities> AllCommodities()
	{
		String sql="select * from commodities";
		List<Commodities> ls=new ArrayList<Commodities>(); 
		Traverse(ls,sql); //传对象，会改变值
		return ls;
	}
	
/* 返回查找名字类似的商品*/	
	public static List<Commodities> Searchname_Com(String name)
	{
		String sql="select * from commodities where c_name like'%"+name+"%'";
		List<Commodities> ls=new ArrayList<Commodities>();
		Traverse(ls,sql);
		return ls;
	}
	
/*输入编号查找商品*/
	public static List<Commodities> Searchid_Com(String id)
	{
		String sql="select * from commodities where c_name like'%"+id+"%'";
		List<Commodities> ls=new ArrayList<Commodities>();
		Traverse(ls,sql);
		return ls;
	}
	
//各个函数之间的联动
	public static List<Commodities> Search(String id)
	{
		String sql="select * from commodities where c_id="+id+"";
		List<Commodities> ls=new ArrayList<Commodities>();
		Traverse(ls,sql);
		return ls;
	}

	public static void AlterRemain(String id,int r)
	{
		String sql="update commodities set "
				+ "c_remain="+r+" where c_id="+id+"";
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st =con.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			}
	}
	
/*插入商品*/
	public static int AddCom(Commodities com)
	{
		int i=0;
		String sql="insert into commodities "
				+ "(c_id,cp_id,cc_id,c_name,c_type,c_inmoney,c_outmoney,c_remain)"
				+ "values(?,?,?,?,?,?,?,?)";
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1, com.getid());
			st.setString(2, com.getcpid());
			st.setString(3,com.getccid());
			st.setString(4,com.getname());
			st.setString(5, com.gettype());
			st.setDouble(6, com.getinmoney());
			st.setDouble(7, com.getoutmoney());
			st.setInt(8,com.getremain());
			i=st.executeUpdate();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return i;
	}
	
/*修改商品*/
	public static int UpdateCom(Commodities com)
	{
		int i=0;
		String sql="update commodities set "
				+ "c_id=?,cp_id=?,cc_id=?,c_name=?,c_type=?,c_inmoney=?,c_outmoney=?,c_remain=? "
				+ "where c_id=?";
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1, com.getid());
			st.setString(2, com.getcpid());
			st.setString(3,com.getccid());
			st.setString(4,com.getname());
			st.setString(5, com.gettype());
			st.setDouble(6, com.getinmoney());
			st.setDouble(7, com.getoutmoney());
			st.setInt(8,com.getremain());
			st.setString(9, com.getid());
			i=st.executeUpdate();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return i;
	}
	
	public static int UpdateCom(int x,String id,double p,int q)
	{
		int i=0;
		String sql;
		switch(x) {
		case 6:{
			sql="update commodities set "
					+ "c_inmoney=?,c_remain=c_remain+? "
					+ "where c_id=?";
			break;
		}
		case 7:{
			sql="update commodities set "
					+ "c_outmoney=?,c_remain=c_remain+? "
					+ "where c_id=?";
			break;
		}
		default:
			sql=null;
			break;
		}
		
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st =con.prepareStatement(sql);
			st.setDouble(1, p);
			st.setInt(2,q);
			st.setString(3, id);
			i=st.executeUpdate();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return i;
	}
	
/*删除商品*/
	public static int DeleteCom(String id)
	{
		int i=0;
		String sql="delete from commodities where c_id=?";
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1, id);
			i=st.executeUpdate();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return i;
	}
	
/*由于前三个函数都要用到遍历-大量重复代码，则写为一函数*/
    static void Traverse(List<Commodities> list,String sql)
	{
		Database db=new Database();
		Connection con=db.getcon();
		ResultSet rs=null;
		try {
			PreparedStatement st =con.prepareStatement(sql);
			rs=st.executeQuery(sql);
			while(rs.next()) {
				String i=rs.getString("c_id");
				String pi=rs.getString("cp_id");
				String ci=rs.getString("cc_id");
				String n=rs.getString("c_name");
				String t=rs.getString("c_type");
				double in=rs.getDouble("c_inmoney");
				double ou=rs.getDouble("c_outmoney");
				int r=rs.getInt("c_remain");
				Commodities commo=new Commodities(i,pi,ci,n,t,in,ou,r);
				list.add(commo);
			}
			rs.close();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

