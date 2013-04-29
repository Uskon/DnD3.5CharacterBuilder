<%-- 
    Document   : AddFeatRequirements
    Created on : Apr 22, 2013, 6:50:21 PM
    Author     : Uskon
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add ${feat.name}, ${feat.ruleSet.name} Requirements</title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
        <% if (session.getAttribute("managedFeat") == null) {
                response.sendRedirect("ManageFeats");
            }%>
    </head>
    <body>
        <h1>Choose the ${feat.name} (${feat.ruleSet.name}) Requirements you wish to add</h1>
        <div class="bigdiv">
            <div class="leftside">
                <div class="inputfield">
                    <form name="addFeatReqs"
                          action="${pageContext.request.contextPath}/AddFeatRequirements"
                          method="post">
                        <% if (request.getAttribute("classrequired") != null) {%>
                        <fieldset class="inputbox">
                            <p class="p1">Required Class:<input type="text" name="classreq" class="textinput"/></p>
                            <p>Required level: <input type="text" name="classlvl" class="textinput"/></p>
                        </fieldset>
                        <%}
                            if (request.getAttribute("levelrequired") != null) {%>
                        <fieldset class="inputbox">
                            <p class="p1">Required Character level: <input type="text" name="charlvl" class="textinput"/></p>
                        </fieldset>
                        <%}
                            if (request.getAttribute("featrequired") != null) {%>
                        <fieldset class="inputbox">
                            <p class="p1">Required Feat: <input type="text" name="featreq" class="textinput"/></p>
                        </fieldset>
                        <%}
                            if (request.getAttribute("attributerequired") != null) {%>
                        <fieldset class="inputbox">
                            <p class="p1">Required Attributes</p>
                            <p>Strength: <input type="text" name="str" class="textinput"/></p>
                            <p>Dexterity: <input type="text" name="dex" class="textinput"/></p>
                            <p>Constitution: <input type="text" name="con" class="textinput"/></p>
                            <p>Intelligence: <input type="text" name="int" class="textinput"/></p>
                            <p>Wisdom: <input type="text" name="wis" class="textinput"/></p>
                            <p>Charisma: <input type="text" name="cha" class="textinput"/></p>
                        </fieldset>
                        <%}
                            if (request.getAttribute("babrequired") != null) {%>
                        <fieldset class="inputbox">
                            <p class="p1">Required BAB: <input type="text" name="bab" class="textinput"/></p>
                        </fieldset>
                        <%}
                            if (request.getAttribute("skillrequired") != null) {%>
                        <fieldset class="inputbox">
                            <p class="p1">Required Skill: <input type="text" name="skill" class="textinput"/></p>
                            <p>Required Rank: <input type="text" name="skillrank" class="textinput"/></p>
                        </fieldset>
                        <%}
                            if (request.getAttribute("casterrequired") != null) {%>
                        <fieldset class="inputbox">
                            <p class="p1">Required Caster level</p>
                            <p>Class: <input type="text" name="casterclass" class="textinput"/></p>
                            <p>CL: <input type="text" name="casterlevel" class="textinput"/></p>
                        </fieldset>
                        <%}
                            if (request.getAttribute("spellrequired") != null) {%>
                        <fieldset class="inputbox">
                            <p class="p1">Required Spell level</p>
                            <p>Class: <input type="text" name="spellclass" class="textinput"/></p>
                            <p>Spell level: <input type="text" name="spelllevel" class="textinput"/></p>
                        </fieldset>
                        <%}
                            if (request.getAttribute("saverequired") != null) {%>
                        <fieldset class="inputbox">
                            <p class="p1">Required Saving throws</p>
                            <p>Fortitude: <input type="text" name="fort" class="textinput"/></p>
                            <p>Reflex: <input type="text" name="refl" class="textinput"/></p>
                            <p>Will: <input type="text" name="will" class="textinput"/></p>
                        </fieldset>
                        <%}
                            if (request.getAttribute("alignmentrequired") != null) {%>
                        <fieldset class="inputbox">
                            <p class="p1">Required Alignment: <input type="text" name="alignment" class="textinput"/></p>
                        </fieldset>
                        <%}
                            if (request.getAttribute("deityrequired") != null) {%>
                        <fieldset class="inputbox">
                            <p class="p1">Required Deity: <input type="text" name="deity" class="textinput"/></p>
                        </fieldset>
                        <%}
                            if (request.getAttribute("racerequired") != null) {%>
                        <fieldset class="inputbox">
                            <p class="p1">Required Race: <input type="text" name="race" class="textinput"/></p><br>
                        </fieldset>
                        <%}
                            if (request.getAttribute("noreqs") != null) {%>
                        <p>This Feat has no requirements to be set</p>
                        <%} else {%>
                        <input type="submit" value="Send"/>
                        <%}%>
                    </form>
                </div>
            </div>

            <div class="info">
                <% if (request.getAttribute("classlist") != null) {%>
                <table border ="1">     
                    <tr>
                        <th>ID</th>
                        <th>Class Level Requirement</th>
                    </tr>
                    <c:forEach var="classreq" items="${classlist}">
                        <tr>
                            <td>${classreq.id}</td>
                            <td>${classreq.requiredClass.name}, (${classreq.requiredClass.ruleSet.name}) ${classreq.requiredLvl}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/RemoveFeatRequirement"
                                      method="post">
                                    <input type="hidden" name="req" value="class">
                                    <input type="hidden" name="reqid" value="${classreq.id}">
                                    <input type="submit" name="remove" value="Remove">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <br>
                <%}
                    if (request.getAttribute("level") != null) {%>
                <table border ="1">     
                    <tr>
                        <th>ID</th>
                        <th>Level Requirement</th>
                    </tr>
                    <tr>
                        <td>${level.id}</td>
                        <td>${level.requiredLvl}</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/RemoveFeatRequirement"
                                  method="post">
                                <input type="hidden" name="req" value="level">
                                <input type="hidden" name="reqid" value="${level.id}">
                                <input type="submit" name="remove" value="Remove">
                            </form>
                        </td>
                    </tr>
                </table>
                <br>
                <%}
                    if (request.getAttribute("featlist") != null) {%>
                <table border ="1">     
                    <tr>
                        <th>ID</th>
                        <th>Feat Requirement</th>
                    </tr>
                    <c:forEach var="featreq" items="${featlist}">
                        <tr>
                            <td>${featreq.id}</td>
                            <td>${featreq.requiredFeat.name}, (${featreq.requiredFeat.ruleSet.name})</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/RemoveFeatRequirement"
                                      method="post">
                                    <input type="hidden" name="req" value="feat">
                                    <input type="hidden" name="reqid" value="${featreq.id}">
                                    <input type="submit" name="remove" value="Remove">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <br>
                <%}
                    if (request.getAttribute("attributelist") != null) {%>
                <table border ="1">     
                    <tr>
                        <th>ID</th>
                        <th>Attribute Requirement</th>
                    </tr>
                    <c:forEach var="attreq" items="${attributelist}">
                        <tr>
                            <td>${attreq.id}</td>
                            <td>STR: ${attreq.STR} DEX: ${attreq.DEX} CON: ${attreq.CON} INT: ${attreq.INTG} WIS: ${attreq.WIS} CHA: ${attreq.CHA}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/RemoveFeatRequirement"
                                      method="post">
                                    <input type="hidden" name="req" value="att">
                                    <input type="hidden" name="reqid" value="${attreq.id}">
                                    <input type="submit" name="remove" value="Remove">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <br>
                <%}
                    if (request.getAttribute("bab") != null) {%>
                <table border ="1">     
                    <tr>
                        <th>ID</th>
                        <th>Base Attack Bonus Requirement</th>
                    </tr>
                    <tr>
                        <td>${bab.id}</td>
                        <td>${bab.BAB}</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/RemoveFeatRequirement"
                                  method="post">
                                <input type="hidden" name="req" value="bab">
                                <input type="hidden" name="reqid" value="${bab.id}">
                                <input type="submit" name="remove" value="Remove">
                            </form>
                        </td>
                    </tr>
                </table>
                <br>
                <%}
                    if (request.getAttribute("skilllist") != null) {%>
                <table border ="1">     
                    <tr>
                        <th>ID</th>
                        <th>Skill Requirement</th>
                    </tr>
                    <c:forEach var="skillreq" items="${skilllist}">
                        <tr>
                            <td>${skillreq.id}</td>
                            <td>${skillreq.skill.name}, (${skillreq.skill.ruleSet.name})</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/RemoveFeatRequirement"
                                      method="post">
                                    <input type="hidden" name="req" value="skill">
                                    <input type="hidden" name="reqid" value="${skillreq.id}">
                                    <input type="submit" name="remove" value="Remove">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <br>
                <%}
                    if (request.getAttribute("casterlist") != null) {%>
                <table border ="1">     
                    <tr>
                        <th>ID</th>
                        <th>Caster Level Requirement</th>
                    </tr>
                    <c:forEach var="casterreq" items="${casterlist}">
                        <tr>
                            <td>${casterreq.id}</td>
                            <td>${casterreq.cclass.name}, (${casterreq.cclass.ruleSet.name}) ${casterreq.casterLvl}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/RemoveFeatRequirement"
                                      method="post">
                                    <input type="hidden" name="req" value="caster">
                                    <input type="hidden" name="reqid" value="${casterreq.id}">
                                    <input type="submit" name="remove" value="Remove">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <br>
                <%}
                    if (request.getAttribute("spelllist") != null) {%>
                <table border ="1">     
                    <tr>
                        <th>ID</th>
                        <th>Spell Level Requirement</th>
                    </tr>
                    <c:forEach var="spellreq" items="${spelllist}">
                        <tr>
                            <td>${spellreq.id}</td>
                            <td>${spellreq.cclass.name}, (${spellreq.cclass.ruleSet.name}) ${spellreq.spellLvl}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/RemoveFeatRequirement"
                                      method="post">
                                    <input type="hidden" name="req" value="spell">
                                    <input type="hidden" name="reqid" value="${spellreq.id}">
                                    <input type="submit" name="remove" value="Remove">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <br>
                <%}
                    if (request.getAttribute("savelist") != null) {%>
                <table border ="1">     
                    <tr>
                        <th>ID</th>
                        <th>Save Requirement</th>
                    </tr>
                    <c:forEach var="savereq" items="${savelist}">
                        <tr>
                            <td>${savereq.id}</td>
                            <td>Fortitude: ${savereq.fortSave} Reflex: ${savereq.reflSave} Will: ${savereq.willSave}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/RemoveFeatRequirement"
                                      method="post">
                                    <input type="hidden" name="req" value="save">
                                    <input type="hidden" name="reqid" value="${savereq.id}">
                                    <input type="submit" name="remove" value="Remove">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <br>
                <%}
                    if (request.getAttribute("alignmentlist") != null) {%>
                <table border ="1">     
                    <tr>
                        <th>ID</th>
                        <th>Alignment Requirement</th>
                    </tr>
                    <c:forEach var="alreq" items="${alignmentlist}">
                        <tr>
                            <td>${alreq.id}</td>
                            <td>${alreq.alignment}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/RemoveFeatRequirement"
                                      method="post">
                                    <input type="hidden" name="req" value="al">
                                    <input type="hidden" name="reqid" value="${alreq.id}">
                                    <input type="submit" name="remove" value="Remove">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <br>
                <%}
                    if (request.getAttribute("deitylist") != null) {%>
                <table border ="1">     
                    <tr>
                        <th>ID</th>
                        <th>Deity Requirement</th>
                    </tr>
                    <c:forEach var="deityreq" items="${deitylist}">
                        <tr>
                            <td>${deityreq.id}</td>
                            <td>${deityreq.deity.name}, (${deityreq.deity.ruleSet.name})</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/RemoveFeatRequirement"
                                      method="post">
                                    <input type="hidden" name="req" value="deity">
                                    <input type="hidden" name="reqid" value="${deityreq.id}">
                                    <input type="submit" name="remove" value="Remove">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <br>
                <%}
                    if (request.getAttribute("racelist") != null) {%>
                <table border ="1">     
                    <tr>
                        <th>ID</th>
                        <th>Race Requirement</th>
                    </tr>
                    <c:forEach var="racereq" items="${racelist}">
                        <tr>
                            <td>${racereq.id}</td>
                            <td>${racereq.race.name}, (${racereq.race.ruleSet.name})</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/RemoveFeatRequirement"
                                      method="post">
                                    <input type="hidden" name="req" value="race">
                                    <input type="hidden" name="reqid" value="${racereq.id}">
                                    <input type="submit" name="remove" value="Remove">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <br>
                <%}%>
            </div>
        </div>
    </body>
</html>

