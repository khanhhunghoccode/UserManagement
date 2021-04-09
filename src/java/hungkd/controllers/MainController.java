/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungkd.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class MainController extends HttpServlet {
    private static final String INVALID = "invalid.jsp";
    private static final String LOGIN = "LoginController";
    private static final String LOGOUT = "LogoutController";
    private static final String SEARCH = "SearchController";
    private static final String DELETE = "DeleteController";
    private static final String UPDATE_PAGE = "update.jsp";
    private static final String UPDATE = "UpdateController";
    private static final String SIGN_UP = "createUser.jsp";
    private static final String CREATE = "CreateController";
    private static final String SHOPPING = "shopping.jsp";
    private static final String ADD = "AddController";
    private static final String VIEW_CART = "viewCart.jsp";
    private static final String REMOVE = "RemoveController";
    private static final String EDIT = "EditController";
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
        String url = INVALID;
        try {
            String action = request.getParameter("btnAction");
            if ("Login".equals(action)) {
                url = LOGIN;
            } else if ("Logout".equals(action)) {
                url = LOGOUT;
            } else if ("Search".equals(action)) {
                url = SEARCH;
            } else if ("Delete".equals(action)) {
                url = DELETE;
            }else if ("Update".equals(action)) {
                url = UPDATE_PAGE;
            }else if ("Update User".equals(action)) {
                url = UPDATE;
            }else if ("SignUp".equals(action)) {
                url = SIGN_UP;
            }else if ("Create".equals(action)) {
                url = CREATE;
            }else if ("Shopping".equals(action)) {
                url = SHOPPING;
            }else if ("Choose".equals(action)) {
                url = ADD;
            }else if ("View".equals(action)) {
                url = VIEW_CART;
            }else if ("Remove".equals(action)) {
                url = REMOVE;
            }else if ("Edit".equals(action)) {
                url = EDIT;
            }
        } catch (Exception e) {
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
