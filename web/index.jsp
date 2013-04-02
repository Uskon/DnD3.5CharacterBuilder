<%-- 
    Document   : index
    Created on : Mar 19, 2013, 12:06:42 PM
    Author     : Uskon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DnD 3.5 CharBuilder</title>
    </head>
    <body>
        <nav>
            <a href="Login.jsp">Login</a>
        </nav>
        <div id="container">
            <div id="header">
                <h1>DnD 3.5 Character Builder</h1></div>
            <div id="menu" style="width:15%;float:left;">
                <b>Menu</b><br>
                <button type="button" href="/createChar">Create a new Character</button><br>
                <br>
                <b>Browse:</b><br>
                <button type="button" onclick="showDescription()">Races</button><br>
                <button type="button" onclick="showDescription()">Classes</button><br>
                <button type="button" onclick="showDescription()">Deities</button><br>
                <button type="button" onclick="showDescription()">Feats</button><br>
                <button type="button" onclick="showDescription()">Text here</button><br>
                <br>
            </div>

            <div id="content" float:left>
                <p id="content">
                    Content descriptions to be added
                </p>
            </div>
        </div>

        <script>
            function showDescription()
            {
                x=document.getElementById("content");
                x.innerHTML="Enter description here";
            }
        </script>

</body>
</html>
