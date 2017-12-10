<%--
  Created by IntelliJ IDEA.
  User: Andrew
  Date: 10/23/2017
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/bootstrap-theme.min.css"/>"/>
    <%-- <link rel="stylesheet" type="text/css" href="<s:url value="/css/home.css"/>" /> --%>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/form-styles.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/breadcrumb.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/navbar.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/button-design.css"/>"/>
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
            <li><a class="btn my-btn" type="button"  onclick="window.location.href = '/eRSPG/chairman/home'" value="Chairman Home">Home</a></li>
            <li><a class="btn my-btn" type="button" onclick="window.location.href= '/eRSPG/chairman/committee'" value="Manage Committee">Manage Committee</a></li>
            <li><a class="btn my-btn" type="button"  onclick="window.location.href = '/eRSPG/chairman/manageBudget'" value="Manage Budget">Manage Budget</a></li>
            <li><a class="btn my-btn" type="button" onclick="window.location.href= '/eRSPG/chairman/proposal'" value="Chairman Proposals">Proposals</a></li>
            <li class="active"><a class="btn my-btn" type="button" onclick="window.location.href = '/eRSPG/chairman/makeAnnouncement'" value="Announcement">Make Announcement</a></li>
        </ul>
    </nav>

    <!-- Page Content -->
    <div id="content" class="main">

        <div class="col-md-8 col-md-offset-2 text-center">
            <h2 align="left">Create Announcement</h2>

			<form:form class="form-horizontal" method="post" action="/eRSPG/chairman/makeAnnouncement" modelAttribute="announcement">
                <div class="form-group col-xs-10" style="margin-bottom:0px;">
                    <form:input path="title" class="form-control input-xs-5 input-lg" id="title" placeholder="Title" />
                </div>
                <div class="form-group col-xs-10">
                    ​<form:textarea path="message" class="form-control input-xs-8" style="resize: none" id="message" rows="5" placeholder="Enter announcement text here..." />
                </div>
                <div class="form-group col-xs-10 clearfix">
                    <button id="saveButton" class="btn my-btn pull-right">Publish</button>
                </div>
			</form:form>
        </div>


    </div>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>