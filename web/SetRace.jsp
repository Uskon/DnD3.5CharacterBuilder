<%-- 
    Document   : SetRace
    Created on : Mar 30, 2013, 6:53:09 PM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <h1>Select the race of your character</h1>
            </div>
            <div id="selection" style="width:15%;float:left;">
                <form name="newRuleSet"
                      action="${pageContext.request.contextPath}/LevelUpClass"
                      method="post">
                    <c:forEach var="Race" items="${rlist}">
                        <input type="radio" name="race" value="${Race}" onclick="showDescription('${Race.raceDescription}')">${Race.raceName}<br> 
                    </c:forEach>
                    <input type="submit" value="send">
                    </div>
                </form>

                <div id="description" style="float:left;">
                    <p id="dcontent">Test area</p>
                </div>
            </div>
            <script>
                function showDescription(d) {
                    x = document.getElementById("dcontent");
                    x.innerHTML =d;
                }
            </script>
    </body>
</html>
