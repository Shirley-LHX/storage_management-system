package entities;

public class Manager {
	private String m_id;
	private String m_name;
	private String m_password;
	public void setID(String i)
	{
		m_id=i;
	}
	public void setName(String n)
	{
		m_name=n;
	}
	public void setPassword(String p)
	{
		m_password=p;
	}
	public String getid()
	{
		return m_id;
	}
	public String getname()
	{
		return m_name;
	}
	public String getPassword()
	{
		return m_password;
	}
}
