/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.Account;
import dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LoginControl", urlPatterns = {"/login"})
public class LoginControl extends HttpServlet {

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
//        processRequest(request, response);
//b1: get user, pass from cookie
        Cookie arr[] = request.getCookies();
        if(arr != null){
        for (Cookie o : arr) {
            if(o.getName().equals("userC")){
                request.setAttribute("user", o.getValue());
            }
            if(o.getName().equals("passC")){
                request.setAttribute("pass", o.getValue());
            }
        }
        }
        //b2: load user,pass to login form
         request.getRequestDispatcher("Login.jsp").forward(request, response);
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
//        processRequest(request, response);
        
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String remember = request.getParameter("remember");
        //b1: set data to jsp
        DAO dao = new DAO();
        Account a = dao.login(user, pass);
        
        if (a!=null) {
             HttpSession session = request.getSession();
             session.setAttribute("acc", a);
             
             //luu account len tren cookie
            Cookie u = new Cookie("userC", user);
            Cookie p = new Cookie("passC", pass);
            u.setMaxAge(60*60);
            
            if(remember!=null){
              p.setMaxAge(60);
            }else{
                p.setMaxAge(0);
            }
            
            response.addCookie(u);//luu u va p len tren chrome  
            response.addCookie(p);
            response.sendRedirect("home");
        } else {
            request.setAttribute("mess", "Wrong username or password");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
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
