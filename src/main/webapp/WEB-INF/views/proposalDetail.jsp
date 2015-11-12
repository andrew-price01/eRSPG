<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
    <div class="row">
        <legend>Project Details</legend>
        <form:form class="form-horizontal"  method="post"   modelAttribute="detailForm">
            <div class="form-group">
                <label class="col-sm-3 control-label" for="proposalTitle">Project Title:</label>

                <div class="col-sm-9">
                    <form:input class="form-control"  type="text" path="proposalTitle" required="true" />
                </div>
                
            </div>
            <div class="form-group">
            	<form:errors  path="proposalTitle" />
            </div>
            
            <div class="form-group">
                <label class="col-sm-3 control-label">Project Director:</label>

                <div class="col-sm-9">
                    <form:input class="form-control" type="text" path="projectDirector" required="true"/>
                </div>
            </div>
            <form:errors path="projectDirector" />
            <div class="form-group">
                <label class="col-sm-3 control-label" for="emailAddress">Email Address:</label>

                <div class="col-sm-9">
                    <form:input class="form-control" type="email" path="proposalEmail" required="true"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="mailCode">Mail Code:</label>

                <div class="col-sm-9">
                    <form:input class="form-control" type="text" path="proposalMailCode" required="true"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="extension">Extension:</label>

                <div class="col-sm-9">
                    <form:input class="form-control" type="text" path="proposalExtension" required="true"/>
                </div>
            </div>
            <!--  div class="form-group">
                <label class="col-sm-3 control-label" for="otherParticipants">Other Participants:</label>

                <div class="col-sm-9">
                    <input class="form-control" type="text" name="otherParticipants" id="otherParticipants" />
                </div>
            </div>
            -->
            
            

            <div>
                <button type="submit" class="button-block pull-right">Next</button>
            </div>
        </form:form>
    </div>
</div>