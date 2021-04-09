<%-- 
    Document   : update
    Created on : Dec 10, 2020, 7:29:04 AM
    Author     : PC
--%>

<%@page import="hungkd.dtos.UserErrorDTO"%>
<%@page import="hungkd.dtos.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
        <%
            String userID = request.getParameter("txtUserID") == null?"":request.getParameter("txtUserID");
            String fullName = request.getParameter("txtFullName") == null?"":request.getParameter("txtFullName");
            String roleID = request.getParameter("txtRoleID") == null?"":request.getParameter("txtRoleID"); 
            String search = request.getParameter("txtSearch") == null?"":request.getParameter("txtSearch");
        %>
            <h1>Welcome: <%= ((UserDTO) session.getAttribute("LOGIN_USER")).getFullName()%></h1>
        <%
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user == null || !"AD".equals(user.getRoleID())) {
                response.sendRedirect("login.html");
            }
            UserErrorDTO errorUser = (UserErrorDTO) request.getAttribute("ERROR_UPDATE");
            if (errorUser == null) {
                errorUser = new UserErrorDTO("", "", "", "");
            }
        %>
        <a href="MainController?btnAction=Logout">Logout</a>
            <form action="MainController">
                User ID <input type="text" name="userID" value="<%= userID %>" readonly="true"/><br/>
                Full Name <input type="text" name="fullName" value="<%= fullName %>" required="true"/>
                <font color="red"><%= errorUser.getErrorFullName() %></font><br/>
                Role ID <input type="text" name="roleID" value="<%= roleID %>" required="true"/>
                <font color="red"><%= errorUser.getErrorRoleID()%></font><br/>
                <input type="hidden" name="txtSearch" value="<%= search %>"/>
                <input type="submit" name="btnAction" value="Update User"/>
                <input type="reset" value="Reset"/>
            </form>
    </body>
</html>
