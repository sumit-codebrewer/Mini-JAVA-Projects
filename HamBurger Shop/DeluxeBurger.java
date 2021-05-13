package hustlefolder7;

public class DeluxeBurger extends HamBurger{

	public DeluxeBurger() {
		super("Deluxe", 20, "White", "Bacon and sausage");
		super.hamburgerAddition1("Chips", 1.65);
		super.hamburgerAddition2("Drink", 3.2);
	}

	@Override
	public void hamburgerAddition1(String addition1Name, double addition1price) {
		System.out.println("Cannot add any additionals to this burger");
	}

	@Override
	public void hamburgerAddition2(String addition2Name, double addition2price) {
		System.out.println("Cannot add any additionals to this burger");
	}

	@Override
	public void hamburgerAddition3(String addition3Name, double addition3price) {
		System.out.println("Cannot add any additionals to this burger");
	}

	@Override
	public void hamburgerAddition4(String addition4Name, double addition4price) {
		System.out.println("Cannot add any additionals to this burger");
	}
	
	
	

}
