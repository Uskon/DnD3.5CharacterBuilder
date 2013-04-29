<nav>
    <a href="AddNewContent.jsp"><b>Main</b></a> ||
    <a href="AddNewRuleSet">Rule Sets</a> |
    <a href="AddNewRace">Races</a> |
    <a href="AddNewClass">Classes</a> |
    <a href="AddNewFeat">Feats</a> |
    <a href="AddNewSkill">Skills</a> |
    <a href="AddNewDeity">Deities</a> | 
    <a href="AddNewDomain">Domains</a> --
    <a href="Manage.jsp">Manage Components</a>
    
    <%
    if (session.getAttribute("logged") == null) {
    %>
    <a href="Login.jsp" style="float:right">Login</a>
    <%} else {%>
    <a href="Logout.jsp" style="float:right;">Logout</a>
    <%}%>
    <a href=""></a>
</nav>