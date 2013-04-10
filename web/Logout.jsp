<%-- 
    Document   : Logout
    Created on : Apr 2, 2013, 5:49:15 PM
    Author     : Uskon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logging out</title>
    </head>
    <body>
        <%
            session.removeAttribute("username");
            session.removeAttribute("password");
            session.invalidate();
        %>
        
        <p>Successfully logged out.</p>

        <%
            response.sendRedirect("index.jsp");
        %>
    </body>
</html>
