<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %><html>
<html>
<head>
    <title>Form</title>
</head>
<body>
    <div>
        <a href="index.jsp">Main Page</a>
    </div>
    <div>
        <h1>Input register info</h1>

        <form method="post">
            <ul>
                <li>Login: <input name="login" type="text"></li>
            </ul>
            <ul>
                <li>Password: <input name="password" type="password"></li>
            </ul>
            <ul>
                <li>Submit:<input type="submit" value="submit"></li>
            </ul>
        </form>
    </div>
</body>
</html>
