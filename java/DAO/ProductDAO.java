/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Domain.Product;
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
    
    public void insertProduct(String name, String type, String desc, String unitprice) throws SQLException {
        Connection con = new DBConnection().getConnection();
        Statement instr = con.createStatement();

        String sql = "INSERT INTO products (name, type, description, unitprice) VALUES ('"+name+"','"+type+"','"+desc+"','"+unitprice+"');";
        instr.executeUpdate(sql);
    }
    
    public boolean prodExists(String name) throws SQLException {

        Connection con = new DBConnection().getConnection();
        Statement instr = con.createStatement();
        String sql = "SELECT * FROM users.products";
        ResultSet rs = instr.executeQuery(sql);

        if (rs == null) {
            return false;
        }
        while (rs.next()) {
            if (name.equals(rs.getString(1))) {
                return true;
            }
        }
        return false;
    }
}
