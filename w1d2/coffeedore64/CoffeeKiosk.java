import java.util.ArrayList;
public class CoffeeKiosk {
    // MEMBER VARIABLES
    private ArrayList<Item> menu = new ArrayList<Item>();
    private ArrayList<Order> orders = new ArrayList<Order>();

    // CONSTRUCTORS
    public CoffeeKiosk(){

    }

    // METHODS
    /*
    The addMenuItem method should create a new item object with the given name and price.
    Add the new Item object to the menu items array.
    The new menu item itself will also need to be assigned an index property.
    The value should be its position, its index, in the menu array.
    */
    public void addMenuItem(String name, double price){
        Item newItem = new Item(name, price);
        menu.add(newItem);
        int index = menu.indexOf(newItem);
        newItem.setIndex(index);
        System.out.println("You have added " + newItem.getName() + " to the menu.");
    }
    // The indexOf() method returns the position of the first occurrence of specified character(s) in a string.

    /*
    Now with an array of items you can display the menu without needing separate arrays of names and prices!
    The displayMenu method should display all of the items from the menu array like so:
    0 banana -- $2.00
    1 coffee -- $1.50
    2 latte -- $4.50
    3 capuccino -- $3.00
    4 muffin -- $4.00
    */
    public void displayMenu(){
        for (Item i: this.menu){
            System.out.println(i.getIndex() + " " + i.getName() + " -- $" + i.getPrice());
        }
    }

    /*
    The newOrder method will take input from the user in the terminal to create a new order instance
    and add it to the orders array. We have given you some code to get you started.
    Tips:
    The console input will be of type String, no matter what the user types into the console.
    You can use the built in String .equals() method to do string comparison,
    rather than the == comparison operator.
    To cast the string to an integer, use the Integer.parseInt() method.
    The parseInt function converts its first argument to a string, parses that string, then returns an integer or NaN .
    If not NaN , the return value will be the integer that is the first argument taken as a number in the specified radix .
    */
    public void newOrder() {

        // Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();

        // Your code:
        // Create a new order with the given input string
        // Show the user the menu, so they can choose items to add.
        Order newOrder = new Order(name);
        displayMenu();

        // Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();

        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {

            // Get the item object from the menu, and add the item to the order
            // get() is an inbuilt method in Java and is used to return the element at a given index from the specified Array.
            int i = Integer.parseInt(itemNumber);
            if (i < this.menu.size()){
                Item orderItem = menu.get(i);
                newOrder.addItem(orderItem);
                System.out.println("You have added " + orderItem.getName() + " to your order.");
            }
            else {
                System.out.println("Sorry we do not have it");
            }
            // Ask them to enter a new item index or q again, and take their input
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();
        }
        // After you have collected their order, print the order details
        newOrder.display();
        this.orders.add(newOrder);


        // as the example below. You may use the order's display method.

    }
}
