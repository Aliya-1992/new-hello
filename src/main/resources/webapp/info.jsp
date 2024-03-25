<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<p>Name: <%= request.getParameter("username") %></p>
<p>Age: <%= request.getParameter("userage") %></p>
<p>Gender: <%= request.getParameter("gender") %></p>
<p>Country: <%= request.getParameter("country") %></p>
<p>Languages:</p>
<ul>
<%

    String[] languages = request.getParameterValues("languages");
    for(String language: languages){
        out.println("<li> " +language + "</li> ");
    }
%>
</ul>
</body>
</html>