<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<div class="container">
    <h1>Body of Proposal</h1>

    <p>The abstract and Sections I-A through VI should not exceed 3 single-spaced pages. Supporting documents or
        materials should be included as addenda. PROPOSALS SHOULD BE WRITTEN CLEARLY AND SIMPLY.</p>

    <form:form method="post" modelAttribute="bodyForm" class="labels-no-bold tall-textarea">
        <div class="form-group">
            <label for="summary" class="required-field"><strong>PROJECT SUMMARY (ABSTRACT):</strong></label>
            <form:textarea class="form-control" path="summary" cssErrorClass="missing-error form-control" />
        </div>
        <div class="form-group">
            <label for="background" class="required-field"><strong>I-A. BACKGROUND AND OBJECTIVES OF RESEARCH/PROJECT.</strong> (Describe the nature and significance of
                the problem and provide a brief review of the relevant literature and expected outcomes. Include a
                bibliography as an appendix, if appropriate.)</label>
            <form:textarea class="form-control" path="background" cssErrorClass="missing-error form-control" />
        </div>
        <div class="form-group">
            <label for="hemmingwayExcellence">I-B. If applying for a <em>Hemingway award for Faculty Excellence</em>, please describe what the impact of
                your project will be on the larger community. In short, what makes this project qualify for a Hemingway
                Award?</label>
            <form:textarea class="form-control" path="hemmingwayExcellence" />
        </div>
        <div class="form-group">
            <label for="hemmingwayCollaboration">I-C. If applying for a <em>Hemingway Collaborative Award</em>, explain the collaborative nature of the
                project. What faculty and disciplines are involved?</label>
            <form:textarea class="form-control" path="hemmingwayCollaboration" />
        </div>
        <div>
            <div>
                <a class="pull-left" href="<s:url value='/proposal/budget' />">Previous</a>
                <button type="submit" class="button-block pull-right">Next</button>
            </div>
        </div>
    </form:form>
</div>