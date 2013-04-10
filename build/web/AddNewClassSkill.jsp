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
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
    </head>
    <body>
        <h1>Choose the class and the skill you wish to set</h1>
        <div class="inputfield">
            <fieldset class="inputbox">
        <table border="1" style="width:650px">
            <form name="chooseClass"
                  action="${pageContext.request.contextPath}/AddClassSkill"
                  method="post">
                <tr>
                    <th>List of available Classes</th>
                    <th>List of available Skills</th>
                    <th>Skill type</th>
                </tr>
                <tr>
                    <td>
                        <c:forEach var="CClass" items="${classlist}">
                            <input type="radio" class="rbutton" name="class" value="${CClass}"/>${CClass.name}<br>
                        </c:forEach></td>
                    <td>
                        <c:forEach var="Skill" items="${skilllist}">
                            <input type="radio" class="rbutton" name="skill" value="${Skill}"/>${Skill.name} <br>
                        </c:forEach></td>
                    <td>
                        <input type="radio" class="rbutton" name="type" value="1"/>Class skill<br>
                        <input type="radio" class="rbutton" name="type" value="2"/>Cross-class<br>
                    </td>
                </tr>
        </table>
        <br/>
        <input type="submit" value="Send"/>
    </form>
            </fieldset>
        </div>
                  <br>
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
