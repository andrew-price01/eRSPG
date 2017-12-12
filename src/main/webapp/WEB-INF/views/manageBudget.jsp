<%--
  Created by IntelliJ IDEA.
  User: nicholaslindquist
  Date: 11/29/17
  Time: 6:40 PM
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
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/table.css"/>"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="<s:url value="/js/jquery-2.1.4.min.js"/>"></script>
    <title>eRSPG</title>
</head>

<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<nav id="sidebar" class="sidebar">
    <!-- Sidebar Header -->
    <div class="sidebar-header">
        <h3>Chair Dashboard</h3>
    </div>

    <!-- Sidebar Links -->
    <ul class="list-unstyled components">
        <li><a class="btn my-btn" type="button"  onclick="window.location.href = '/eRSPG/chair/home'" value="Chairman Home">Home</a></li>
        <li><a class="btn my-btn" type="button" onclick="window.location.href= '/eRSPG/chair/committee'" value="Manage Committee">Manage Committee</a></li>
        <li class="active"><a class="btn my-btn" type="button"  onclick="window.location.href = '/eRSPG/chair/manageBudget'" value="Manage Budget">Manage Budget</a></li>
        <li><a class="btn my-btn" type="button" onclick="window.location.href= '/eRSPG/chair/proposal'" value="Chairman Proposals">Proposals</a></li>
        <li><a class="btn my-btn" type="button" onclick="window.location.href = '/eRSPG/chair/makeAnnouncement'" value="Announcement">Make Announcement</a></li>
    </ul>
</nav>

<!-- Page Content -->
<div id="content" class="main">
    <legend>
        <h2 style="text-align:center;">Budget For
            <script language="JavaScript" type="text/javascript">
                now = new Date
                theYear=now.getYear()
                if (theYear < 1900)
                    theYear=theYear+1900
                document.write(theYear)
            </script>
        </h2>
    </legend>
</div>

<!-- Page Content -->
<div id="content" class="main">
    <div class="form-group col-lg-12">
        <form:form method="get" action="/eRSPG/chair/budgetDetails" modelAttribute="BudgetDetails">
            <table>
                <tr>
                    <th>Accept</th>
                    <th>Decline</th>
                    <th>Proposal ID</th>
                    <th>Proposal Title</th>
                    <th>Fund Category</th>
                    <th>Funds Requested</th>
                </tr>
                <c:forEach items="${BudgetDetails}" var="budget">
                    <tr>
                        <td><input type="checkbox" style="background-color: green"/></td>
                        <td><input type="checkbox" style="background-color: red"/></td>
                        <td>${budget.proposalID}</td>
                        <td>${budget.proposalTitle}</td>
                        <td>${budget.fundCategoryName}</td>
                        <td>${budget.fundAmount}</td>
                    </tr>
                </c:forEach>
            </table>
        </form:form>
    </div>
</div>

<jsp:include page="/WEB-INF/views/manageBudgetFooter.jsp"/>
</body>


</html>
