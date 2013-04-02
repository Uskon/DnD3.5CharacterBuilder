<%-- 
    Document   : AddNewRace
    Created on : Mar 21, 2013, 11:30:27 AM
    Author     : Uskon
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Race Manager</title>
    </head>
    <body>
        <h1>Input the information for the race to be added</h1>
        
        <form name="newRace"
              action="${pageContext.request.contextPath}/AddRace"
              method="post">
            Race Name: <input id="field1" type="text" name="raceName"/> <br/>
            Attribute Bonuses: <input id="field2" type="text" name="abonus"/> <br/>
            Race Description: <input type="text" name="rdescription"/> <br/>
            Rule Set: <input id="field4" type="text" name="rset"/> <br/>
            <input type="submit" onclick="checkInput()" value="Send"/>
        </form>

        <h2>Existing races:</h2>

        <table border ="1">     
            <tr>
                <th>Race Name</th>
                <th>Attribute Bonuses</th>
                <th>Rule Set</th>
            </tr>
            <c:forEach var="Race" items="${raceList}">
                <tr>
                    <td>${Race.raceName}</td>
                    <td>${Race.attributeBonuses}</td>
                    <td>${Race.ruleSet.name}</td>
                </tr>
            </c:forEach>
        </table>
        
        <script>
            function checkInput()
            {
            var x=document.getElementyById("field1").value;
            if(x=="")
                {
                alert("All fields must be filled")
                }
            }
        </script>
    </body>
</html>
