<%--
    Document   : AddNewDomainFeat
    Created on : Apr 24, 2013, 4:17:13 PM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Set ${domain.name}, ${domain.ruleSet.name} Feats</title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
        <% if (session.getAttribute("managedDomain") == null) {
            response.sendRedirect("ManageDomains");
        }   %>
    </head>
    <body>
        <h1>Choose the ${domain.name}, (${domain.ruleSet.name}) Feats you wish to set</h1>
        <div class="bigdiv">
            <div class="leftside">
                <div class="inputfield" style="width:550px">
                    <fieldset class="inputbox">
                        <% if (request.getAttribute("feats") != null) {%>
                        <form name="chooseDomainFeat"
                                  action="${pageContext.request.contextPath}/AddDomainFeat"
                                  method="post">
                        <table border="1" style="width:500px">
                                <input type="hidden" name="ddomain" value="${domain.id}"/>
                                <tr>
                                    <th>List of available Feats</th>
                                </tr>
                                <tr>
                                    <td>
                                        <c:forEach var="Feat" items="${feats}">
                                            <input type="radio" class="rbutton" name="feat" value="${Feat.id}"/>${Feat.name}, ${Feat.ruleSet.name} <br>
                                        </c:forEach></td>
                                </tr>
                        </table>
                        <br/>
                        <input type="submit" value="Send"/>
                        </form>
                                <%} else {%>
                                <p>There are no more Feats left to be set for this Domain</p>
                                <%}%>
                    </fieldset>
                </div>
            </div>
            <br>
            <div class="info">
                <table border="1">
                    <tr>
                        <th>ID</th>
                        <th>Feat name</th>
                    </tr>
                    <tr>
                        <c:forEach var="df" items="${dfeats}">
                        <tr>
                            <td>${df.id}</td>
                            <td>${df.feat.name}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/RemoveDomainFeat"
                                      method="post">
                                    <input type="hidden" name="dfid" value="${df.id}">
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
