import java.util.ArrayList;
public class TestCoffeeKiosk {
    public static void main(String[] args) {

        CoffeeKiosk coffeeKiosk = new CoffeeKiosk();

        // menu items
        coffeeKiosk.addMenuItem("cappucino", 3.7);
        coffeeKiosk.addMenuItem("latte", 3.7);
        coffeeKiosk.addMenuItem("drip coffee", 3.5);
        coffeeKiosk.addMenuItem("mocha", 4.0);

        coffeeKiosk.newOrder();
    }
}
