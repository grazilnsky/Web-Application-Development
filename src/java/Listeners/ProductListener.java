/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import Classes.Product;
import DAO.ProductDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ProductListener implements
        ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            List<Product> products;
            products = ProductDAO.getInstance().retrieveProducts();
            sce.getServletContext().setAttribute("products", products);
        } catch (SQLException ex) {
            Logger.getLogger(ProductListener.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
