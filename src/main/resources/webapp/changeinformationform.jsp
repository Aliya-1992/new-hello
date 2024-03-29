<%@page import="org.example.crud.PersonDao,org.example.crud.*,java.util.*"%>
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
String userName = request.getParameter("name");

Person person = PersonDao.getPersonByName(userName);

%>
<h1>Update Person info</h1>
<h1></h1>
<br>
<form action="changeinformationuser.jsp" method="post">
<input type="hidden" name="id" value="${sessionScope.id}"
    <table>
        <tr><td>Name:</td><td><input type="text" name="userName" value="${sessionScope.userName}"/></td></tr>
        <br>
        <br>
        <tr><td>Password:</td><td><input type="password" name="userPass" value="${sessionScope.userPass1}"/></td></tr>
        <br>
        <br>
        <tr><td>Email:</td><td><input type="email" name="userEmail" value="${sessionScope.userEmail}"/></td></tr>
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

        <br>
        <tr><td colspan="2"><input type="submit" value="Edit"/></td></tr>
    </table>
</form>

<br/>

</body>
</html>
