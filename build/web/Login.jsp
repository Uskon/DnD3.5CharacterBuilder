<%-- 
    Document   : Login
    Created on : Apr 2, 2013, 5:49:08 PM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <title>Login</title>
        <style>
        </style>
        <% if (session.getAttribute("logged") != null) {
            response.sendRedirect("AddNewContent.jsp");
        }%>
    </head>
    <body>
        <div class="inputfield">
            <fieldset>
                <form action="LoginCheck.jsp" method="post">
                    <br/>Username:<input type="text" name="username"><br>
                    <br/>Password:<input type="password" name="password"><br>
                    <br/>
                        <% if (session.getAttribute("loginfail") != null) {
                        %>
                        <b>Incorrect username or password</b>
                        <%} session.removeAttribute("loginfail");%>
                    <input type="submit" value="Login">
                </form>
            </fieldset>
        </div>
    </body>
</html>
