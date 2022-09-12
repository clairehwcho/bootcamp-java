import java.util.ArrayList;
public class Order{
    // member variables
    private String name; // default value is null
    private boolean ready; // default value if false
    private ArrayList<Item> items = new ArrayList<Item>(); // default value is null

    // constructor
    // no arguments, sets name to "Guest", initializes items as an empty list
    public Order(){
        this.name = "Guest";
        this.ready = false;
    }

    // overloaded contructor
    // takes a name as an argument, sets name to this custom name
    // initializes items as an empty list
    public Order(String name){
        this.name = name;
        this.ready = false;
    }

    // order methods
    // most of your code will go here,
    // so implement the getters and setters first!

    /*
    Create a method called addItem that takes an Item object as an argument
    and adds the item to the order's items array.
    No need to return anything.
    Hint: How do you get the price of a given item instance from outside the Item class?
    */
    public void addItem(Item item){
        this.items.add(item);
    }

    /*
    Create a method called getStatusMessage that returns a String message.
    If the order is ready, return "Your order is ready.",
    if not, return "Thank you for waiting. Your order will be ready soon."
    */
    public String getStatusMessage(){
        if (this.ready == true){
            return "Your order is ready.";
        }
        else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }

    /*
    Similar to the getOrderTotal method from the Cafe Business Logic assignment,
    create a method called getOrderTotal that sums together each of the item's prices,
    and returns the total amount.
    Note: This time, you do not need to pass in a list of prices,
    because each item object in this order's items array has its own price, that you can access using a getter!
    */
    public double getOrderTotal(){
        double total = 0.0;
        for(Item i: this.items){
            total += i.getPrice();
        }
        return total;
    }

    /*
    Similar to the displayMenu function from the Cafe Business Logic assignment,
    create a method called display that prints out the order information like so:
    Customer Name: Cindhuri
    drip coffee - $1.50
    capuccino - $3.50
    Total: $5.00

    */
    public void display(){
        System.out.printf("Customer Name: %s\n", this.name);
        for(Item i: this.items){
            System.out.println(i.getName() + " - $" + i.getPrice());
        }
        System.out.println("Total: $" + this.getOrderTotal());
        }

    // getters
    public String getName(){
        return this.name;
    }

    public boolean getReady(){
        return this.ready;
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    // setters
    public void setName(String name){
        this.name = name;
    }

    public void setReady(boolean ready){
        this.ready = ready;
    }

    public void setItems(ArrayList<Item> items){
        this.items = items;
    }
}

