<%@ page import="az.charming.teachermanagement.dto.StudentDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
</head>
<body>
    <%
       StudentDto loggedIn =  (StudentDto)session.getAttribute("loggedInStudent");
       if(loggedIn!=null){
           out.println("Hello, "+loggedIn.getUsername());
       }else {

       }
    %>
</body>
</html>
