<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<div class="container">
  
    	<div class="breadcrumb flat">
			<a href="<s:url value='/proposal/department' />" class="active">Details </a>
			<a href="<s:url value='/proposal/awardType' />" >Award Type</a>
			<a href="<s:url value='/proposal/budget' />" >Budget</a>
			<a href="<s:url value='/proposal/body' />">Body</a>
			<a href="<s:url value='/proposal/bodyDetails' />">Body Details</a>
			<a href="<s:url value='/proposal/bodyQuestions' />">Questions</a>
			<a href="<s:url value='/proposal/upload' />">Upload</a>
		</div>
    
        <legend><h2 style="text-align:center;">Project Details</h2></legend>
        <form:form class="form-horizontal"  method="post"   modelAttribute="detailForm">
            <div class="form-group">
                <label class="col-sm-3 control-label required-field" for="proposalTitle">Project Title:</label>

                <div class="col-sm-9">
                    <form:input class="form-control"  type="text" path="proposalTitle" required="true" />
                </div>
                
            </div>
            <div class="form-group">
            	<form:errors  path="proposalTitle" />
            </div>
            
            <div class="form-group">
                <label class="col-sm-3 control-label required-field">Project Director:</label>

                <div class="col-sm-9">
                    <form:input class="form-control" type="text" path="projectDirector" required="true"/>
                </div>
            </div>
            <form:errors path="projectDirector" />
            <div class="form-group">
                <label class="col-sm-3 control-label required-field" for="emailAddress">Email Address:</label>

                <div class="col-sm-9">
                    <form:input class="form-control" type="email" path="proposalEmail" required="true"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="mailCode">Mail Code:</label>

                <div class="col-sm-9">
                    <form:input class="form-control" type="text" path="proposalMailCode" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="extension">Extension:</label>

                <div class="col-sm-9">
                    <form:input class="form-control" type="text" path="proposalExtension" />
                </div>
            </div>
            <!--  div class="form-group">
                <label class="col-sm-3 control-label" for="otherParticipants">Other Participants:</label>

                <div class="col-sm-9">
                    <input class="form-control" type="text" name="otherParticipants" id="otherParticipants" />
                </div>
            </div>
            -->
            
            

            <div class="button-row">
                <button type="button" class="btn my-btn pull-right">Next</button>
                <button type="button" class="btn my-btn pull-center">Save</button>
                <button type="button" class="btn my-btn pull-left" onclick='window.location.href="department"'>Previous</button>
            </div>
        </form:form>
</div>