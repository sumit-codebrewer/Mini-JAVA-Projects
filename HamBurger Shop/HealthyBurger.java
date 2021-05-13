package hustlefolder7;

public class HealthyBurger extends HamBurger {
	private String healthyAddition1Name;
	private double healthyAddition1price;
	
	private String healthyAddition2Name;
	private double healthyAddition2price;
	public HealthyBurger(double price, String meat) {
		super("Healthy Hamburger", price, "Brown", meat);
	}
	public void healthyAddition1(String healthyAddition1Name,double healthyAddition1price)
	{
		this.healthyAddition1Name=healthyAddition1Name;
		this.healthyAddition1price=healthyAddition1price;
	}
	public void healthyAddition2(String healthyAddition2Name,double healthyAddition2price)
	{
		this.healthyAddition2Name=healthyAddition2Name;
		this.healthyAddition2price=healthyAddition2price;
	}
	@Override
	public double itemizeBurger() {
		double hamburgerPrice=super.itemizeBurger();
		if(healthyAddition1Name!=null)
		{
			System.out.println("Added "+healthyAddition1Name+" with a add up of "+healthyAddition1price+"$");
			hamburgerPrice+=healthyAddition1price;
		}
		if(healthyAddition2Name!=null)
		{
			System.out.println("Added "+healthyAddition2Name+" with a add up of "+healthyAddition2price+"$");
			hamburgerPrice+=healthyAddition2price;
		}
		return hamburgerPrice;
	}
	
	
}
