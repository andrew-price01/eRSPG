<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<div class="container">
	<div class="breadcrumb flat">
			<a href="<s:url value='/proposal/department' />">Details </a>
			<a href="<s:url value='/proposal/detail/awardType' />">Award Type</a>
			<a href="<s:url value='/proposal/budget' />" >Budget</a>
			<a href="<s:url value='/proposal/body' />" >Body</a>
			<a href="<s:url value='/proposal/bodyDetails' />" class="active">Body Details</a>
			<a href="<s:url value='/proposal/bodyQuestions' />">Questions</a>
			<a href="<s:url value='/proposal/upload' />">Upload</a>
	</div>
    <legend><h2 style="text-align:center;">Body of Proposal</h2></legend>

    <p>The abstract and Sections I-A through VI should not exceed 3 single-spaced pages. Supporting documents or
        materials should be included as addenda. PROPOSALS SHOULD BE WRITTEN CLEARLY AND SIMPLY.</p>

    <form:form method="post" modelAttribute="bodyDetailsForm" class="labels-no-bold tall-textarea">
        <div class="form-group">
            <label for="procedures" class="required-field"><strong>II. PROCEDURES AND METHODS.</strong> (Indicate how the goals and objectives will be met. Include a
                discussion of the steps involved in the design, development and implementation of the project.)</label>
            <form:textarea  class="form-control" path="procedures" cssErrorClass="missing-error form-control" />
        </div>
        <div class="form-group">
            <label for="timeLine" class="required-field"><strong>III. TIME-LINE.</strong> (Provide a time frame for the completion of the project.)</label>
            <form:textarea  class="form-control" path="timeLine" cssErrorClass="missing-error form-control" />
        </div>
        <div class="form-group">
            <label for="evaluation" class="required-field"><strong>IV. EVALUATION AND DISSEMINATION.</strong> (Include a plan for evaluating or documenting outcomes as
                well as a plan for the dissemination of project results.)</label>
            <form:textarea  class="form-control" path="evaluation" cssErrorClass="missing-error form-control" />
        </div>
        <div class="form-group">
            <label for="budgetNarrative" class="required-field"><strong>V. PROVIDE A BUDGET NARRATIVE</strong> that clearly explains any budget items that are not
                self-explanatory, including justification for the number of hours requested (if any) as reassigned time or
                stipend.</label>
            <form:textarea  class="form-control" path="budgetNarrative" cssErrorClass="missing-error form-control" />
        </div>
        <div>
            <button type="button" class="btn my-btn pull-left" onclick='window.location.href="<s:url value="/proposal/body" />"'>Previous</button>
            <button type="button" class="btn my-btn pull-right" onclick='window.location.href="<s:url value="/proposal/bodyQuestions" />"'>Next</button>
        </div>
    </form:form>
</div>