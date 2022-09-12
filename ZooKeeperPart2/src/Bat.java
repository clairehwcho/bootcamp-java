
public class Bat extends Mammal {

	public Bat() {
		super.energyLevel = 300;
	}

	//METHODS
	public void fly() {
		energyLevel -= 50;
		System.out.println("ping");
		System.out.println("The energy level is decreased by 50.");
	}
	
	public void eatHumans() {
		energyLevel += 100;
		System.out.println("so-well, never mind");
		System.out.println("The energy level is increased by 100.");
	}
	
	public void attackTown() {
		energyLevel -= 100;
		System.out.println("crackle");
		System.out.println("The energy level decreased by 100.");
	}
}
