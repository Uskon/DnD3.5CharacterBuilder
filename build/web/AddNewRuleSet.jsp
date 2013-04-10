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
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
    </head>
    <body>
         <h1>Input the information for the rule set to be added</h1>
        <div class="inputfield">
            <fieldset class="inputbox">
        <form name="newRuleSet"
              action="${pageContext.request.contextPath}/AddRuleSet"
              method="post">
            Rule Set Abbreviation: <input id="field1" type="text" name="rsetName"/> <br/>
            <br>Rule Set Name: <input type="text" name="rsetFullname"/><br>
            <br><input type="submit" value="Send"/>
        </form>
            </fieldset>
        </div>
              <h2>Existing Rule Sets:</h2>
        <table border ="1">     
            <tr>
                <th>Rule Set</th>
                <th>Full name</th>
            </tr>
            <c:forEach var="RuleSet" items="${rsetList}">
                <tr>
                    <td>${RuleSet.name}</td>
                    <td>${RuleSet.fullname}</td>
            </c:forEach>
        </table>
    </body>
</html>
