<%-- 
    Document   : AddNewSkill
    Created on : Mar 30, 2013, 4:57:00 PM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a new Skill</title>
    </head>
    <body>
        <form name="newSkill"
              action="${pageContext.request.contextPath}/AddSkill"
              method="post">
            Skill Name: <input id="field1" type="text" name="skillName"/> <br>
            Source: <input id="field1" type="text" name="rset"/> <br>
            <input type="submit" value="Send"/>
        </form>
              
              <h2>Existing Skills:</h2>
        <table border ="1">     
            <tr>
                <th>Skill name</th>
            </tr>
            <c:forEach var="Skill" items="${skillList}">
                <tr>
                    <td>${Skill.name}</td>
                    <td>${Skill.ruleSet.name}</td>
            </c:forEach>
        </table>
    </body>
</html>