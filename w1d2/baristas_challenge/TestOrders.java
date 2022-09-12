import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {
        // Menu items
        Item item1 = new Item("cappucino", 5.5);
        Item item2 = new Item("Mocha", 6.5);
        Item item3 = new Item("Latte", 4.5);
        Item item4 = new Item("Drip Coffee", 5.0);

        // Create 2 order for unspecified guests (without specifying a name)
        Order order1 = new Order();
        Order order2 = new Order();

        // Create 3 orders using the overloaded constructor to give each a name for the order.
        Order order3 = new Order("Claire");
        Order order4 = new Order("Tony");
        Order order5 = new Order("EMily");

        // Implement the addItem method within the Order class
        // Add at least 2 items to each of the orders using the addItem method you wrote,
        // for example, to add item1 to order3
        // you would need to call the addItem method from the order3 instance like so: order3.addItem(item1);
        order1.addItem(item1);
        order1.addItem(item2);

        order2.addItem(item1);
        order2.addItem(item3);

        order3.addItem(item2);
        order3.addItem(item4);

        order4.addItem(item1);
        order4.addItem(item4);

        order5.addItem(item3);
        order5.addItem(item3);

        // Implement the getStatusMessage method within the Order class
        // Test your getStatusMessage functionality by setting some orders to ready
        // and printing the messages for each order.
        // For example:
        // order2.setReady(true);
        // System.out.println(order2.getStatusMessage());
        order1.setReady(true);
        System.out.println(order1.getName() + "!" + order1.getStatusMessage());

        order2.setReady(false);
        System.out.println(order2.getName() + "!" + order2.getStatusMessage());

        order3.setReady(true);
        System.out.println(order3.getName() + "!" + order3.getStatusMessage());

        order4.setReady(true);
        System.out.println(order4.getName() + "!" + order4.getStatusMessage());

        order5.setReady(false);
        System.out.println(order5.getName() + "!" + order5.getStatusMessage());
        System.out.println("\n");

        // Implement the getOrderTotal method within the Order class
        // Test the total by printing the return value like so:
        // System.out.println(order1.getOrderTotal());
        System.out.println(order1.getName()+", your total is: $" + order1.getOrderTotal());
        System.out.println(order2.getName()+", your total is: $" + order2.getOrderTotal());
        System.out.println(order3.getName()+", your total is: $" + order3.getOrderTotal());
        System.out.println(order4.getName()+", your total is: $" + order4.getOrderTotal());
        System.out.println(order5.getName()+", your total is: $" + order5.getOrderTotal());
        System.out.println("\n");

        // Implement the display method within the Order class
        // Finally, call the display method on all of your orders, like so: order3.display();
        order1.display();
        System.out.println("\n");

        order2.display();
        System.out.println("\n");

        order3.display();
        System.out.println("\n");

        order4.display();
        System.out.println("\n");

        order5.display();

    }
}
