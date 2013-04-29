<%-- 
    Document   : AddNewFeat
    Created on : Apr 18, 2013, 1:01:30 PM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a new Feat</title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
    </head>
    <body>
        <h1>Input the information for the Feat to be added</h1>
        <div class="bigdiv">
            <div class="leftside">
                <div class="inputfield">
                    <fieldset class="inputbox">
                        <form name="newFeat"
                              action="${pageContext.request.contextPath}/AddFeat"
                              method="post">
                            <p class="p1">Feat Name: <input type="text" name="featName" class="textinput"/></p>
                            <p>Source: <input type="text" name="rset" class="textinput"/></p>
                                <% if (request.getAttribute("inputSuccessful") != null) {%>
                            <p>The Feat has been successfully added</p>
                            <%}%><b><%
                                if (request.getAttribute("badname") != null) {%>
                            <p>Please check that the name is not empty and does not contain special characters</p>
                            <%}
                                if (request.getAttribute("badRSetInput") != null) {%>
                            <p>Please input the name of an existing Rule Set</p>
                            <%}
                                if (request.getAttribute("featExists") != null) {%>
                            <p>The Feat already exists</p>
                            <%}%></b>
                    </fieldset>
                </div>
                <div class="inputfield">
                    <p><b>Set the requirements the Feat has</b></p>
                    <fieldset class="inputbox">
                        <div>
                            True/False
                            <p style="margin-top"><input type="radio" name="reqCharlvl" value="true" class="rbutton"/> <input type="radio" name="reqCharlvl" value="false" checked="checked" class="rbutton"/>Requires character level</p>
                            <p><input type="radio" name="reqRace" value="true" class="rbutton"/> <input type="radio" name="reqRace" value="false" checked="checked" class="rbutton"/>Requires race</p>
                            <p><input type="radio" name="reqAlignment" value="true" class="rbutton"/> <input type="radio" name="reqAlignment" value="false" checked="checked" class="rbutton"/>Requires alignment</p>
                            <p><input type="radio" name="reqDeity" value="true" class="rbutton"/> <input type="radio" name="reqDeity" value="false" checked="checked" class="rbutton"/>Requires deity</p>
                            <p><input type="radio" name="reqClass" value="true" class="rbutton"/> <input type="radio" name="reqClass" value="false" checked="checked" class="rbutton"/>Requires levels of class<br>
                            <p><input type="radio" name="reqCaster" value="true" class="rbutton"/> <input type="radio" name="reqCaster" value="false" checked="checked" class="rbutton"/>Requires caster level<br>
                            <p><input type="radio" name="reqSpell" value="true" class="rbutton"/> <input type="radio" name="reqSpell" value="false" checked="checked" class="rbutton"/>Requires spell level<br>
                            <p><input type="radio" name="reqAttributes" value="true" class="rbutton"/> <input type="radio" name="reqAttributes" value="false" checked="checked" class="rbutton"/>Requires attributes<br>
                            <p><input type="radio" name="reqBAB" value="true" class="rbutton"/> <input type="radio" name="reqBAB" value="false" checked="checked" class="rbutton"/>Requires Base attack bonus<br>
                            <p><input type="radio" name="reqSave" value="true" class="rbutton"/> <input type="radio" name="reqSave" value="false" checked="checked" class="rbutton"/>Requires Saving throws<br>
                            <p><input type="radio" name="reqFeat" value="true" class="rbutton"/> <input type="radio" name="reqFeat" value="false" checked="checked" class="rbutton"/>Requires Feats<br>
                            <p><input type="radio" name="reqSkill" value="true" class="rbutton"/> <input type="radio" name="reqSkill" value="false" checked="checked" class="rbutton"/>Requires Skills<br>
                                <br>
                                <br><input type="submit" value="Send"/>
                        </div>
                        </form>
                    </fieldset>
                </div>
            </div>

            <div class="info">
                <h2>Existing Feats:</h2>
                <table border ="1">     
                    <tr>
                        <th>ID</th>
                        <th>Feat Name</th>
                        <th>Rule Set</th>
                    </tr>
                    <c:forEach var="Feat" items="${featlist}">
                        <tr>
                            <td>${Feat.id}</td>
                            <td>${Feat.name}</td>
                            <td>${Feat.ruleSet.name}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
