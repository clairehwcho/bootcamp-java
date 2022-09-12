public class Gorilla extends Mammal {

	public Gorilla() {
		super();
	}

	//METHODS
	public void throwSomething() {
		energyLevel -= 5;
		System.out.println("The gorilla has thrown something!");
		System.out.println("The energy level is decreased by 5.");
	}
	
	public void eatBananas() {
		energyLevel += 10;
		System.out.println("The gorilla is happy!");
		System.out.println("The energy level is increased by 10.");
	}
	
	public void climb() {
		energyLevel -= 10;
		System.out.println("The gorilla has climed a tree!");
		System.out.println("The energy level decreased by 10.");
	}
}
