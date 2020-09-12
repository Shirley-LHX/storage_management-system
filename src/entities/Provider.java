package entities;

public class Provider {
	private String p_id;
	private String p_name;
	private String p_phone;
	public Provider() {}
	public Provider(String i,String n,String p)
	{
		p_id=i;p_name=n;p_phone=p;
	}
	public String getid()
	{
		return p_id;
	}
	public String getname()
	{
		return p_name;
	}
	public String getphone()
	{
		return p_phone;
	}
	
	public void setid(String id)
	{
		p_id=id;
	}
	public void setname(String name)
	{
		p_name=name;
	}
	public void setphone(String p)
	{
		p_phone=p;
	}
}
