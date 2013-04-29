<%-- 
    Document   : AddNewDeityDomain
    Created on : Apr 25, 2013, 11:08:01 AM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Set ${deity.name}, ${deity.ruleSet.name} Domains</title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
        <% if (session.getAttribute("managedDeity") == null) {
                response.sendRedirect("ManageDeities");
            }%>
    </head>
    <body>
        <h1>Choose the ${deity.name}, (${deity.ruleSet.name}) Domains you wish to set</h1>
        <div class="bigdiv">
            <div class="leftside">
                <div class="inputfield" style="width:550px">
                    <fieldset class="inputbox">
                        <% if (request.getAttribute("domains") != null) {%>
                        <form name="chooseDeityDomain"
                              action="${pageContext.request.contextPath}/AddDeityDomain"
                              method="post">

                            <table border="1" style="width:500px">
                                <input type="hidden" name="deity" value="${deity.id}"/>
                                <tr>
                                    <th>List of available Domains</th>
                                </tr>
                                <tr>
                                    <td>
                                        <c:forEach var="Domain" items="${domains}">
                                            <input type="radio" class="rbutton" name="domain" value="${Domain.id}"/>${Domain.name}, ${Domain.ruleSet.name} <br>
                                        </c:forEach>
                                    </td>
                                </tr>
                            </table>
                            <br/>
                            <input type="submit" value="Send"/>
                        </form>
                        <%} else {%>
                        <p>There are no Domains left to be set for this Deity</p>
                        <%}%>
                    </fieldset>
                </div>
            </div>
            <br>
            <div class="info">
                <table border="1">
                    <tr>
                        <th>ID</th>
                        <th>Domain name</th>
                    </tr>
                    <tr>
                        <c:forEach var="dd" items="${ddomains}">
                        <tr>
                            <td>${dd.id}</td>
                            <td>${dd.domain.name}, (${dd.domain.ruleSet.name})</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/RemoveDeityDomain"
                                      method="post">
                                    <input type="hidden" name="ddid" value="${dd.id}">
                                    <input type="submit" name="remove" value="Remove">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>

