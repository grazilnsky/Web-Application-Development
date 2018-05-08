/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import Domain.Product;
import DAO.ProductDAO;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Web application lifecycle listener.
 *
 * @author Radu
 */
public class PurchaseListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /*try {
            Map<Product, Integer> purchases;
            String user = (String) sce.getServletContext().getAttribute("user_session");
            purchases = ProductDAO.getInstance().retrievePurchases(user);
            sce.getServletContext().setAttribute("purchases", purchases);
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseListener.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
