<%-- 
    Document   : SetClassProgress
    Created on : Apr 22, 2013, 11:09:16 AM
    Author     : Uskon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Set ${class.name}, ${class.ruleSet.name} Class Progress</title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
        <style>
            .ptable {
                width:330px;
            }
        </style>
    </head>
    <body>
        <h1>Set the Class Progress for ${class.name}, ${class.ruleSet.name}</h1>
        <div class="bigdiv">
            <div class="leftside">
                <div class="inputfield">
                    <fieldset class="inputbox">
                        <form name="setClassProgress"
                              action="${pageContext.request.contextPath}/SetClassProgress"
                              method="post">
                            <table border="1" class="ptable">
                                <tr>
                                    <td>
                                        <p>Hit dice:</p>
                                        <p><input type="radio" name="hd" value="d4" class="rbutton"/>d4</p>
                                        <p><input type="radio" name="hd" value="d6" class="rbutton"/>d6</p>
                                        <p><input type="radio" name="hd" value="d8" class="rbutton"/>d8</p>
                                        <p><input type="radio" name="hd" value="d10" class="rbutton"/>d10</p>
                                        <p><input type="radio" name="hd" value="d12" class="rbutton"/>d12</p>
                                    </td>
                                    <td>
                                        Base Attack Bonus:<br>
                                        <p><input type="radio" name="bab" value="high" class="rbutton"/>High</p>
                                        <p><input type="radio" name="bab" value="med" class="rbutton"/>Medium</p>
                                        <p><input type="radio" name="bab" value="low" class="rbutton"/>Low</p>
                                    </td>
                                    <td>
                                        Skill points per level:<br>
                                        <p><input type="radio" name="sp" value="2" class="rbutton"/>2</p>
                                        <p><input type="radio" name="sp" value="4" class="rbutton"/>4</p>
                                        <p><input type="radio" name="sp" value="6" class="rbutton"/>6</p>
                                        <p><input type="radio" name="sp" value="8" class="rbutton"/>8</p>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Fortitude Saving throws:<br>
                                        <p><input type="radio" name="fort" value="high" class="rbutton"/>High</p>
                                        <p><input type="radio" name="fort" value="low" class="rbutton"/>Low</p>
                                    </td>
                                    <td>
                                        Reflex Saving throws:<br>
                                        <p><input type="radio" name="refl" value="high" class="rbutton"/>High</p>
                                        <p><input type="radio" name="refl" value="low" class="rbutton"/>Low</p>
                                    </td>
                                    <td>
                                        Will Saving throws:<br>
                                        <p><input type="radio" name="will" value="high" class="rbutton"/>High</p>
                                        <p><input type="radio" name="will" value="low" class="rbutton"/>Low</p>
                                    </td>
                                </tr>
                            </table>
                            <table border="1" class="ptable">
                                <tr>
                                    <td>
                                        Caster level progression:<br>
                                        <p><input type="radio" name="clvl" value="none" class="rbutton"/>None</p>
                                        <p><input type="radio" name="clvl" value="half" class="rbutton"/>Half</p>
                                        <p><input type="radio" name="clvl" value="full" class="rbutton"/>Full</p>
                                        <p>Excluded levels: <input type="text" name="exc" class="textinput"></p>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Spell level progression:<br>
                                        <p><input type="radio" name="slvl" value="none" class="rbutton"/>None</p>
                                        <p><input type="radio" name="slvl" value="odd" class="rbutton"/>Odd</p>
                                        <p><input type="radio" name="slvl" value="even" class="rbutton"/>Even</p>
                                        <p>Specified: <input type="text" name="spec" class="textinput"></p>
                                    </td>
                                </tr>
                            </table>
                            <br><input type="submit" value="Send"/>
                        </form>
                    </fieldset>
                </div>
                <div class="info">
                    <table border="1">
                        <tr>
                                <th>Lvl</th>
                                <th>HD</th>
                                <th>BAB</th>
                                <th>CL</th>
                                <th>SL</th>
                                <th>Fort</th>
                                <th>Refl</th>
                                <th>Will</th>
                                <th>SP</th>
                            </tr>
                        <c:forEach var="cp" items="${cprog}">
                            <tr>
                                <td>${cp.lvl}</td>
                                <td>${cp.hitDice}</td>
                                <td>${cp.BAB}</td>
                                <td>${cp.casterLevel}</td>
                                <td>${cp.spellLevel}</td>
                                <td>${cp.fortSave}</td>
                                <td>${cp.reflSave}</td>
                                <td>${cp.willSave}</td>
                                <td>${cp.skillPoints}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <form action="${pageContext.request.contextPath}/RemoveClassProgress"
                          method="post">
                        <input type="hidden" name="classid" value="${class.id}">
                        <input type="submit" name="remove" value="Remove">
                    </form>
                </div>
            </div>
    </body>
</html>
