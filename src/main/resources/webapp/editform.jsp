<%@page import="org.example.crud.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update Person info</title>
    <style type="text/css">
            body {
                padding-left: 38em;
                background-color: #03fcad;
                position:center;}
                ul.navbar {
                position: absolute;
                top: 2em;
                left: 1em;
                width: 9em }

        </style>
</head>
<body>
<%
String id = request.getParameter("id");
Person person = PersonDao.getPersonById(Integer.parseInt(id));
%>
<h1>Update Person info</h1>

<p></p>
<form action="edituser.jsp" method="post">
<input type="hidden" name="id" value="<%=person.getId()%>"
    <table>
        <tr><td>Name:</td><td><input type="text" name="userName" value="<%=person.getUserName()%>"/></td></tr>
        <br>
        <br>
        <tr><td>Password:</td><td><input type="password" name="userPass" value="<%=person.getUserPass()%>"/></td></tr>
        <br>
        <br>
        <tr><td>Email:</td><td><input type="email" name="userEmail" value="<%=person.getUserEmail()%>"/></td></tr>
        <br>
        <br>
        <tr><td>Country:</td><td>
            <select name="userCountry" style="width:150px">
                <option>India</option>
                <option>USA</option>
                <option>UK</option>
                <option>Other</option>
            </select>
        </td></tr>
        <tr><td colspan="2"><input type="submit" value="Edit"/></td></tr>
    </table>
</form>



</body>
</html>
