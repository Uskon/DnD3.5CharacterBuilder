<%-- 
    Document   : ManageSkillProperties
    Created on : Apr 25, 2013, 12:18:53 PM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Skill Properties</title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
    </head>
    <body>
        <h1>Choose the Skill you wish to manage</h1>
        <div class="managefield">
            <fieldset class="inputbox">
                <form name="chooseSkill"
                      action="${pageContext.request.contextPath}/ManageSkill"
                      method="post">
                    <% if (session.getAttribute("nullSkill") != null) {%>
                    <p><b>You must choose a Skill before proceeding!</b></p>
                    <%} session.removeAttribute("nullSkill"); %>
                    <c:forEach var="skill" items="${skilllist}">
                        <p><input type="radio" class="rbutton" name="skill" value="${skill.id}"/>${skill.name}, ${skill.ruleSet.name}</p>
                    </c:forEach>
                    <% if (request.getAttribute("skilllist") != null) {%>
                    <p><input type="submit" name="selection" value="Delete"class="managebutton"></p>
                        <%} else {%>
                    <p><b>No Skills exist!</b></p>
                    <%}%>
                </form>
            </fieldset>
        </div>
    </body>
</html>
