<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %><html>
<html>
<head>
    <title>Client</title>
</head>
<body>
    <div><a href="index.jsp">Main Page</a></div>
    <div>
        <ul>
            <li>Login: ${login}</li>
            <li>Password: ${password}</li>
            <li>ID: ${id}</li>
        </ul>
    </div>
</body>
</html>
