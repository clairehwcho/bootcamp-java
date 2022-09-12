
public class BatTest {

	public static void main(String[] args) {
		Bat batman = new Bat();
		batman.attackTown();
		batman.displayEnergy();
		batman.attackTown();
		batman.displayEnergy();
		batman.attackTown();
		batman.displayEnergy();
		
		batman.eatHumans();
		batman.displayEnergy();
		batman.eatHumans();
		batman.displayEnergy();
		
		batman.fly();
		batman.displayEnergy();
		batman.fly();
		batman.displayEnergy();
	}

}
