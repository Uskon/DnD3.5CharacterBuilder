<%-- 
    Document   : AddNewClassFeat
    Created on : Apr 20, 2013, 2:58:19 PM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Set ${class.name}, ${class.ruleSet.name} Feats</title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
        <% if (session.getAttribute("managedClass") == null) {
            response.sendRedirect("ManageClasses");
        }   %>
    </head>
    <body>
        <h1>Choose the ${class.name} (${class.ruleSet.name}) Feats you wish to set</h1>
        <div class="bigdiv">
            <div class="leftside">
                <div class="inputfield" style="width:550px">
                    <fieldset class="inputbox">
                        <% if (request.getAttribute("feats") != null) {%>
                        <form name="chooseClassFeat"
                                  action="${pageContext.request.contextPath}/AddClassFeat"
                                  method="post">
                        <table border="1" style="width:500px">
                                <input type="hidden" name="cclass" value="${class.id}"/>
                                <tr>
                                    <th>List of available Feats</th>
                                    <th style="width:60px">Class level when gained, max ${class.maxlvl}</th>
                                </tr>
                                <tr>
                                    <td>
                                        <c:forEach var="Feat" items="${feats}">
                                            <input type="radio" class="rbutton" name="feat" value="${Feat.id}"/>${Feat.name}, ${Feat.ruleSet.name} <br>
                                        </c:forEach></td>
                                    <td>
                                        <input type="number" name="level" min="1" max="${class.maxlvl}"  class="textinput"/><br>
                                    </td>
                                </tr>
                        </table>
                        <br/>
                        <input type="submit" value="Send"/>
                        <% if (request.getAttribute("badlvl") != null) {%>
                        <p><b>Check that the level is a number and not higher than the max</b></p>
                        <%}%>
                        </form>
                        <%} else {%>
                        <p>There are no more Feats left to be set for this Class</p>
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
                        <th>Level</th>
                    </tr>
                    <tr>
                        <c:forEach var="cf" items="${cfeats}">
                        <tr>
                            <td>${cf.id}</td>
                            <td>${cf.feat.name}</td>
                            <td>${cf.lvl}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/RemoveClassFeat"
                                      method="post">
                                    <input type="hidden" name="cfid" value="${cf.id}">
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
