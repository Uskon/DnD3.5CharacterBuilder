<%-- 
    Document   : createChar
    Created on : Mar 30, 2013, 6:13:54 PM
    Author     : Uskon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="newChar"
              action="${pageContext.request.contextPath}/SetRace"
              method="post">
            Character Name: <input id="field1" type="text" name="charName"/> <br>            
            <input type="submit" value="Send"/>
        </form>
    </body>
</html>
