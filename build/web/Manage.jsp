<%-- 
    Document   : Manage
    Created on : Apr 24, 2013, 5:15:31 PM
    Author     : Uskon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Component Management</title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
    </head>
    <body>
        <h1>Choose the type of component you wish to manage</h1>

        <p>Functions include adding descriptions as well as setting Requirements and other inter-component connections</p>
        <p>All components can also be removed directly from here</p>

        <p><a href="ManageClasses">Classes</a></p>

        <p><a href="ManageFeats">Feats</a></p>
        
        <p><a href="ManageRaces">Races</a></p>

        <p><a href="ManageDeities">Deities</a></p>

        <p><a href="ManageDomains">Domains</a></p>
        
        <p><a href="ManageSkills">Skills</a></p>
        
        <p><a href="ManageRuleSets">Rule Sets</a></p>

    </body>
</html>
