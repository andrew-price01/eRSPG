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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="<s:url value="/js/jquery-2.1.4.min.js"/>"></script>
    <title>eRSPG</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<div class="container">
	<legend><h2 style="text-align:center;">eRSPG Home</h2></legend>
	
	<div style="text-align: center;">
<<<<<<< HEAD
		<input class="btn my-btn" onclick="window.location.href = '/eRSPG/chairman/userManagement'" value="Manage Committee" />
		<input class="btn my-btn" onclick="window.location.href = 'proposal/proposals'" style= "margin-right:15px" type="button" value="View Proposals"/>
=======
		<input class="btn my-btn" onclick="window.location.href = 'proposal/list'" style= "margin-right:15px" type="button" value="View Proposals"/>
>>>>>>> b1167083063dd6d44b1f54aa0c8534c74413ace5
		<input class="btn my-btn" type="button"  onclick="window.location.href = 'proposal/index'" value="Submit Proposal" />
	</div>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>