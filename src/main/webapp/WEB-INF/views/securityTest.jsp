<%--
  Created by IntelliJ IDEA.
  User: Yong-W530
  Date: 10/13/2017
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Hello <security:authentication property="principal.username" />!
    <security:authorize access="hasRole('ROLE_USER')">
        <br>
        You see this message because you have the <b>user</b> role.
    </security:authorize>

    <security:authorize access="hasRole('ROLE_ADMIN')">
        <br>
        You see this message because you have the <b>admin</b> role.
    </security:authorize>

</body>
</html>
