<%-- 
    Document   : createUser
    Created on : Dec 10, 2020, 9:26:07 AM
    Author     : PC
--%>

<%@page import="hungkd.dtos.UserErrorDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User</title>
    </head>
    <%
        UserErrorDTO errorUser = (UserErrorDTO) session.getAttribute("ERROR");
        if (errorUser == null) {
            errorUser = new UserErrorDTO("","","","","");
        }
    %>
    <body>
        <form action="MainController" method="POST">
            User Id <input type="text" name="txtUserID" required="true"/></br>
            <%= errorUser.getErrorUserID() %></br>
            Full Name <input type="text" name="txtFullName" required="true"/></br>
            <%= errorUser.getErrorFullName()%></br>
            Role Id <input type="text" name="txtRoleID" required="true"/></br>
            <%= errorUser.getErrorRoleID()%></br>
            Password <input type="password" name="txtPassword" required="true"/></br>            
            Confirm <input type="password" name="txtConfirm" required="true"/></br>
            <%= errorUser.getErrorConfirm()%></br>
            <input type="submit" name="btnAction" value="Create"/>
            <input type="reset" value="Reset"/>
        </form>
    </body>
</html>
