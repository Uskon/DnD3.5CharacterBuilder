<%-- 
    Document   : RemoveDomain
    Created on : Apr 26, 2013, 8:39:34 PM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remove ${domain.name}, (${domain.ruleSet.name}) </title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
    </head>
    <body>
        <h1>You are currently trying to remove the Domain ${domain.name}, (${domain.ruleSet.name})</h1>
        <p><b>The Domain and <b>ALL</b> components directly connected to it will be removed!</b></p>
        <fieldset class="inputbox" style="width:100px">
            <form action="${pageContext.request.contextPath}/ConfirmRemoval"
                  method="post">
                <p class="remove"><input type="submit" name="action" value="Remove" class="confirm"></p><br>
                <p><input type="submit" name="action" value="Cancel" class="confirm"></p>
                <input type="hidden" name="domain" value="${domain.id}">
                <input type="hidden" name="type" value="domain">
            </form>
        </fieldset>
    </form>
</body>
</html>
