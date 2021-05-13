package hustlefolder7;

public class HamBurger {
	private String name;
	private double price;
	private String breadType;
	private String meat;
	
	private String addition1Name;
	private double addition1price;
	
	private String addition2Name;
	private double addition2price;
	
	private String addition3Name;
	private double addition3price;
	
	private String addition4Name;
	private double addition4price;
	public HamBurger(String name, double price, String breadType, String meat) {
		this.name = name;
		this.price = price;
		this.breadType = breadType;
		this.meat = meat;
	}
	public void hamburgerAddition1(String addition1Name,double addition1price)
	{
		this.addition1Name=addition1Name;
		this.addition1price=addition1price;
	}
	public void hamburgerAddition2(String addition2Name,double addition2price)
	{
		this.addition2Name=addition2Name;
		this.addition2price=addition2price;
	}
	public void hamburgerAddition3(String addition3Name,double addition3price)
	{
		this.addition3Name=addition3Name;
		this.addition3price=addition3price;
	}
	public void hamburgerAddition4(String addition4Name,double addition4price)
	{
		this.addition4Name=addition4Name;
		this.addition4price=addition4price;
	}
	public double itemizeBurger()
	{
		double hamburgerPrice=this.price;
		System.out.println(this.name+" hamburger on a "+this.breadType+" bread roll with "+this.meat+" costs "+this.price+"$");
		if(addition1Name!=null)
		{
			System.out.println("Added "+addition1Name+" with a add up of "+addition1price+"$");
			hamburgerPrice+=addition1price;
		}
		if(addition2Name!=null)
		{
			System.out.println("Added "+addition2Name+" with a add up of "+addition2price+"$");
			hamburgerPrice+=addition2price;
		}
		if(addition3Name!=null)
		{
			System.out.println("Added "+addition3Name+" with a add up of "+addition3price+"$");
			hamburgerPrice+=addition3price;
		}
		if(addition4Name!=null)
		{
			System.out.println("Added "+addition4Name+" with a add up of "+addition4price+"$");
			hamburgerPrice+=addition4price;
		}
		return hamburgerPrice;
	}
	

}
