<%-- 
    Document   : ManageRuleSetProperties
    Created on : Apr 25, 2013, 12:19:12 PM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Rule Set Properties</title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
    </head>
    <body>
        <h1>Choose the Rule Set you wish to manage</h1>
        <div class="managefield">
            <fieldset class="inputbox">
                <form name="chooseRuleSet"
                      action="${pageContext.request.contextPath}/ManageRuleSet"
                      method="post">
                    <% if (session.getAttribute("wrongpw") != null) {%>
                    <p><b>AUTHORIZATION FAILED</b></p>
                    <%} session.removeAttribute("wrongpw");%>
                    <% if (session.getAttribute("nullRuleSet") != null) {%>
                    <p><b>You must choose a Rule Set before proceeding!</b></p>
                    <%} session.removeAttribute("nullRuleSet"); %>
                    <c:forEach var="ruleset" items="${rulesetlist}">
                        <p><input type="radio" class="rbutton" name="ruleset" value="${ruleset.name}"/>${ruleset.name}, ${ruleset.fullname}</p>
                    </c:forEach>
                    <% if (request.getAttribute("rulesetlist") != null) {%>
                    <p><input type="submit" name="selection" value="Delete" class="managebutton"></p>
                        <%} else {%>
                    <p><b>No Rule Sets exist!</b></p>
                    <%}%>
                </form>
            </fieldset>
        </div>
    </body>
</html>
