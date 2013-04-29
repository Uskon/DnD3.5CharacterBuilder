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
        <h1>Input the information for the Rule Set to be added</h1>
        <div class="bigdiv">
            <div class="leftside">
                <div class="inputfield">
                    <fieldset class="inputbox">
                        <form name="newRuleSet"
                              action="${pageContext.request.contextPath}/AddRuleSet"
                              method="post">
                            <p class="p1">Abbreviation: <input type="text" name="rsetName" class="textinput"/></p>
                            <p>Rule Set Name: <input type="text" name="rsetFullname" class="textinput"/></p>
                            <p><input type="submit" value="Send"/></p>
                            <% if (request.getAttribute("inputSuccessful") != null) {%>
                            <p>The Rule Set has been added successfully</p>
                            <%}%>
                            <% if (request.getAttribute("badInput") != null) {%>
                            <b><p>Please use non-null values that do not already exist in the list below</p></b>
                            <%}%>
                        </form>
                    </fieldset>
                </div>
            </div>
            <div class="info">
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
                        </tr>
                        </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
