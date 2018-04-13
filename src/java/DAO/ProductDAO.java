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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDAO {

    private static ProductDAO instance;

    public static ProductDAO getInstance() {
        if (instance == null) {
            instance = new ProductDAO();
        }
        return instance;
    }

    private ProductDAO() {
    }

    public List<Product> retrieveProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM users.products";
        Connection con = new DBConnection().getConnection();
        Statement instr = con.createStatement();

        ResultSet rs = instr.executeQuery(sql);
        while (rs.next()) {
            Product p;
            p = new Product(rs.getString(2), rs.getString(3), rs.getString(4), Integer.parseInt(rs.getString(5)));
            products.add(p);
        }
        return products;
    }
    
    /*public Map<Product,Integer> retrievePurchases(String uname) throws SQLException {
        Map<Product,Integer> purchases;
        purchases = new HashMap<>();
        List<Product> products = retrieveProducts();
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
    }*/
}
