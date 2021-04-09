<%-- 
    Document   : viewCart
    Created on : Dec 11, 2020, 9:06:48 AM
    Author     : PC
--%>

<%@page import="hungkd.daos.TeaDTO"%>
<%@page import="hungkd.daos.CartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Page</title>
    </head>
    <body>
        <h1>Your shopping cart:</h1>
        <%
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            if (cart != null) {
                double total = 0;
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (TeaDTO tea : cart.getCart().values()) {
                        total += tea.getQuantity() * tea.getPrice();
                %>
            <form ation="MainController">
                <tr>
                    <td><%= ++count%></td>
                    <td><input type="text" name="txtID" value="<%= tea.getId()%>" readonly="true"/></td>
                    <td><%= tea.getName()%></td>
                    <td><input type="text" name="txtQuantity" value="<%= tea.getQuantity() %>" required="true"</td>
                    <td><%= tea.getPrice()%></td>
                    <td><%= tea.getQuantity() * tea.getPrice()%></td>
                    <td><input type="submit" name="btnAction" value="Remove"/></td>
                    <td><input type="submit" name="btnAction" value="Edit"/></td>
                </tr>
            </form>
            <%
                }
            %>
        </tbody>
    </table>
    <h3>Total: <%= total%></h3>
    <%
        }
    %>
    <a href="shopping.jsp">Back to shop</a>
    <br/>
    <a href="login.html">Logout</a>
</body>
</html>
