import java.util.ArrayList;
public class Order{
    // MEMBER VARIABLES
    private String name; // default value is null
    private boolean ready; // default value if false
    private ArrayList<Item> items = new ArrayList<Item>(); // default value is null

    // CONSTRUCTOR
    public Order(){
        this.name = "Guest";
        this.ready = false;
    }

    // OVERLOADED CONSTRUCTOR
    public Order(String name){
        this.name = name;
        this.ready = false;
    }

    // GETTERS
    public String getName(){
        return this.name;
    }

    public boolean getReady(){
        return this.ready;
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    // SETTERS
    public void setName(String name){
        this.name = name;
    }

    public void setReady(boolean ready){
        this.ready = ready;
    }

    public void setItems(ArrayList<Item> items){
        this.items = items;
    }

    // METHODS
    public void addItem(Item item){
        this.items.add(item);
    }

    public String getStatusMessage(){
        if (this.ready == true){
            return "Your order is ready.";
        }
        else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }

    public double getOrderTotal(){
        double total = 0.0;
        for(Item i: this.items){
            total += i.getPrice();
        }
        return total;
    }

    public void display(){
        System.out.printf("Customer Name: %s\n", this.name);
        for(Item i: this.items){
            System.out.println(i.getName() + " - $" + i.getPrice());
        }
        System.out.println("Total: $" + this.getOrderTotal());
        }
}


