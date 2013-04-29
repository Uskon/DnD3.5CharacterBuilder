<nav>
    <%
    if (session.getAttribute("logged") == null) {
    %>
    <a href="Login.jsp" style="float:right">Login</a>
    <%} else {%>
    <a href="AddNewContent.jsp" style="float:left">Add Content</a>
    <a href="Logout.jsp" style="float:right;">Logout</a>
    <%}%>
    <a href=""></a>
</nav>