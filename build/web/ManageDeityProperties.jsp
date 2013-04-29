<%-- 
    Document   : ManageDeityProperties
    Created on : Apr 24, 2013, 5:23:56 PM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Deity Properties</title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
    </head>
    <body>
        <h1>Choose the Deity you wish to manage</h1>
        <div class="managefield">
            <fieldset class="inputbox">
                <form name="chooseDeity"
                      action="${pageContext.request.contextPath}/ManageDeity"
                      method="post">
                    <% if (session.getAttribute("nullDeity") != null) {%>
                    <p><b>You must choose a Deity before proceeding!</b></p>
                    <%} session.removeAttribute("nullDeity"); %>
                    <c:forEach var="deity" items="${deitylist}">
                        <p><input type="radio" class="rbutton" name="deity" value="${deity.id}"/>${deity.name}, ${deity.ruleSet.name}</p>
                    </c:forEach>
                    <% if (request.getAttribute("deitylist") != null) {%>
                    <p><input type="submit" name="selection" value="Set Domains" class="managebutton"></p><br>
                    <p><input type="submit" name="selection" value="Delete" class="managebutton"></p>
                        <%} else {%>
                    <p><b>No Deities exist!</b></p>
                    <%}%>
                </form>
            </fieldset>
        </div>
    </body>
</html>
