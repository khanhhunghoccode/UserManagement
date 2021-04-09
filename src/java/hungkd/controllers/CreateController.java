/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungkd.controllers;

import hungkd.daos.UserDAO;
import hungkd.dtos.UserDTO;
import hungkd.dtos.UserErrorDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PC
 */
public class CreateController extends HttpServlet {
    private static final String ERROR = "createUser.jsp";
    private static final String SUCCESS = "login.html";
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
        String url = ERROR;
        UserErrorDTO errorUser = new UserErrorDTO("", "", "", "", "");
        try {
            String userID = request.getParameter("txtUserID");
            String fullName = request.getParameter("txtFullName");
            String roleID = request.getParameter("txtRoleID");
            String password = request.getParameter("txtPassword");
            String confirm = request.getParameter("txtConfirm");
            boolean check = true;
            if (userID.length() < 6 || userID.length() > 50) {
                check = false;
                errorUser.setErrorUserID("User ID in [6,50]");
            }
            if (fullName.length() < 10 || fullName.length() > 50) {
                check = false;
                errorUser.setErrorFullName("Full name in [10,50]");
            }
            if (roleID.length() < 2 || roleID.length() > 50) {
                check = false;
                errorUser.setErrorRoleID("Role ID in [2,50]");
            }
            if (!password.equals(confirm)) {
                check = false;
                errorUser.setErrorConfirm("Hai password ko giong nhau");
            }
            UserDAO dao = new UserDAO();
//            boolean checkDuplicate = dao.checkDuplicate(userID);
//            if (!checkDuplicate) {
//                check = false;
//                errorUser.setErrorUserID("Duplicate User ID");
//            }
            if (check) {
                UserDTO user = new UserDTO(userID, fullName, password, roleID);
                dao.insertUser_Throw(user);
                url = SUCCESS;
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("ERROR", errorUser);
            }
        } catch (Exception e) {
            String errorStr = e.toString();
            if (errorStr.contains("duplicate")) {
                errorUser.setErrorUserID("Duplicate User ID");
                HttpSession session = request.getSession();
                session.setAttribute("ERROR", errorUser);
            }
        } finally {
            response.sendRedirect(url);
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
