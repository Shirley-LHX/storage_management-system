package entities;

public class Client {
	private String cl_id;
	private String cl_name;
	private String cl_phone;
	public Client() {}
	public Client(String i,String n,String p)
	{
		cl_id=i;cl_name=n;cl_phone=p;
	}
	
	public String getid()
	{
		return cl_id;
	}
	public String getname()
	{
		return cl_name;
	}
	public String getphone()
	{
		return cl_phone;
	}
	
	
	public void setid(String id)
	{
		cl_id=id;
	}
	public void setname(String name)
	{
		cl_name=name;
	}
	public void setphone(String p)
	{
		cl_phone=p;
	}
}
