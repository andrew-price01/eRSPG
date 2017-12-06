<%--
  Created by IntelliJ IDEA.
  User: Andrew
  Date: 10/23/2017
  Time: 5:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/bootstrap.min.css"/>" />
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/bootstrap-theme.min.css"/>" />
    <%-- <link rel="stylesheet" type="text/css" href="<s:url value="/css/home.css"/>" /> --%>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/form-styles.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/breadcrumb.css"/>" />
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/navbar.css"/>" />
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/button-design.css"/>" />
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/chairman.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/sidenavbar.css"/>"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="<s:url value="/js/jquery-2.1.4.min.js"/>"></script>
    <title>eRSPG</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>


<div class="wrapper">

    <nav id="sidebar" class="sidebar">
        <!-- Sidebar Header -->
        <div class="sidebar-header">
            <h3>Chairman Dashboard</h3>
        </div>

        <!-- Sidebar Links -->
        <ul class="list-unstyled components">
            <li class="active"><a class="btn my-btn" type="button"  onclick="window.location.href = '/eRSPG/chairman/home'" value="Chairman Home">Home</a></li>
            <li><a class="btn my-btn" type="button" onclick="window.location.href= '/eRSPG/chairman/committee'" value="Manage Committee">Manage Committee</a></li>
            <li><a class="btn my-btn" type="button" onclick="window.location.href= '/eRSPG/chairman/proposal'" value="Chairman Proposals">Proposals</a></li>
            <li><a class="btn my-btn" type="button" onclick="window.location.href = '/eRSPG/chairman/makeAnnouncement'" value="Announcement">Make Announcement</a></li>
        </ul>
    </nav>

    <!-- Page Content -->
    <div id="content" class="main">
        <h1>Home</h1>

        <div>
            <input class="btn my-btn" type="button"  onclick="window.location.href = '/eRSPG/chairman/assignproposal'" value="Assign Proposals" />

            <input class="btn my-btn" type="button"  onclick="window.location.href = '/eRSPG/chairman/reviewproposal'" value="Review Proposals" />
        </div>

        <br>

        <div>
            <input class="btn my-btn" type="button"  onclick="window.location.href = '/eRSPG/chairman/committee'" value="Manage Committee" />

            <input class="btn my-btn" type="button"  onclick="window.location.href = '#'" value="Manage Funds" />
        </div>

    </div>

</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>