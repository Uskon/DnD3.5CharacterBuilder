<%-- 
    Document   : index
    Created on : Mar 19, 2013, 12:06:42 PM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DnD 3.5 CharBuilder</title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="publicnav.jsp" %>
    </head>
    <body>
        <h1>DnD 3.5 Character Builder</h1>
        <div class="bigdiv">
            <div class="leftside">
                <fieldset style="width:400px">
                    <form action="${pageContext.request.contextPath}/SearchByName">
                        <p style="float:left"><select name="type">
                                <option value="Race">Race</option>
                                <option value="Class">Class</option>
                                <option value="Feat">Feat</option>
                                <option value="Skill">Skill</option>
                                <option value="Deity">Deity</option>
                                <option value="Domain">Domain</option>
                            </select></p>
                        <p style="float:right">Name: <input type="text" name="name"></p><br><br><br>
                        <input type="submit" value="Quick search" style="float:right">
                    </form>
                </fieldset>
                <br>
                <% if (request.getAttribute("result") != null) {%>
                <fieldset class="inputbox">
                    <% if (request.getAttribute("badinput") != null) {%>
                    <p>The name may not contain any special characters</p>
                    <%}
                        if (request.getAttribute("noresult") != null) {%>
                    <p> No results </p>
                    <%}%>
                    <form action="${pageContext.request.contextPath}/ShowInfo">
                        <c:forEach var="item" items="${result}">
                            <input type="hidden" name="type" value="${type}">
                            <p><button type="submit" class="submitlink" name="item" value="${item.id}">${item.name}, ${item.ruleSet.name}</button></p>
                        </c:forEach>
                    </form>
                </fieldset>
            </div>
            <%}
                    if (request.getAttribute("info") != null) {%>
            <div class="info">
                <fieldset class="inputbox">
                    <p><b>Additional Information</b></p>
                    <p>${info}</p>
                </fieldset>
            </div>
            <%}%>
        </div>
    </body>
</html>
