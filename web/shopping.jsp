<%-- 
    Document   : shopping
    Created on : Dec 11, 2020, 8:07:31 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Milk Tea Page</title>
    </head>
    <body>
        <h1>Welcome to my Store!</h1>
        <form action="MainController">
            Choose your milk tea:
            <select name="cmbTea">
                <option value="T01-Peach Milk Tea-10">Peach Tea</option>
                <option value="T02-Banana Tea-50">Banana Tea</option>
                <option value="T03-Apple Special Tea-100">Apple Tea</option>
            </select>
            <input type="submit" name="btnAction" value="Choose"/>
            <input type="submit" name="btnAction" value="View"/>
        </form>
        <% 
        String message = (String) request.getAttribute("message");
        if(message == null) {
            message = "";
        }
        %>
        <%= message %>
    </body>
</html>
