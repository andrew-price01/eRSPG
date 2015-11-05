<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<s:url value="/css/home.css"/>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>eRSPG</title>
</head>
<body>

 <div class="centerdiv"> 
	<div class="centerbuttons" >
		<input class="buttons"  onclick="window.location.href = 'proposal/proposals'" style= "margin-right:15px" type="button"   value="View Proposals"/>
		<input class="buttons" type="button"  onclick="window.location.href = 'proposal/index'" value="Submit Proposal" />
	</div>
</div>

</body>
</html>