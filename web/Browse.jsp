<%-- 
    Document   : Browse
    Created on : Apr 12, 2013, 2:15:29 PM
    Author     : Uskon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Character Component Browser</title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="publicnav.jsp" %>
    </head>
    <body>
        <h1>Choose the type of component</h1>
        <form name="browse"
              action="${pageContext.request.contextPath}/Browse"
              method="post">
            <select name="componentType" style="float:left">
            <option value="ruleSet">Rule Set</option>
            <option value="race">Race</option>
            <option value="class">Class</option>
            <option value="feat">Feat</option>
            <option value="skill">Skill</option>
            </select>
            <input type="submit" value="Browse" style ="float:left; margin-left:50px"><br>
        </form>
              
              <% if (request.getAttribute("type") != null) {%>
              <form name="browseByType"
                    action="${pageContext.request.contextPath}/Browse"
                    method="post">
                  <br> Name: <input type="text" name="name">
              </form>
              <%}%>
    </body>
</html>
