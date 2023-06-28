/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.DAO;
import dao.Dog;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LoadMoreControl", urlPatterns = {"/loadmore"})
public class LoadMoreControl extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String index = request.getParameter("exits");
        int indexs = Integer.parseInt(index);
        DAO dao = new DAO();
        List<Dog> list = dao.getNext3Dog(indexs);

        PrintWriter out = response.getWriter();
        for (Dog o : list) {
            out.println("<div class=\"product row wow fadeIn\"> <!-- tu day -->\n"
                    + "\n"
                    + "                            <!--Grid column-->\n"
                    + "                            <div class=\"col-md-6 mb-4\">\n"
                    + "\n"
                    + "                                <img src=\"" + o.getImage() + "\" class=\"img-fluid\" alt=\"\">\n"
                    + "\n"
                    + "                            </div>\n"
                    + "                            <!--Grid column-->\n"
                    + "\n"
                    + "                            <!--Grid column-->\n"
                    + "                            <div class=\"col-md-6 mb-4\">\n"
                    + "\n"
                    + "                                <!--Content-->\n"
                    + "                                <div class=\"p-4\">\n"
                    + "\n"
                    + "                                    <div class=\"mb-3\">\n"
                    + "                                        <a href=\"#\" onclick=\"description1()\">\n"
                    + "                                            <span class=\"badge purple mr-1\">Description</span>\n"
                    + "                                        </a>\n"
                    + "                                        <a href=\"#\"  onclick=\"alimetation1()\">\n"
                    + "                                            <span class=\"badge blue mr-1\">Alimentation</span>\n"
                    + "                                        </a>\n"
                    + "\n"
                    + "                                    </div>\n"
                    + "\n"
                    + "                                    <p class=\"lead\">\n"
                    + "                                        <span style=\"font-family: 'RocknRoll One', sans-serif; font-weight: bold; font-size: 30px\">" + o.getName() + "</span>\n"
                    + "                                        <br>\n"
                    + "                                        <span style=\"background: greenyellow\">" + o.getPrice() + "$</span>\n"
                    + "                                    </p>\n"
                    + "\n"
                    + "                                    <p class=\"lead font-weight-bold\">Description</p>\n"
                    + "\n"
                    + "                                    <p class=\"p1\" style=\"display: block\">" + o.getDescription() + "</p>\n"
                    + "                                    <p class =\"p1\" style=\"display: none\">$" + o.getAlimentation() + "</p>\n"
                    + "\n"
                    + "                                    <form class=\"d-flex justify-content-left\">\n"
                    + "                                        <!-- Default input -->\n"
                    + "                                        <input type=\"number\" value=\"1\" aria-label=\"Search\" class=\"form-control\" style=\"width: 100px\">\n"
                    + "                                        <button class=\"btn btn-primary btn-md my-0 p\" type=\"submit\">Add to cart\n"
                    + "                                            <i class=\"fas fa-shopping-cart ml-1\"></i>\n"
                    + "                                        </button>\n"
                    + "\n"
                    + "                                    </form>\n"
                    + "\n"
                    + "                                </div>\n"
                    + "                                <!--Content-->\n"
                    + "\n"
                    + "\n"
                    + "                            </div>\n"
                    + "                            <!--Grid column-->\n"
                    + "\n"
                    + "    </div>\n"
                    + "                        <!--Grid row-->\n"
                    + "\n"
                    + "                        <hr>\n"
                    + "                        <!-- den day -->"
                    + "                     </div>");
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
