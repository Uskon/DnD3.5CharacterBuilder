<%-- 
    Document   : LoginCheck
    Created on : Apr 2, 2013, 6:38:19 PM
    Author     : Uskon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if ((username.equals("DM") && password.equals("DM"))) {
                session.setAttribute("logged", username);
                response.sendRedirect("AddNewContent.jsp");
            } else {
                session.setAttribute("loginfail", true);
                response.sendRedirect("Login.jsp");
            }
        %>
    </body>
</html>
