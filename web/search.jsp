<%-- 
    Document   : search
    Created on : Dec 9, 2020, 9:22:50 AM
    Author     : PC
--%>

<%@page import="java.util.List"%>
<%@page import="hungkd.dtos.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <h1>Welcome: <%= ((UserDTO) session.getAttribute("LOGIN_USER")).getFullName()%></h1>
        <%
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user == null || !"AD".equals(user.getRoleID())) {
                response.sendRedirect("login.html");
            }
            String search = request.getParameter("txtSearch");
            if (search == null){
                search = "";
            }
        %>
        <a href="MainController?btnAction=Logout">Logout</a>
        <form action="MainController">
            Search <input type="text" name="txtSearch" value="<%= search %>"/>
            <input type="submit" name="btnAction" value="Search"/>
        </form>
        <%
            List<UserDTO> list = (List<UserDTO>) request.getAttribute("LIST_USER");
            if (list != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>User ID</th>
                    <th>Full Name</th>
                    <th>Password</th>
                    <th>Role ID</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (UserDTO dto : list) {
                %>
                <tr>
                    <td><%= ++count%></td>
                    <td><%= dto.getUserID()%></td>
                    <td><%= dto.getFullName()%></td>
                    <td><%= dto.getPassword()%></td>
                    <td><%= dto.getRoleID()%></td>
                    <td><a href="MainController?btnAction=Delete&txtSearch=<%= search %>&txtUserID=<%= dto.getUserID() %>">Delete</a></td>
                           <td><form action="MainController">
                                   <input type="hidden" name="txtUserID" value="<%= dto.getUserID() %>"/>
                                   <input type="hidden" name="txtFullName" value="<%= dto.getFullName()%>"/>
                                   <input type="hidden" name="txtRoleID" value="<%= dto.getRoleID()%>"/>
                                   <input type="hidden" name="txtSearch" value="<%= search %>"/>
                                   <input type="submit" name="btnAction" value="Update"/>
                               </form></td>
                </tr>
                <%
                    }
                %>
                <%
                    }
                %>
                
            </tbody>
        </table>

    </body>
</html>
