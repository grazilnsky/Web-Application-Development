package Domain;

public class Product {
    String name;
    String type;
    String description;
    int price;
    
    
    public Product(String n, String t, String desc, int p) {
        this.name=n;
        this.type=t;
        this.description=desc;
        this.price=p;
    }
    
    public String display() {
        return "Name: " + this.name + ", Type: "+this.type + ", Descrpition: " + this.description + ", Price: " + this.price;
    }
    
    public int getPrice() {
        return this.price;
    }
    
    
    public String getName()
    {
        return this.name;
    }
}
