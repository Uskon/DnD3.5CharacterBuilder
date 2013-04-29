<%-- 
    Document   : AddNewRacialFeat
    Created on : Apr 28, 2013, 11:06:42 AM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Set ${race.name}, ${race.ruleSet.name} Feats</title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
        <% if (session.getAttribute("managedRace") == null) {
            response.sendRedirect("ManageRaces");
        }   %>
    </head>
    <body>
        <h1>Choose the ${race.name}, (${race.ruleSet.name}) Feats you wish to set</h1>
        <div class="bigdiv">
            <div class="leftside">
                <div class="inputfield" style="width:550px">
                    <fieldset class="inputbox">
                        <% if (request.getAttribute("feats") != null) {%>
                        <form name="chooseRacialFeat"
                                  action="${pageContext.request.contextPath}/AddRacialFeat"
                                  method="post">
                        <table border="1" style="width:500px">
                                <input type="hidden" name="race" value="${race.id}"/>
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
                                <p>There are no more Feats left to be set for this Race</p>
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
                        <c:forEach var="rf" items="${rfeats}">
                        <tr>
                            <td>${rf.id}</td>
                            <td>${rf.feat.name}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/RemoveRacialFeat"
                                      method="post">
                                    <input type="hidden" name="rfid" value="${rf.id}">
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
