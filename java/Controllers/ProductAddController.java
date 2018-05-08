/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.ProductDAO;
import java.util.Enumeration;
import java.util.LinkedList;

/**
 *
 * @author oana
 */
public class ProductAddController extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

        Enumeration en = request.getParameterNames();
        List<String> errors=new LinkedList<>();
        String name=null;
        String type=null;
        String desc=null;
        String price=null;
        try {
            while (en.hasMoreElements()) {
                Object objOri = en.nextElement();
                String param = (String) objOri;
                String value = request.getParameter(param);

                if ("name".equals(param)) {
                    System.out.println(value);
                    name=value;
                }
                if ("type".equals(param)) {
                    System.out.println(value);
                    type=value;
                }
                if ("description".equals(param)) {
                    System.out.println(value);
                    desc=value;
                }
                if ("unitPrice".equals(param)) {
                    System.out.println(value);
                    price=value;
                }
            }
            if(name!=null && type!=null && desc!=null && price!=null)
            {
                System.out.println("At least i'm here");
                if(ProductDAO.getInstance().prodExists(name)==false){
                    System.out.println("Product added "+name+" "+type+" "+desc+" "+price);
                    ProductDAO.getInstance().insertProduct(name, type, desc, price);
                    request.getRequestDispatcher("AddProducts.jsp").forward(request, response);
                }
            }
                else {
                    errors.add("Product already exists");
                    request.setAttribute("errors", errors);
                    request.getRequestDispatcher("AddProducts.jsp").forward(request, response);
                }
            }
         catch (SQLException ex) {
            Logger.getLogger(ProductAddController.class.getName()).log(Level.SEVERE, null, ex);
        }


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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductAddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProductAddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
