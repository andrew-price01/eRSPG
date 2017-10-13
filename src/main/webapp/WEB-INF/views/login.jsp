<%--
  Created by IntelliJ IDEA.
  User: Yong-W530
  Date: 10/13/2017
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    eRSPG Login:
    <br>
    <form name='f' commandName='home' method='POST'>
        <table>
            <tr><td>User:</td><td>
                <input type='text' name='username' value='admin' /></td></tr>
            <tr><td>Password:</td>
                <td><input type='password' name='password' value='password'/></td></tr>
            <tr><td colspan='2'>
                <input name="submit" type="submit" value="Login"/></td></tr>
        </table>

    </form>
</body>
</html>
