<%--
  Created by IntelliJ IDEA.
  User: nicholaslindquist
  Date: 12/2/17
  Time: 8:23 PM
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
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/admin.css"/>"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="<s:url value="/js/jquery-2.1.4.min.js"/>"></script>
    <title>eRSPG</title>
</head>

<body>
    <div class="footer navbar-fixed-bottom">
        <div id="content" class="main">
            <div class="form-group">
                <form:form method="get" action="/eRSPG/chairman/manageBudget" modelAttribute="ManageBudgetForm">
                    <label class="col-sm-4 control-label form-inline">Started Balance:
                        <form:input path="totalBudget"  placeholder="Please input budget..."/>
                    </label>
                    <label class="col-sm-5 control-label form-inline">Balance Remaining:
                        <form:input path="remainingBudget" placeholder="Remaining Budget"/>
                    </label>
                </form:form>
            </div>
        </div>
    </div>

</body>
</html>
