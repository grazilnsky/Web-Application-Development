/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Domain.Product;
import Domain.Purchase;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PurchaseDAO {

    private static PurchaseDAO instance;

    public static PurchaseDAO getInstance() {
        if (instance == null) {
            instance = new PurchaseDAO();
        }
        return instance;
    }

    private PurchaseDAO() {
    }


    
    public List<Purchase> retrievePurchases(String uname) throws SQLException {
        List<Purchase> purchases;
        purchases = new LinkedList<>();
        List<Product> products = ProductDAO.getInstance().retrieveProducts();
        String sql = "SELECT * FROM users.purchases WHERE user= '" + uname + "';";
        Connection con = new DBConnection().getConnection();
        Statement instr = con.createStatement();

        ResultSet rs = instr.executeQuery(sql);
        while(rs.next())
        {
            for(Product p: products)
            {
                if(p.getName().equals(rs.getString(3)))
                    purchases.add(new Purchase(rs.getString(3),p, Integer.parseInt(rs.getString(4))));
            }
        }
        return purchases;
    }
    
    public void insertPurchase(String uname, String prod, int qty) throws SQLException {

        Connection con = new DBConnection().getConnection();
        Statement instr = con.createStatement();
        
        String sql="INSERT INTO purchases (user, product, quantity) VALUES ('"+uname+"','"+prod+"','"+qty+"');";
        instr.executeUpdate(sql);
    }
}