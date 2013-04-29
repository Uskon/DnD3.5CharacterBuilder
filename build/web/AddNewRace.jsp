<%-- 
    Document   : AddNewRace
    Created on : Mar 21, 2013, 11:30:27 AM
    Author     : Uskon
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a new Race</title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
    </head>
    <body>
        <h1>Input the information for the Race to be added</h1>
        <div class="bigdiv">
            <div class="leftside">
                <div class="inputfield">
                    <fieldset class="inputbox">
                        <form name="newRace"
                              action="${pageContext.request.contextPath}/AddRace"
                              method="post">
                            <p class="p1">Race Name: <input type="text" name="raceName" class="textinput"/></p>
                            <br><p>Attribute Bonuses</p>
                            <p>Strength: <input type="number" name="str" min="-10" max="50" value="0" class="textinput"/></p>
                            <p>Dexterity: <input type="number" name="dex" min="-10" max="50" value="0" class="textinput"/></p>
                            <p>Constitution: <input type="number" name="con" min="-10" max="50" value="0" class="textinput"/></p>
                            <p>Intelligence: <input type="number" name="int" min="-10" max="50" value="0" class="textinput"/></p>
                            <p>Wisdom: <input type="number" name="wis" min="-10" max="50" value="0" class="textinput"/></p>
                            <p>Charisma: <input type="number" name="cha" min="-10" max="50" value="0" class="textinput"/></p><br>
                            <p>Source: <input type="text" name="rset" class="textinput"/> </p>
                            <p><input type="submit" value="Send"/></p>
                            <% if (request.getAttribute("inputSuccessful") != null) {%>
                                <p>The race has been added successfully</p>
                                <%}%><b><%
                                    if (request.getAttribute("badname") != null) {%>
                                <p>Please check that the name is not empty and does not contain special characters</p>
                                <%}
                                    if (request.getAttribute("raceExists") != null) {%>
                                <p>The race already exists</p>
                                <%}
                                    if (request.getAttribute("badAttributeInput") != null) {%>
                                <p>Please check the attribute bonus input</p>
                                <%}
                                    if (request.getAttribute("badRSetInput") != null) {%>
                                <p>Please input the name of an existing Rule Set</p>
                                <%}%></b>

                        </form>
                    </fieldset>
                </div>
            </div>
            <div class="info">
                <h2>Existing races:</h2>

                <table border ="1">     
                    <tr>
                        <th>ID</th>
                        <th>Race Name</th>
                        <th>Attribute Bonuses</th>
                        <th>Rule Set</th>
                    </tr>
                    <c:forEach var="Race" items="${raceList}">
                        <tr>
                            <td>${Race.id}</td>
                            <td>${Race.raceName}</td>
                            <td>STR: ${Race.strbonus} DEX: ${Race.dexbonus} CON: ${Race.conbonus} INT: ${Race.intbonus} WIS: ${Race.wisbonus} CHA: ${Race.chabonus}</td>
                            <td>${Race.ruleSet.name}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
