/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Domain.Product;
import DAO.PurchaseDAO;
import Domain.Purchase;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Radu
 */
@WebServlet(name = "CartController", urlPatterns = {"/CartController"})
public class CartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Enumeration en = request.getParameterNames();
        
        List<Purchase> cart=new LinkedList<>();

        if(request.getSession().getAttribute("shopping_cart")!=null)
            cart = (List<Purchase>)(request.getSession().getAttribute("shopping_cart"));
        
        List<Product> products;
        List<String> errors = new LinkedList<>();
        products = (List<Product>) this.getServletContext().getAttribute("products");

        //try {
            if (request.getSession().getAttribute("user_session") != null) {
                int i = 0;
                String uname = (String) request.getSession().getAttribute("user_session");
                while (en.hasMoreElements()) {
                    Object objOri = en.nextElement();
                    String param = (String) objOri;
                    int value = Integer.parseInt(request.getParameter(param));
                    if (value != 0) {
                        cart.add(new Purchase(uname,products.get(i), value));
                        //PurchaseDAO.getInstance().insertPurchase(uname, products.get(i).getName(), value);
                    }
                    i++;
                }
                //request.setAttribute("transaction", cart);
                request.getSession().setAttribute("shopping_cart", cart);
                request.getRequestDispatcher("ShoppingCartView.jsp").forward(request, response);
            }
            if(request.getSession().getAttribute("user_session")==null)
            {
                errors.add("You must be logged in to view your shopping cart.");
                request.setAttribute("errors", errors);
                request.getRequestDispatcher("LoginView.jsp").forward(request, response);
            }
        //} 
        /*catch (SQLException ex) {
            Logger.getLogger(BuyController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
