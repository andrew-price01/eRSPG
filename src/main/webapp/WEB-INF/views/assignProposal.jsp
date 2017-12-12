<%--
  Created by IntelliJ IDEA.
  User: Andrew
  Date: 11/20/2017
  Time: 6:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/bootstrap-theme.min.css"/>"/>
    <%--link rel="stylesheet" type="text/css" href="<s:url value="/css/home.css"/>" /> --%>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/table.css"/> "/>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/form-styles.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/breadcrumb.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/navbar.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/button-design.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/chairman.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/sidenavbar.css"/>"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="<s:url value="/js/jquery-2.1.4.min.js"/>"></script>
    <script type="text/javascript" src="<s:url value="/js/moment.js"/>"></script>
    <script type="text/javascript" src="<s:url value="/js/navigation.js"/>"></script>
    <title>eRSPG</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>


<div class="wrapper">

    <nav id="sidebar" class="sidebar">
        <!-- Sidebar Header -->
        <div class="sidebar-header">
            <h3>Chair Dashboard</h3>
        </div>

        <!-- Sidebar Links -->
        <ul class="list-unstyled components">
            <li><a class="btn my-btn" type="button"  onclick="window.location.href = '/eRSPG/chair/home'" value="Chair Home">Home</a></li>
            <li><a class="btn my-btn" type="button" onclick="window.location.href= '/eRSPG/chair/committee'" value="Manage Committee">Manage Committee</a></li>
            <li class="active"><a class="btn my-btn" type="button" onclick="window.location.href= '/eRSPG/chair/proposal'" value="Chair Proposals">Proposals</a></li>
            <li><a class="btn my-btn" type="button" onclick="window.location.href = '/eRSPG/chair/makeAnnouncement'" value="Announcement">Make Announcement</a></li>
        </ul>
    </nav>

    <!-- Page Content -->
    <div id="content" class="main">
        <h1>Manage Proposals</h1>

        <br>

        <div id="window">
            <h3 align="left">Submitted Proposals</h3>
            <input type='button' class="btn btn-info" style="float: right;" id='hideshow' value='hide/show'>
            <div id="box1">
                <table align="center">
                    <thead>
                    <tr>
                        <th>Title</th>
                        <th>Submitter</th>
                        <th>Department</th>
                        <th>Proposal Year</th>
                        <th>Submission Date</th>
                        <th>Status</th>
                    </tr>
                    </thead>
                    <tbody id="submitted"></tbody>
                </table>

            </div>
        </div>

        <br>

        <form action="/eRSPG/chair/assignproposal" method="post">
            <input class="btn my-btn" type="submit" value="Assign To All"/>
        </form>

        <br>

        <%--<input class="btn my-btn" type="button" onclick="window.location.href= '/eRSPG/chair/assignproposal'" value="Assign To All" />--%>

        <br>
        <div id="window">
            <h3 align="left">In Review</h3>
            <input type='button' class="btn btn-info" style="float: right;" id='hideshow1' value='hide/show'>
            <div id="box2">
                <table align="center">
                    <thead>
                    <tr>
                        <th>Title</th>
                        <th>Submitter</th>
                        <th>Department</th>
                        <th>Proposal Year</th>
                        <th>Submission Date</th>
                        <th>Status</th>
                    </tr>
                    </thead>
                    <tbody id="review"></tbody>
                </table>
            </div>
        </div>

    </div>

</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
<script type="text/javascript" src="<s:url value="/js/assignProposalList.js"/>"></script>
</body>
</html>