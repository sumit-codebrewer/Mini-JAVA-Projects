package hustlefolder7;

public class HamBurgerMain {

	public static void main(String[] args) {
		System.out.println("_________Welcome to Bill's Burgers___________");
		HamBurger hamburger=new HamBurger("Basic", 15.5, "White", "Sausage");
		hamburger.itemizeBurger();
		hamburger.hamburgerAddition1("Tomato",1.2);
		hamburger.hamburgerAddition2("Lettice",0.4);
		hamburger.hamburgerAddition3("Cucumber", 1.2);
		hamburger.hamburgerAddition4("Onion", 0.9);
		double price=hamburger.itemizeBurger();
		System.out.println("Final price along with the additionals:"+price);
		System.out.println("*******************************************");
		HealthyBurger hb=new HealthyBurger(16.9, "Bacon");
		hb.itemizeBurger();
		hb.hamburgerAddition1("Egg", 2.0);
		hb.healthyAddition1("Lentils", 2.2);
		hb.healthyAddition2("Spinach", 1.5);
		price=hb.itemizeBurger();
		System.out.println("Final price along with the additionals:"+price);
		System.out.println("*******************************************");
		DeluxeBurger db=new DeluxeBurger();
		db.hamburgerAddition3("Should not print", 50);
		db.itemizeBurger();
	}

}
