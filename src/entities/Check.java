package entities;

public class Check {
	private String id;
	private String name;
	private double inmon;
	private int inquan;
	private double outmon;
	private int outquan;
	private int remain;
	private double profit;
	
	public Check() {
	}
	
	public Check(String i,String n,double im,int iq,double om,int oq,int r,double p) {
		id=i;name=n;inmon=im;inquan=iq;outmon=om;outquan=oq;remain=r;profit=p;
	}
	public String getid()
	{
		return id;
	}
	public String getname()
	{
		return name;
	}
	public double getinmoney()
	{
		return inmon;
	}
	public int getinquantities()
	{
		return inquan;
	}
	public double getoutmoney()
	{
		return outmon;
	}
	public int getoutquantities()
	{
		return outquan;
	}
	public int getremain()
	{
		return remain;
	}
	public double getprofit()
	{
		return profit;
	}
	
	public void setid(String i)
	{
		id=i;
	}
	public void setname(String n)
	{
		name=n;
	}
	public void setinmon(double in) {
		inmon=in;
	}
	public void setoutmon(double ou) {
		outmon=ou;
	}
	public void setprofit(double p) {
		profit=p;
	}
	public void setinquan(int x)
	{
		inquan=x;
	}
	public void setoutquan(int x)
	{
		outquan=x;
	}
	public void setremain(int x)
	{
		remain=x;
	}
	
	
	public void ChangeRemain(int x,int c)  //x=0时表示出库，反之入库
	{
		switch(x) {
		case 0:
			outquan+=c;
			remain-=c;
			break;
		case 1:
			inquan+=c;
			remain+=c;
			break;
		default:
			System.out.println("input error");
			break;
		}
	}

}
