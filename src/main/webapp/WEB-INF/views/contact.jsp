<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/bootstrap.min.css"/>" />
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/bootstrap-theme.min.css"/>" />
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/form-styles.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/breadcrumb.css"/>" />
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/navbar.css"/>" />
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/button-design.css"/>" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="<s:url value="/js/jquery-2.1.4.min.js"/>"></script>
    <title>eRSPG</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/header_noLogin.jsp"/>

<div class="container">
    <legend><h2 style="text-align:center;">Contact Us</h2></legend>

    <div style="text-align: center;">
        <br>
        <br>
        <ul style="list-style:none" class="contactInfoPoint" id="contactInfo">
            <li>Dr. Zhang Yong</li>
            <li>Email: <a href="mailto:yongzhang@weber.edu">yongzhang@weber.edu</a></li>
            <li>Office: TE-110C</li>
            <li>Phone: (801) 626-7682</li>
        </ul>
    </div>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>
