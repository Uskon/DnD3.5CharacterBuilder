<%
    if (session.getAttribute("logged") == null) {
        response.sendRedirect("Login.jsp");
    }
%>