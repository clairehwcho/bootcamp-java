public class Item {
    // member variables
    private String name;
    private double price;

    // constructor
    // Takes a name and price as arguments
    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

    // getters for name and price
    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    //  setter for name and price
    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
    this.price = price;
    }
}