package model;

public class Product  {
    protected int id;
    protected String name;
    protected double price;
    protected int quantity;
    protected String description;

    public Product(int id, String name, double price, int quantity, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }



    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }



    public double getPrice() {
        return price;
    }




    @Override
    public String toString() {
        return  id + "," + name + "," + price + "," + quantity + "," + description;
    }
}
