<%-- 
    Document   : ManageDomainProperties
    Created on : Apr 24, 2013, 6:30:50 PM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Domain Properties</title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
    </head>
    <body>
        <h1>Choose the Domain you wish to manage</h1>
        <div class="managefield">
            <fieldset class="inputbox">
                <form name="chooseDomain"
                      action="${pageContext.request.contextPath}/ManageDomain"
                      method="post">
                    <% if (session.getAttribute("nullDomain") != null) {%>
                    <p><b>You must choose a Domain before proceeding!</b></p>
                    <%} session.removeAttribute("nullDomain"); %>
                    <c:forEach var="domain" items="${domainlist}">
                        <p><input type="radio" class="rbutton" name="domain" value="${domain.id}"/>${domain.name}, ${domain.ruleSet.name}</p>
                    </c:forEach>
                    <% if (request.getAttribute("domainlist") != null) {%>
                    <p><input type="submit" name="selection" value="Set Feats" class="managebutton"></p><br>
                    <p><input type="submit" name="selection" value="Delete"class="managebutton"></p>
                        <%} else {%>
                    <p><b>No Domains exist!</b></p>
                    <%}%>
                </form>
            </fieldset>
        </div>
    </body>
</html>