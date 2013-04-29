<%-- 
    Document   : AddNewRaceDescription
    Created on : Apr 26, 2013, 8:33:09 PM
    Author     : Uskon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Set ${race.name}, ${race.ruleSet.name} Description</title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
        <% if (session.getAttribute("managedRace") == null) {
            response.sendRedirect("ManageRace");
        }   %>
    </head>
    <body>
        <h1>Set the description for ${race.name}, ${race.ruleSet.name}</h1>
        <div class="bigdiv">
            <div class="leftside">
                <div class="inputfield">
                    <fieldset class="inputbox">
                        <form name="newRaceDescription"
                              action="${pageContext.request.contextPath}/AddDescription"
                              method="post">
                            <input type="hidden" name="type" value="race">
                            <p class="p1">Description: <textarea name="description" cols="35" rows="20">Enter Description here</textarea></p>
                            <p><input type="submit" value="Send"/></p>
                        </form>
                    </fieldset>
                </div>
            </div>
            <% if (request.getAttribute("cdesc") != null) {%>
            <div class="info">
                <p>Current Description</p>
                <fieldset class="inputbox">
                    <p>${cdesc}</p>
                    <form action="${pageContext.request.contextPath}/RemoveRaceDescription"
                          method="post">
                        <input type="hidden" name="raceid" value="${race.id}">
                        <input type="submit" name="remove" value="Remove">
                    </form>
                </fieldset>
            </div>
            <%}%>
        </div>
    </body>
</html>
