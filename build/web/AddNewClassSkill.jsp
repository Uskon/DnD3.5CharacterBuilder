<%-- 
    Document   : AddNewClassSkill
    Created on : Apr 1, 2013, 1:45:53 PM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Set ${class.name}, ${class.ruleSet.name} Skills</title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
        <% if (session.getAttribute("managedClass") == null) {
                response.sendRedirect("ManageClasses");
            }%>
    </head>
    <body>
        <h1>Choose the ${class.name} (${class.ruleSet.name}) Skills you wish to set</h1>
        <div class="bigdiv">
            <div class="leftside">
                <div class="inputfield" style="width:550px">
                    <fieldset class="inputbox">
                        <% if (request.getAttribute("skills") != null) {%>
                        <form name="chooseClassSkill"
                              action="${pageContext.request.contextPath}/AddClassSkill"
                              method="post">
                            <table border="1" style="width:500px">
                                <input type="hidden" name="cclass" value="${class.id}"/>
                                <tr>
                                    <th>List of available Skills</th>
                                    <th style="width:150px">Skill type</th>
                                </tr>
                                <tr>
                                    <td>
                                        <c:forEach var="Skill" items="${skills}">
                                            <input type="radio" class="rbutton" name="skill" value="${Skill.id}"/>${Skill.name} <br>
                                        </c:forEach></td>
                                    <td>
                                        <input type="radio" class="rbutton" name="type" value="1"/>Class skill<br>
                                        <input type="radio" class="rbutton" name="type" value="2"/>Cross-class<br>
                                        <input type="radio" class="rbutton" name="type" value="0"/>Non-class skill<br>
                                    </td>
                                </tr>
                            </table>
                            <br/>
                            <input type="submit" value="Send"/>
                        </form>
                        <%} else {%>
                        <p>There are no more Skills left to be set for this Class</p>
                        <%}%>
                    </fieldset>
                </div>
            </div>
            <br>
            <div class="info">
                <table border="1">
                    <tr>
                        <th>ID</th>
                        <th>Skill name</th>
                        <th>Skill type</th>
                    </tr>
                    <tr>
                        <c:forEach var="cs" items="${cskills}">
                        <tr>
                            <td>${cs.id}</td>
                            <td>${cs.skill.name}</td>
                            <td>${cs.type}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/RemoveClassSkill"
                                      method="post">
                                    <input type="hidden" name="csid" value="${cs.id}">
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
