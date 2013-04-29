<%-- 
    Document   : AddNewDomain
    Created on : Apr 24, 2013, 5:59:28 PM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a new Domain</title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
    </head>
    <body>
        <h1>Input the information for the Domain to be added</h1>
        <div class="bigdiv">
            <div class="leftside">
                <div class="inputfield">
                    <fieldset class="inputbox">
                        <form name="newDomain"
                              action="${pageContext.request.contextPath}/AddDomain"
                              method="post">
                            <p class="p1">Domain Name: <input type="text" name="domainName" class="textinput"/></p>
                            <p>Source: <input type="text" name="rset" class="textinput"/> </p>
                            <p><input type="submit" value="Send"/></p>
                                <% if (request.getAttribute("inputSuccessful") != null) {%>
                            <p>The domain has been added successfully</p>
                            <%}%><b><%
                                if (request.getAttribute("badname") != null) {%>
                                <p>Please check that the name is not empty and does not contain special characters</p>
                                <%}
                                    if (request.getAttribute("domainExists") != null) {%>
                                <p>The domain already exists</p>
                                <%}
                                    if (request.getAttribute("badRSetInput") != null) {%>
                                <p>Please input the name of an existing Rule Set</p>
                                <%}%></b>
                        </form>
                    </fieldset>
                </div>
            </div>
            <div class="info">
                <h2>Existing domains:</h2>
                <table border ="1">     
                    <tr>
                        <th>ID</th>
                        <th>Domain name</th>
                        <th>Rule Set</th>
                    </tr>
                    <c:forEach var="Domain" items="${domainList}">
                        <tr>
                            <td>${Domain.id}</td>
                            <td>${Domain.name}</td>
                            <td>${Domain.ruleSet.name}</td>
                        </tr>
                    </c:forEach>

                </table>
            </div>
        </div>
    </body>
</html>