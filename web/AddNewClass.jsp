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
    </head>
    <body>
        <form name="newClass"
              action="${pageContext.request.contextPath}/AddClass"
              method="post">
            Class Name: <input id="field1" type="text" name="className"/> <br/>
            Source: <input type="text" name="rset"/> <br/>
            <input type="submit" value="Send"/>
        </form>
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
