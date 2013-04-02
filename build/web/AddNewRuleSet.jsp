<%-- 
    Document   : AddRuleSet
    Created on : Mar 29, 2013, 6:37:37 PM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a new Rule Set</title>
    </head>
    <body>
        <form name="newRuleSet"
              action="${pageContext.request.contextPath}/AddRuleSet"
              method="post">
            Rule Set Name: <input id="field1" type="text" name="rsetName"/> <br/>
            <input type="submit" value="Send"/>
        </form>
              <h2>Existing Rule Sets:</h2>
        <table border ="1">     
            <tr>
                <th>Rule Set</th>
            </tr>
            <c:forEach var="RuleSet" items="${rsetList}">
                <tr>
                    <td>${RuleSet.name}</td>
            </c:forEach>
        </table>
    </body>
</html>
