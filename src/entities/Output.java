package entities;

public class Output {
	private String client_cl_id;
	private String commodities_c_id;
	private double outputmoney;
	private int outputquantities;
	private String outputtime;
	public Output() {}
	public Output(String coi,String cli,double s,int oq,String ot)
	{
		client_cl_id=cli;
		commodities_c_id=coi;
		outputmoney=s;
		outputquantities=oq;
		outputtime=ot;
	}
	public String getclient_id()
	{
		return client_cl_id;
	}
	public String getcommodities_id()
	{
		return commodities_c_id;
	}
	public double getOutputMoney()
	{
		return outputmoney;
	}
	public int getOutputQuantities()
	{
		return outputquantities;
	}
	public String getOutputTime()
	{
		return outputtime;
	}
	
	
	public void setclient_id(String i)
	{
		client_cl_id=i;
	}
	public void setcommodities_id(String i)
	{
		commodities_c_id=i;
	}
	public void setOutputTime(String d)
	{
		outputtime=d;
	}	
	public void setmoney(double m)
	{
		outputmoney=m;
	}
	public void setquantities(int q)
	{
		outputquantities=q;
	}

}
