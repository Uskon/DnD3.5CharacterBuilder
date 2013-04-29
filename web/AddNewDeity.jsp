<%-- 
    Document   : AddNewDeity
    Created on : Apr 24, 2013, 2:49:17 PM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a new Deity</title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
    </head>
    <body>
        <h1>Input the information for the Deity to be added</h1>
        <div class="bigdiv">
            <div class="leftside">
                <div class="inputfield">
                    <fieldset class="inputbox">
                        <form name="newDeity"
                              action="${pageContext.request.contextPath}/AddDeity"
                              method="post">
                            <p class="p1">Deity Name: <input type="text" name="deityName" class="textinput"/></p>
                            <p>Alignment: <input type="text" name="alignment" class="textinput"/></p>
                            <p>Source: <input type="text" name="rset" class="textinput"/> </p>
                            <p><input type="submit" value="Send"/></p>
                                <% if (request.getAttribute("inputSuccessful") != null) {%>
                            <p>The Deity has been added successfully</p>
                            <%}%><b><%
                                if (request.getAttribute("badname") != null) {%>
                                <p>Please check that the name is not empty and does not contain special characters</p>
                                <%}
                                    if (request.getAttribute("badalignment") != null) {%>
                                <p>Please check the alignment input</p>
                                <%}
                                    if (request.getAttribute("deityExists") != null) {%>
                                <p>The Deity already exists</p>
                                <%}
                                    if (request.getAttribute("badRSetInput") != null) {%>
                                <p>Please input the name of an existing Rule Set</p>
                                <%}%></b>
                        </form>
                    </fieldset>
                </div>
            </div>
            <div class="info">
                <h2>Existing Deities:</h2>
                <table border ="1">     
                    <tr>
                        <th>ID</th>
                        <th>Deity name</th>
                        <th>Alignment</th>
                        <th>Rule Set</th>
                    </tr>
                    <c:forEach var="Deity" items="${deityList}">
                        <tr>
                            <td>${Deity.id}</td>
                            <td>${Deity.name}</td>
                            <td>${Deity.alignment}</td>
                            <td>${Deity.ruleSet.name}</td>
                        </tr>
                    </c:forEach>

                </table>
            </div>
        </div>
    </body>
</html>
