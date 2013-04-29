<%-- 
    Document   : RemoveRuleSet
    Created on : Apr 26, 2013, 8:39:51 PM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remove ${ruleset.name}, (${ruleset.fullname}) </title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
    </head>
    <body>
        <h1>You are currently trying to remove the Rule Set ${ruleset.name}, (${ruleset.fullname})</h1>
        <b><p>The Rule Set and <b>ALL</b> components connected to it will be removed!</p>
        <p>This may potentially delete a very large number of components!</p>
        <p>Really, don't do this unless you're absolutely certain</p></b>
        <fieldset class="inputbox" style="width:100px">
            <form action="${pageContext.request.contextPath}/ConfirmRuleSetRemoval"
                  method="post">
                <p class="remove"><input type="submit" name="action" value="Remove" class="confirm"></p><br>
                <p><input type="submit" name="action" value="Cancel" class="confirm"></p>
                <input type="hidden" name="ruleset" value="${ruleset}">
            </form>
        </fieldset>
    </form>
</body>
</html>
