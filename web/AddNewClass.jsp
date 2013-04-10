<%-- 
    Document   : AddNewClass
    Created on : Mar 31, 2013, 10:42:49 PM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
    </head>
    <body>
        <h1>Input the information for the class to be added</h1>
        <div class="inputfield">
            <fieldset class="inputbox">
                <form name="newClass"
                      action="${pageContext.request.contextPath}/AddClass"
                      method="post">
                    Class Name: <input type="text" name="className"/><br>
                    <br>Source: <input type="text" name="rset"/> <br>
                    <br><input type="submit" value="Send"/>
                </form>
            </fieldset>
        </div>      
        <h2>Existing Classes:</h2>
        <table border ="1">     
            <tr>
                <th>Class Name</th>
                <th>Rule Set</th>
            </tr>
            <c:forEach var="Class" items="${classlist}">
                <tr>
                    <td>${Class.name}</td>
                    <td>${Class.ruleSet.name}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
