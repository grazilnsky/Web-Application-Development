/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Classes.Product;
import DAO.PurchaseDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Radu
 */
public class BuyController extends HttpServlet {

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
        Map<Product, String> toBeDisplayed;
        toBeDisplayed = new HashMap<>();
        List<Product> products;
        products = (List<Product>) this.getServletContext().getAttribute("products");

        try {
            if (request.getSession().getAttribute("user_session") != null) {
                int i = 0;
                String uname = (String) request.getSession().getAttribute("user_session");
                while (en.hasMoreElements()) {
                    Object objOri = en.nextElement();
                    System.out.println("NEXT");
                    String param = (String) objOri;
                    int value = Integer.parseInt(request.getParameter(param));
                    if (value != 0) {
                        toBeDisplayed.put(products.get(i), products.get(i).buy(value));
                        PurchaseDAO.getInstance().insertPurchase(uname, products.get(i).getName(), value);
                    }
                    i++;
                }
                request.setAttribute("transaction", toBeDisplayed);
                request.getRequestDispatcher("TransactionView.jsp").forward(request, response);
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(BuyController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
