/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

public class Purchase {
    private String user;
    private Product product;
    private int quantity;
    
    public Purchase(String u, Product p, int q){
        this.user=u;
        this.product=p;
        this.quantity=q;
    }
    
    public String getUser() {
        return this.user;
    }
    
    public Product getProduct(){
        return this.product;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    
    public String display(){
        return this.product.getName()+ ", "+this.quantity;
    }
    
    public String buy() {
        return this.product.getName()+ ", "+this.product.getPrice()*this.quantity;
    }
}
