<%-- 
    Document   : AddNewClass
    Created on : Mar 31, 2013, 10:42:49 PM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a new Class</title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
    </head>
    <body>
        <h1>Input the information for the Class to be added</h1>
        <div class="bigdiv" name="test">
            <div class="leftside">
                <div class="inputfield">
                    <fieldset class="inputbox">
                        <form name="newClass"
                              action="${pageContext.request.contextPath}/AddClass"
                              method="post">
                            <p class="p1">Class Name: <input type="text" name="className" class="textinput"/></p>
                            <p>Max level: <input type="number" name="maxlvl" min="1" max="20" class="textinput"/></p>
                            <p>Source: <input type="text" name="rset" class="textinput"/></p>
                                <% if (request.getAttribute("inputSuccessful") != null) {%>
                            <p>The class has been successfully added</p>
                            <%}%><b><%
                                if (request.getAttribute("badname") != null) {%>
                            <p>Please check that the name is not empty and does not contain special characters</p>
                            <%}
                                if (request.getAttribute("badlvl") != null) {%>
                            <p>Please check that the max level is set to 1-20</p>
                            <%}
                                if (request.getAttribute("badRSetInput") != null) {%>
                            <p>Please input the name of an existing Rule Set</p>
                            <%}
                                if (request.getAttribute("classExists") != null) {%>
                            <p>The class already exists</p>
                            <%}%></b>
                    </fieldset>
                </div>
                <div class="inputfield">
                    <p><b>Set the requirements the class has</b></p>
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
                <h2>Existing Classes:</h2>
                <table border ="1">     
                    <tr>
                        <th>ID</th>
                        <th>Class Name</th>
                        <th>Max level</th>
                        <th>Rule Set</th>
                    </tr>
                    <c:forEach var="Class" items="${classlist}">
                        <tr>
                            <td>${Class.id}</td>
                            <td>${Class.name}</td>
                            <td>${Class.maxlvl}</td>
                            <td>${Class.ruleSet.name}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
