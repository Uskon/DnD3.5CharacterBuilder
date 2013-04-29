<%-- 
    Document   : ManageRaceProperties
    Created on : Apr 25, 2013, 12:18:41 PM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Race Properties</title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
    </head>
    <body>
        <h1>Choose the Race you wish to manage</h1>
        <div class="managefield">
            <fieldset class="inputbox">
                <form name="chooseRace"
                      action="${pageContext.request.contextPath}/ManageRace"
                      method="post">
                    <% if (session.getAttribute("nullRace") != null) {%>
                    <p><b>You must choose a Race before proceeding!</b></p>
                    <%}
                        session.removeAttribute("nullRace");%>
                    <c:forEach var="race" items="${racelist}">
                        <p><input type="radio" class="rbutton" name="race" value="${race.id}"/>${race.name}, ${race.ruleSet.name}</p>
                        </c:forEach>
                        <% if (request.getAttribute("racelist") != null) {%>
                    <p><input type="submit" name="selection" value="Set Feats" class="managebutton"></p>
                    <p><input type="submit" name="selection" value="Set Description" class="managebutton"></p><br>
                    <p><input type="submit" name="selection" value="Delete"class="managebutton"></p>
                        <%} else {%>
                    <p><b>No Races exist!</b></p>
                    <%}%>
                </form>
            </fieldset>
        </div>
    </body>
</html>
