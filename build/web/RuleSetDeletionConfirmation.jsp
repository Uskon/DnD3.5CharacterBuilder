<%-- 
    Document   : RuleSetDeletionConfirmation
    Created on : Apr 26, 2013, 10:53:27 PM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remove ${ruleset.name}, (${ruleset.fullname}) </title>
        <%@ include file="loginchecker.jsp" %>
        <style>
            body {
                background-color:black;
                font-size:x-large;
            }
            button {
                font-size:large;
            }
        </style>
    </head>
    <body>
        <div align="center">
            <h1 style="color:white;">DELETE <br> ${ruleset.name}, ${ruleset.fullname}</h1>
            <fieldset style="width:300px;background-color:#FFFFF0;">
                <form action="${pageContext.request.contextPath}/ConfirmRemoval"
                      method="post">
                    <p>Enter the Master Password: <input type="password" name="confirmation" value="pw"></p>
                    <p><button type="submit" name="action" value="Remove" class="confirm" style="width:100px;height:100px;background-color:red;border-color:black;float:left;">DELETE</button>
                    <button type="submit" name="action" value="Cancel" class="confirm" style="width:100px;height:100px;border-color:black;float:right;">CANCEL</button></p>
                    <input type="hidden" name="ruleset" value="${ruleset.name}">
                    <input type="hidden" name="type" value="ruleset">
                </form>
            </fieldset>
        </div>
    </form>
</body>
</html>