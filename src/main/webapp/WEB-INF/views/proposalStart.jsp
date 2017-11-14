<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">

    <%--<% String pageName = "index"; %>--%>
    <%--<%@include file="/WEB-INF/views/breadcrumbs.jsp" %>--%>

    <legend><h2 style="text-align:center;">RSPG Proposal Submission</h2></legend>
    <form:form class="form-horizontal" method="post" action="index" modelAttribute="userForm">

        <div class="form-group">
            <label class="col-sm-3 control-label required-field" for="userFirstName"> First Name:&nbsp </label>
            <div class="col-sm-9">
                <form:input class="form-control" type="text" path="firstName" required="true"/>
            </div>
            <%--<form:errors cssClass="form-error" path="firstName"/>--%>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label required-field" for="userLastName"> Last Name:&nbsp </label>
            <div class="col-sm-9">
                <form:input class="form-control" type="text" path="lastName" required="true"/>
            </div>
            <%--<form:errors cssClass="form-error" path="lastName"/>--%>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label required-field" for="email">Email:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
            <div class="col-sm-9">
                <form:input class="form-control" type="email" path="userEmail" required="true"/>
            </div>
            <%--<form:errors cssClass="form-error" path="userEmail"/>--%>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label" >Password:&nbsp&nbsp</label>

            <div class="col-sm-9">
                <input class="form-control" type="password" required="true"/>
            </div>
        </div>

        <input type="hidden" name="nextPage" id="nextPage" value="0"/>

        <div class="button-row">
            <button type="button" class="btn my-btn" onclick='setNextPage("proposal/start", "/")'>Submit</button>
                <%--<Button type="submit" class="btn my-btn" value="Submit" >Submit</Button>--%>
            <%--<Button type="button" class="btn my-btn" value="start" onclick='window.location.href="<s:url value="start" />"' >Submit</Button>--%>
        </div>
    </form:form>

</div>