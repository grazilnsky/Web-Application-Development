/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Product;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    
    public Map<Product,Integer> retrievePurchases(String uname) throws SQLException {
        Map<Product,Integer> purchases;
        purchases = new HashMap<>();
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
                    purchases.put(p, Integer.parseInt(rs.getString(4)));
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