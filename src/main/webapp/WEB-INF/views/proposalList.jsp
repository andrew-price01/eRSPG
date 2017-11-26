<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/bootstrap.min.css"/>" />
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/bootstrap-theme.min.css"/>" />
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/form-styles.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/breadcrumb.css"/>" />
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/navbar.css"/>" />
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/button-design.css"/>" />
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/table.css" />" />
    <%--<link rel="stylesheet" type="text/css" href="<s:url value="/css/table.css"/>" />--%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0">
    <meta name="viewport" content="width=device-width">
    <meta name="viewport" content="width=320, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"/>
    <script type="text/javascript" src="<s:url value="/js/jquery-2.1.4.min.js"/>"></script>
    <script type="text/javascript" src="<s:url value="/js/moment.js"/>"></script>
    <script type="text/javascript" src="<s:url value="/js/navigation.js"/>"></script>
    <title>eRSPG Proposals</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<div class="container">
    <legend><h2 style="text-align:center;">Proposals</h2></legend>

    <table>
        <thead>
            <tr>
                <th>Title</th>
                <th>Submitter</th>
                <th>Project Director</th>
                <th>Department</th>
                <th>Proposal Year</th>
                <th>Submission Date</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>
<jsp:include page="/WEB-INF/views/footer.jsp"/>
<script type="text/javascript" src="<s:url value="/js/proposalList.js"/>"></script>
</body>
</html>