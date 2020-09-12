package entities;


public class Input {
	private String provider_p_id;
	private String commodities_c_id;
	private double inputmoney;
	private int inputquantities;
	private String inputtime;
	public Input() {}
	public Input(String ci,String pi,double i,int q,String d)
	{
		provider_p_id=pi;commodities_c_id=ci;inputmoney=i;inputquantities=q;inputtime=d;
	}
	public String getprovider_id()
	{
		return provider_p_id;
	}
	public String getcommodities_id()
	{
		return commodities_c_id;
	}
	public double getInputMoney()
	{
		return inputmoney;
	}
	public int getInputQuantities()
	{
		return inputquantities;
	}
	public String getInputTime()
	{
		return inputtime;
	}
	
	
	public void setprovider_id(String i)
	{
		provider_p_id=i;
	}
	public void setcommodities_id(String i)
	{
		commodities_c_id=i;
	}
	public void setInputTime(String d)
	{
		inputtime=d;
	}	
	public void setmoney(double m) {
		inputmoney=m;	
	}
	public void setquantities(int q)
	{
		inputquantities=q;
	}

}
