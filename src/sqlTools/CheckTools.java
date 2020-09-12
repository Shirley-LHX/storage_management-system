package sqlTools;

import java.sql.Connection; //连接
import java.sql.PreparedStatement; //语句
import java.sql.ResultSet; //结果遍历集
import java.sql.SQLException; //异常处理

import java.util.ArrayList;
import java.util.List;
import connectdb.Database;
import entities.Check;
import entities.Commodities;

public class CheckTools {
	
/*返回所有盘库记录*/
	public List<Check> AllCheck()
	{
		String sql="select * from checkcom";
		List<Check> ls=new ArrayList<Check>(); 
		Traverse(ls,sql); //传对象，会改变值
		return ls;
	}

/* 返回查找名字类似的商品的盘库记录*/	
	public static List<Check> Searchname_Chec(String name)
	{
		String sql="select * from checkcom where name like'%"+name+"%'";
		List<Check> ls=new ArrayList<Check>();
		Traverse(ls,sql);
		return ls;
	}
	
/*输入编号查找商品的盘库记录*/
	public static List<Check> Searchid_Chec(String id)
	{
		String sql="select * from checkcom where id like'%"+id+"%'";
		List<Check> ls=new ArrayList<Check>();
		Traverse(ls,sql);
		return ls;
	}
	
	public static List<Check> Search(String id) {
		String sql="select * from checkcom where id="+id+"";
		List<Check> ls=new ArrayList<Check>();
		Traverse(ls,sql);
		return ls;
	}
	
	public static void AlterQuan(int d,String id,int q)
	{
		String sql=null;
		switch(d)
		{
		case 6:{      
			sql="update checkcom set "
					+ "inquan="+q+" where id="+id+"";
		    break;
		}
		case 7:
		{
			sql="update checkcom set "
					+ "outquan="+q+" where id="+id+"";
			break;
		}
		default:break;
		}
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
	
	public static void AlterRemain(String id,int r)
	{
		String sql="update checkcom set "
				+ "remain="+r+" where id="+id+"";
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
	
	public static void AlterProfit(String id)
	{
		String sql="update checkcom set "
				+ "profit=outquan*outmon-inquan*inmon"+" where id="+id+"";
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
	
	
/*插入商品盘库记录*/
	public static int AddChec(Check com)
	{
		int i=0;
		String sql="insert into checkcom "
				+ "(id,name,inmon,inquan,outmon,outquan,remain,profit)"
				+ "values(?,?,?,?,?,?,?,?)";
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1, com.getid());
			st.setString(2, com.getname());
			st.setDouble(3,com.getinmoney());
			st.setInt(4,com.getinquantities());
			st.setDouble(5, com.getoutmoney());
			st.setInt(6, com.getoutquantities());
			st.setInt(7,com.getremain());
			st.setDouble(8, com.getprofit());
			i=st.executeUpdate();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return i;
	}
	
/*修改商品盘库记录*/
	public static int UpdateChec(Check com)
	{
		int i=0;
		String sql="update checkcom set id=?,name=?,inmon=?,"
				+ "inquan=?,outmon=?,outquan=?,remain=?,profit=?" 
				+ "where id=?";
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1, com.getid());
			st.setString(2, com.getname());
			st.setDouble(3,com.getinmoney());
			st.setInt(4,com.getinquantities());
			st.setDouble(5, com.getoutmoney());
			st.setInt(6, com.getoutquantities());
			st.setInt(7,com.getremain());
			st.setDouble(8, com.getprofit());
			st.setString(9, com.getid());
			i=st.executeUpdate();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return i;
	}
	public static int UpdateChec(Commodities com)
	{
		int i=0;
		String sql="update checkcom set name=?,inmon=?,outmon=?,remain=? " 
				+ "where id=?";
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1, com.getname());
			st.setDouble(2,com.getinmoney());
			st.setDouble(3, com.getoutmoney());
			st.setInt(4,com.getremain());
			st.setString(5, com.getid());
			i=st.executeUpdate();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return i;
	}
	
	public static int UpdateChec(int d,String id,double p,int r)
	{
		int i=0;
		String sql;
		switch(d) {
		case 6:
			sql="update checkcom set inmon=?,inquan=inquan+?,remain=remain+? " 
					+ "where id=?";
			break;
		case 7:
			sql="update checkcom set outmon=?,outquan=outquan-?,remain=remain+? " 
					+ "where id=?";
			break;
		default:
			sql=null;
			break;
		}
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st =con.prepareStatement(sql);
			st.setDouble(1,p);
			st.setInt(2,r);
			st.setInt(3,r);
			st.setString(4, id);
			i=st.executeUpdate();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return i;
	}
	
/*删除商品盘库记录*/
	public static int DeleteChec(String id)
	{
		int i=0;
		String sql="delete from checkcom where id=?";
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
	
	
//遍历函数
    static void Traverse(List<Check> list, String sql) {
	Database db=new Database();
	Connection con=db.getcon();
	ResultSet rs=null;
	try {
		PreparedStatement st =con.prepareStatement(sql);
		rs=st.executeQuery(sql);
		while(rs.next()) {
			String i=rs.getString("id");
			String n=rs.getString("name");
			double in=rs.getDouble("inmon");
			int iq=rs.getInt("inquan");
			double ou=rs.getDouble("outmon");
			int oq=rs.getInt("outquan");
			int r=rs.getInt("remain");
			double p=rs.getDouble("profit");
			Check commo=new Check(i,n,in,iq,ou,oq,r,p);
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
