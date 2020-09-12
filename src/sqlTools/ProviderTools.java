package sqlTools;
import java.sql.Connection; //连接
import java.sql.PreparedStatement; //语句
import java.sql.ResultSet; //结果遍历集
import java.sql.SQLException; //异常处理

import java.util.ArrayList;
import java.util.List;
import connectdb.Database;
import entities.Client;
import entities.Provider;;

public class ProviderTools {
	
/*返回所有供应商*/
	public List<Provider> AllProvider()
	{
		String sql="select * from provider";
		List<Provider> ls=new ArrayList<Provider>();
		Traverse(ls,sql);
		return ls;
	}
/*根据名字查询供应商*/
	public static List<Provider> Searchname_Pro(String name)
	{
		String sql="select * from provider where p_name like'%"+name+"%'";
		List<Provider> ls=new ArrayList<Provider>();
		Traverse(ls,sql);
		return ls;
	}
	
/*添加供应商*/
	public static int AddPro(Provider pro)
	{
		int i=0;
		String sql="insert into provider (p_id,p_name,p_phone)values(?,?,?)";
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1, pro.getid());
			st.setString(2, pro.getname());
			st.setString(3, pro.getphone());
			i=st.executeUpdate();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return i;
	}
	
/*删除供应商*/
	public static int DeletePro(String id)
	{
		int i=0;
		String sql="delete from provider where p_id=?";
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
	
	//修改供应商
	public static int UpdatePro(Provider p)
	{
		int i=0;
		String sql="update provider set "
				+ "p_id=?,p_name=?,p_phone=? "
				+ "where p_id=?";
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1, p.getid());
			st.setString(2,p.getname());
			st.setString(3, p.getphone());
			st.setString(4, p.getid());
			i=st.executeUpdate();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return i;
	}

/*遍历函数*/
	 static void Traverse(List<Provider> list,String sql)
		{
			Database db=new Database();
			Connection con=db.getcon();
			ResultSet rs=null;
			try {
				PreparedStatement st =con.prepareStatement(sql);
				rs=st.executeQuery(sql);
				while(rs.next()) {
					String i=rs.getString("p_id");
					String n=rs.getString("p_name");
					String ph=rs.getString("p_phone");
					Provider p= new Provider(i,n,ph);
					list.add(p);
				}
				rs.close();
				st.close();
				con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
