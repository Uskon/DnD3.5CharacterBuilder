<%-- 
    Document   : AddNewContent
    Created on : Apr 2, 2013, 6:42:48 PM
    Author     : Uskon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adding content</title>
        <link rel="stylesheet" type="text/css" href="MainCSS.css">
        <%@ include file="adminnav.jsp" %>
        <%@ include file="loginchecker.jsp" %>
    </head>
    <body>
        <h1>Database Administration</h1>
        <fieldset class="inputbox" style="width:500px">
            <p>Rule Sets, Races, Classes, Feats, Skills, Deities and Domains can be easily added using the links that can be found on the navigation bar above.</p>
            <p>The addition and setting of descriptions, requirements and other additional properties can be managed through Manage Components</p>
        </fieldset>
        <br>
        <fieldset class="inputbox" style="width:500px">
            <p><b>Info</b></p>
            <p>Rule Set is also referred to as Source, since it's technically the correct word.</p>
            <p>Also, when inputting Alignments, the options are the following:</p>
            <p>LG - <i>Lawful Good</i></p>
            <p>LN - <i>Lawful Neutral</i></p>
            <p>LE - <i>Lawful Evil</i></p>
            <p>NG - <i>Neutral Good</i></p>
            <p>N - <i>Neutral</i></p>
            <p>NE - <i>Neutral Evil</i></p>
            <p>CG - <i>Chaotic Good</i></p>
            <p>CE - <i>Chaotic Evil</i></p>
        </fieldset>
    </body>
</html>
