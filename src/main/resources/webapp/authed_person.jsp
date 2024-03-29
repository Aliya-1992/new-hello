<%@page import="org.example.crud.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
      <style type="text/css">
            body {
                padding-left: 38em;
                background-color: #03fcad;
                position:center;
                font-family: Georgia, "Times New Roman",
                Times, serif;}
        </style>
</head>
<body>
<%
HttpSession httpSession = request.getSession();
if(session == null){
	response.sendRedirect("auth.html");
}
else {
String userName = (String) httpSession.getAttribute("userName");
String userEmail = (String) httpSession.getAttribute("userEmail");
String userCountry = (String) httpSession.getAttribute("userCountry");
String userPass = (String) httpSession.getAttribute("userPass");
String userPass1 = (String) httpSession.getAttribute("userPass1");
}
%>
<h3>Hello ${sessionScope.userName}</h3>
<h3></h3>
<img src="images.jpg"/>
<br>
<br>
Your data:
<p>Your name ${sessionScope.userName}</p>
<p>Your email ${sessionScope.userEmail}</p>
<p>Your country ${sessionScope.userCountry}</p>



<a href="changeinformationform.jsp">Edit</a>
<form action="logout" method="post">
<input type="submit" value="Logout" >
</form>

</body>
</html>