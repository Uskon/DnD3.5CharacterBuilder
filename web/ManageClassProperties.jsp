<%-- 
    Document   : ManageClassProperties
    Created on : Apr 19, 2013, 1:39:04 PM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Class Properties</title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
    </head>
    <body>
        <h1>Choose the Class you wish to manage</h1>
        <div class="managefield">
            <fieldset class="inputbox">
                <form name="chooseClass"
                      action="${pageContext.request.contextPath}/ManageClass"
                      method="post">
                    <% if (session.getAttribute("nullClass") != null) {%>
                    <p><b>You must choose a Class before proceeding!</b></p>
                    <%}
                        session.removeAttribute("nullClass");
                        if (session.getAttribute("outdated") != null) {%>
                        <p><b>The page you were viewing appears to have been outdated</b></p>
                        <%} session.removeAttribute("outdated");%>
                    <c:forEach var="class" items="${classlist}">
                        <p><input type="radio" class="rbutton" name="class" value="${class.id}"/>${class.name}, ${class.ruleSet.name}</p>
                        </c:forEach>
                        <% if (request.getAttribute("classlist") != null) {%>
                        <hr>
                        <p class="p1"><input type="submit" name="selection" value="Set Skills" class="managebutton"/>
                        <input type="submit" name="selection" value="Set Feats" class="managebutton"/>
                        <input type="submit" name="selection" value="Set Requirements" class="managebutton"/>
                        <input type="submit" name="selection" value="Set Progress" class="managebutton"/>
                        <input type="submit" name="selection" value="Set Description" class="managebutton"/></p>
                        <br>
                        <br>
                        <p><input type="submit" name="selection" value="Delete" class="managebutton"/></p>
                    <%} else {%>
                    <p><b>No Classes exist!</b></p>
                    <%}%>
                </form>
            </fieldset>
        </div>
    </body>
</html>
