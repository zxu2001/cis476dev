

public class PizzaTestDrive {
 
	public static void main(String[] args) {
		PizzaFactory nyFactory = new NYPizzaFactory();
		PizzaFactory chicagoFactory = new ChicagoPizzaFactory();
 
		Pizza pizza = nyFactory.orderPizza("cheese");
		System.out.println("Ethan ordered a " + pizza.getName() + "\n");
 
		pizza = chicagoFactory.orderPizza("cheese");
		System.out.println("Joel ordered a " + pizza.getName() + "\n");

		pizza = nyFactory.orderPizza("clam");
		System.out.println("Ethan ordered a " + pizza.getName() + "\n");
 
		pizza = chicagoFactory.orderPizza("clam");
		System.out.println("Joel ordered a " + pizza.getName() + "\n");

		pizza = nyFactory.orderPizza("pepperoni");
		System.out.println("Ethan ordered a " + pizza.getName() + "\n");
 
		pizza = chicagoFactory.orderPizza("pepperoni");
		System.out.println("Joel ordered a " + pizza.getName() + "\n");

		pizza = nyFactory.orderPizza("veggie");
		System.out.println("Ethan ordered a " + pizza.getName() + "\n");
 
		pizza = chicagoFactory.orderPizza("veggie");
		System.out.println("Joel ordered a " + pizza.getName() + "\n");
	}
}
