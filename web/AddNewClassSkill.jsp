<%-- 
    Document   : AddNewClassSkill
    Created on : Apr 1, 2013, 1:45:53 PM
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
        <table border="0">
            <form name="chooseClass"
                  action="${pageContext.request.contextPath}/addClassSkill"
                  method="post">
                <tr>
                    <th>List of available Classes</th>
                    <th>List of available Skills</th>
                    <th>Skill type</th>
                </tr>
                <tr>
                    <td>
                        <c:forEach var="CClass" items="${classlist}">
                            <input type="radio" name="class" value="${CClass}"/>${CClass.name} <br>
                        </c:forEach></td>
                    <td>
                        <c:forEach var="Skill" items="${skilllist}">
                            <input type="radio" name="skill" value="${Skill}"/>${Skill.name} <br>
                        </c:forEach></td>
                    <td>
                        <input type="radio" name="type" value="1"/>Class skill<br>
                        <input type="radio" name="type" value="2"/>Cross-class skill<br>
                    </td>
                </tr>
        </table>
        <br/>
        <input type="submit" value="Send"/>
    </form>
    <table border="1">
        <tr>
            <th>Class name</th>
            <th>Skill name</th>
            <th>Skill type</th>
        </tr>
        <tr>
        <c:forEach var="cs" items="${cslist}">
            <td>${cs.cclass.name}</td>
            <td>${cs.skill.name}</td>
            <td>${cs.type}</td>
        </c:forEach>
        </tr>
    </table>
</body>
</html>
