package entities;

public class Commodities {
	private String c_id;
	private String cp_id;
	private String cc_id;
	private String c_name;
	private String c_type;
	private double inmoney;
	private double outmoney;
	private int c_remain;
	public Commodities() {}
	public Commodities(String i,String pi,String ci,String n,String t,double in,double ou,int r)
	{
		c_id=i;c_name=n;c_type=t;
		inmoney=in;outmoney=ou;c_remain=r;
		cp_id=pi;cc_id=ci;
	}
	public String getid()
	{
		return c_id;
	}
	public String getcpid()
	{
		return cp_id;
	}
	public String getccid()
	{
		return cc_id;
	}
	public String getname()
	{
		return c_name;
	}
	public String gettype()
	{
		return c_type;
	}
	public double getinmoney()
	{
		return inmoney;
	}
	public double getoutmoney()
	{
		return outmoney;
	}
	public int getremain()
	{
		return c_remain;
	}
	
	
	public void ChangeRemain(int x,int c)  //x=0时表示出库，反之入库
	{
		switch(x) {
		case 0:
			c_remain-=c;
			break;
		case 1:
			c_remain+=c;
			break;
		default:
			System.out.println("input error");
			break;
		}
	}
	
	
	public void setid(String i)
	{
		c_id=i;
	}
	public void setcpid(String i)
	{
		cp_id=i;
	}
	public void setccid(String i)
	{
		cc_id=i;
	}
	public void setname(String n)
	{
		c_name=n;
	}
	public void settype(String n)
	{
		c_type=n;
	}
	public void setOutmoney(double m)
	{
		outmoney=m;
	}
	public void setInmoney(double m) {
		inmoney=m;
	}
	public void setremain(int r)
	{
		c_remain=r;
	}
}
