<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<div class="container">
    <% String pageName = "detail"; %>
    <%@include file="/WEB-INF/views/breadcrumbs.jsp" %>

    <legend><h2 style="text-align:center;">Project Details</h2></legend>
    <form:form class="form-horizontal" method="post" action="detail" modelAttribute="detailForm">
        <div class="form-group">
            <label class="col-sm-3 control-label required-field" for="proposalTitle">Project Title:</label>
            <div class="col-sm-9">
                <form:input class="form-control" type="text" path="proposalTitle" required="true"/>
            </div>
            <form:errors cssClass="form-error" path="proposalTitle"/>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label required-field">Project Director:</label>
            <div class="col-sm-9">
                <form:input class="form-control" type="text" path="projectDirector" required="true"/>
            </div>
            <form:errors cssClass="form-error" path="projectDirector"/>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label required-field" for="emailAddress">Email Address:</label>
            <div class="col-sm-9">
                <form:input class="form-control" type="email" path="proposalEmail" required="true"/>
            </div>
            <form:errors cssClass="form-error" path="projectDirector"/>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label" for="mailCode">Mail Code:</label>

            <div class="col-sm-9">
                <form:input class="form-control" type="text" path="proposalMailCode"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="extension">Extension:</label>

            <div class="col-sm-9">
                <form:input class="form-control" type="text" path="proposalExtension"/>
            </div>
        </div>

        <input type="hidden" name="nextPage" id="nextPage" value="0"/>

        <div class="button-row">
            <button type="button" class="btn my-btn pull-right" onclick='setNextPage("proposal/department", "/")'>Next
            </button>
            <button type="button" class="btn my-btn pull-center" onclick='setNextPage("proposal/detail", "/")'>Save
            </button>
        </div>
    </form:form>
</div>