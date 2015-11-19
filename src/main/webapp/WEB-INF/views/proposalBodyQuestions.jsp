<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<div class="container">
    <h1>Body of Proposal</h1>

    <p>The abstract and Sections I-A through VI should not exceed 3 single-spaced pages. Supporting documents or
        materials should be included as addenda. PROPOSALS SHOULD BE WRITTEN CLEARLY AND SIMPLY.</p>

    <form:form method="post" modelAttribute="bodyForm" class="labels-no-bold tall-textarea">
        <p><strong>VI. ANSWER THE FOLLOWING QUESTIONS:</strong></p>
        <div class="form-group">
            <label for="q1" class="required-field">1. What RSPG funding have you applied for or have been awarded in the past 5 years. For awarded projects,
                please
                provide information regarding these projects including (1) the project title, (2) the status of the project,
                and (3) the outcome(s) of the project. Please indicate whether a final report has been submitted for each
                RSPG award. (It is recommended that a copy of the final report be included as an appendix.)</label>
            <form:textarea class="form-control" path="q1" cssErrorClass="missing-error form-control" />
        </div>
        <div class="form-group">
            <label for="q2" class="required-field">2. What other sources of funding have you sought for this project?</label>
            <form:textarea class="form-control" path="q2" cssErrorClass="missing-error form-control" />
        </div>
        <div class="form-group">
            <label for="q3" class="required-field">3. Have you checked with the Office of <a href="http://weber.edu/osp/" target="_blank">Sponsored Projects</a>
                to determine if this office is an appropriate place to seek additional funding? Please explain.</label>
            <form:textarea class="form-control" path="q3" cssErrorClass="missing-error form-control" />
        </div>
        <div class="form-group">
            <label for="q4" class="required-field">4. Is the type of project your department or college would normally fund? Please explain?</label>
            <form:textarea class="form-control" path="q4" cssErrorClass="missing-error form-control" />
        </div>
        <div class="form-group">
            <label for="q5" class="required-field">5. Would completion of this project create opportunities for external funding (for example, is this proposal
                a request for a pilot study or seed money that may lead to a larger project)?</label>
            <form:textarea class="form-control" path="q5" cssErrorClass="missing-error form-control" />
        </div>
        <div class="form-group">
            <label for="q6" class="required-field">6. If you are applying for release time or a stipend, please list what your course load would be if you
                received the reassigned time. You <em>MUST</em> include any overload courses which you plan on teaching.</label>
            <form:textarea class="form-control" path="q6" cssErrorClass="missing-error form-control" />
        </div>
        <div class="form-group">
            <label for="q7" class="required-field">7. For instructional improvement proposals, are course fees an appropriate place to seek additional funding?
                Please explain.</label>
            <form:textarea class="form-control" path="q7" cssErrorClass="missing-error form-control" />
        </div>
        <div>
            <a class="pull-left" href="<s:url value='/proposal/detail/bodyDetails' />">Previous</a>
            <button type="submit" class="button-block pull-right">Next</button>
        </div>
    </form:form>
</div>