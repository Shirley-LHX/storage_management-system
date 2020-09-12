package sqlTools;

import java.sql.Connection; //连接
import java.sql.PreparedStatement; //语句
import java.sql.ResultSet; //结果遍历集
import java.sql.SQLException; //异常处理

import java.util.ArrayList;
import java.util.List;
import connectdb.Database;
import entities.Client;
import entities.Manager;

public class ManagerTools {

/*返回全部管理员*/
	public List<Manager> AllManager()
	{
		String sql="select * from manager";
		List<Manager> ls=new ArrayList<Manager>();
		Traverse(ls,sql);
		return ls;
	}
	/*根据名字查询管理员*/
	public static List<Manager> Searchname_Man(String name)
	{
		String sql="select * from manager where m_name like'%"+name+"%'";
		List<Manager> ls=new ArrayList<Manager>();
		Traverse(ls,sql);
		return ls;
	}
	

/*判断id与password是否一致*/
	public boolean manLogin(int id,String password)
	{
		Database db=new Database();
		Connection con=db.getcon();
		try {
			String sql="select m_id,m_password from manager where m_id='"+id+"' and m_password='"+password+"'";
			PreparedStatement st=con.prepareStatement(sql);
			ResultSet rs=st.executeQuery(sql);
			if(rs.next())
			{
				return true;
			}
			rs.close();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
/*添加管理员*/
	public static int AddMan(Manager m)
	{
		int i=0;
		String sql="insert into manager (m_id,m_name,m_password)values(?,?,?)";
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, m.getid());
			st.setString(2, m.getname());
			st.setString(3, m.getPassword());
			i=st.executeUpdate();
			st.close();
			con.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return i;
	}
	
/*删除管理员*/
	public static int DeleteMan(String id)
	{
		int i=0;
		String sql="delete from manager where m_id=?";
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, id);
			i=st.executeUpdate();
			st.close();
			con.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return i;
	}

//修改管理员
	public static int UpdateMan(Manager m)
	{
		int i=0;
		String sql="update manager set "
				+ "m_id=?,m_name=?,m_password=? "
				+ "where m_id=?";
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1, m.getid());
			st.setString(2,m.getname());
			st.setString(3, m.getPassword());
			st.setString(4, m.getid());
			i=st.executeUpdate();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return i;
	}
	
	private static void Traverse(List<Manager> list, String sql) {
		Database db=new Database();
		Connection con=db.getcon();
		ResultSet rs=null;
		try {
			PreparedStatement st=con.prepareStatement(sql);
			rs=st.executeQuery(sql);
			while(rs.next()) {
				Manager m=new Manager();
				m.setID(rs.getString("m_id"));
				m.setName(rs.getString("m_name"));
				m.setPassword(rs.getString("m_password"));
				list.add(m);
			}
			rs.close();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
