package sqlTools;

import java.sql.Connection; //����
import java.sql.PreparedStatement; //���
import java.sql.ResultSet; //���������
import java.sql.SQLException; //�쳣����

import java.util.ArrayList;
import java.util.List;
import connectdb.Database;
import entities.Client;

public class ClientTools {
/*�������пͻ�*/
	public List<Client> AllClient()
	{
		String sql="select * from client";
		List<Client> ls=new ArrayList<Client>();
		Traverse(ls,sql);
		return ls;
	}
/*�������ֲ�ѯ�ͻ�*/
	public static List<Client> Searchname_Cli(String name)
	{
		String sql="select * from client where cl_name like'%"+name+"%'";
		List<Client> ls=new ArrayList<Client>();
		Traverse(ls,sql);
		return ls;
	}
	
/*��ӿͻ�*/
	public static int AddCli(Client cl)
	{
		int i=0;
		String sql="insert into client (cl_id,cl_name,cl_phone)values(?,?,?)";
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1, cl.getid());
			st.setString(2, cl.getname());
			st.setString(3, cl.getphone());
			i=st.executeUpdate();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return i;
	}
	
/*ɾ���ͻ�*/
	public static int DeleteCli(String id)
	{
		int i=0;
		String sql="delete from client where cl_id=?";
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
	
	//�޸Ŀͻ�
	public static int UpdateCli(Client c)
	{
		int i=0;
		String sql="update client set "
				+ "cl_id=?,cl_name=?,cl_phone=? "
				+ "where cl_id=?";
		Database db=new Database();
		Connection con=db.getcon();
		try {
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1, c.getid());
			st.setString(2,c.getname());
			st.setString(3, c.getphone());
			st.setString(4, c.getid());
			i=st.executeUpdate();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return i;
	}
	

/*��������*/
	 static void Traverse(List<Client> list,String sql)
	{
		Database db=new Database();
		Connection con=db.getcon();
		ResultSet rs=null;
		try {
			PreparedStatement st =con.prepareStatement(sql);
			rs=st.executeQuery(sql);
			while(rs.next()) {
				String i=rs.getString("cl_id");
				String n=rs.getString("cl_name");
				String ph=rs.getString("cl_phone");
				Client cl= new Client(i,n,ph);
				list.add(cl);
			}
			rs.close();
			st.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
