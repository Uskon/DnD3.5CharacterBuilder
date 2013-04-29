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
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
    </head>
    <body>
        <h1>Input the information for the Skill to be added</h1>
        <div class="bigdiv">
            <div class="leftside">
                <div class="inputfield">
                    <fieldset class="inputbox">
                        <form name="newSkill"
                              action="${pageContext.request.contextPath}/AddSkill"
                              method="post">
                            <p class="p1">Skill Name: <input id="field1" type="text" name="skillName" class="textinput"/></p>
                            <p>Source: <input id="field1" type="text" name="rset" class="textinput"/> </p>
                            <p><input type="submit" value="Send"/></p>
                            <% if (request.getAttribute("inputSuccessful") != null) {%>
                            <p>The skill has been added successfully</p>
                            <%}%><b><%
                                if (request.getAttribute("badname") != null) {%>
                            <p>Please check that the name is not empty and does not contain special characters</p>
                            <%}
                                if (request.getAttribute("skillExists") != null) {%>
                            <p>The skill already exists</p>
                                <%}
                                    if (request.getAttribute("badRSetInput") != null) {%>
                                <p>Please input the name of an existing Rule Set</p>
                                <%}%></b>
                        </form>
                    </fieldset>
                </div>
            </div>
            <div class="info">
                <h2>Existing Skills:</h2>
                <table border ="1">     
                    <tr>
                        <th>ID</th>
                        <th>Skill name</th>
                        <th>Rule Set</th>
                    </tr>
                    <c:forEach var="Skill" items="${skillList}">
                        <tr>
                            <td>${Skill.id}</td>
                            <td>${Skill.name}</td>
                            <td>${Skill.ruleSet.name}</td>
                        </tr>
                    </c:forEach>

                </table>
            </div>
        </div>
    </body>
</html>
