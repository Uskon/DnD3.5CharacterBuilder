<%-- 
    Document   : ManageFeatProperties
    Created on : Apr 24, 2013, 12:21:30 PM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Feat Properties</title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
    </head>
    <body>
        <h1>Choose the Feat you wish to manage</h1>
        <div class="managefield">
            <fieldset class="inputbox">
                <form name="chooseFeat"
                      action="${pageContext.request.contextPath}/ManageFeat"
                      method="post">
                    <% if (session.getAttribute("nullFeat") != null) {%>
                    <p><b>You must choose a Feat before proceeding!</b></p>
                    <%} session.removeAttribute("nullFeat"); 
                    if (session.getAttribute("outdated") != null) {%>
                        <p><b>The page you were viewing appears to have been outdated</b></p>
                        <%} session.removeAttribute("outdated");%>
                    <c:forEach var="feat" items="${featlist}">
                        <p><input type="radio" class="rbutton" name="feat" value="${feat.id}"/>${feat.name}, ${feat.ruleSet.name}</p>
                    </c:forEach>
                    <% if (request.getAttribute("featlist") != null) {%>
                    <p class="p1"><input type="submit" name="selection" value="Set Requirements" class="managebutton">
                    <input type="submit" name="selection" value="Set Description"class="managebutton"></p><br>
                    <p><input type="submit" name="selection" value="Delete" class="managebutton"></p>
                        <%} else {%>
                    <p><b>No Feats exist!</b></p>
                    <%}%>
                </form>
            </fieldset>
        </div>
    </body>
</html>
