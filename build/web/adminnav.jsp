<nav>
    <a href="AddNewRuleSet">Rule Sets</a> |
    <a href="AddNewRace">Races</a> |
    <a href="AddNewClass">Classes</a> |
    <a href="AddNewSkill">Skills</a> |
    <a href="AddNewClassSkill">Class Skills</a>
    
    <%
    if (session.getAttribute("logged") == null) {
    %>
    <a href="Login.jsp" style="float:right">Login</a>
    <%} else {%>
    
    <a href="Logout.jsp" style="float:right;">Logout</a>
    <%}%>
    <a href=""></a>
</nav>