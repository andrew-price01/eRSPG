<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
    <h1>Body of Proposal</h1>

    <p>The abstract and Sections I-A through VI should not exceed 3 single-spaced pages. Supporting documents or
        materials should be included as addenda. PROPOSALS SHOULD BE WRITTEN CLEARLY AND SIMPLY.</p>

    <form:form method="post" modelAttribute="bodyForm" class="labels-no-bold tall-textarea">
        <div class="form-group">
            <label for="propSummary"><strong>PROJECT SUMMARY (ABSTRACT):</strong></label>
            <textarea id="propSummary" class="form-control"></textarea>
        </div>
        <div class="form-group">
            <label for="propBackground"><strong>I-A. BACKGROUND AND OBJECTIVES OF RESEARCH/PROJECT.</strong> (Describe the nature and significance of
                the problem and provide a brief review of the relevant literature and expected outcomes. Include a
                bibliography as an appendix, if appropriate.)</label>
            <textarea id="propBackground" class="form-control"></textarea>
        </div>
        <div class="form-group">
            <label for="propHemingwayExcellence">I-B. If applying for a <em>Hemingway award for Faculty Excellence</em>, please describe what the impact of
                your project will be on the larger community. In short, what makes this project qualify for a Hemingway
                Award?</label>
            <textarea id="propHemingwayExcellence" class="form-control"></textarea>
        </div>
        <div class="form-group">
            <label for="propHemmingwayCollaboration">I-C. If applying for a <em>Hemingway Collaborative Award</em>, explain the collaborative nature of the
                project. What faculty and disciplines are involved?</label>
            <textarea id="propHemmingwayCollaboration" class="form-control"></textarea>
        </div>
        <div class="form-group">
            <label for="propProcedures"><strong>II. PROCEDURES AND METHODS.</strong> (Indicate how the goals and objectives will be met. Include a
                discussion of the steps involved in the design, development and implementation of the project.)</label>
            <textarea id="propProcedures" class="form-control"></textarea>
        </div>
        <div class="form-group">
            <label for="propTimeLine"><strong>III. TIME-LINE.</strong> (Provide a time frame for the completion of the project.)</label>
            <textarea id="propTimeLine" class="form-control"></textarea>
        </div>
        <div class="form-group">
            <label for="propEvaluation"><strong>IV. EVALUATION AND DISSEMINATION.</strong> (Include a plan for evaluating or documenting outcomes as
                well as a plan for the dissemination of project results.)</label>
            <textarea id="propEvaluation" class="form-control"></textarea>
        </div>
        <div class="form-group">
            <label for="propBudgetNarrative"><strong>V. PROVIDE A BUDGET NARRATIVE</strong> that clearly explains any budget items that are not
                self-explanatory, including justification for the number of hours requested (if any) as reassigned time or
                stipend.</label>
            <textarea id="propBudgetNarrative" class="form-control"></textarea>
        </div>
        <p><strong>VI. ANSWER THE FOLLOWING QUESTIONS:</strong></p>
        <div class="form-group">
            <label for="propQ1">1. What RSPG funding have you applied for or have been awarded in the past 5 years. For awarded projects,
                please
                provide information regarding these projects including (1) the project title, (2) the status of the project,
                and (3) the outcome(s) of the project. Please indicate whether a final report has been submitted for each
                RSPG award. (It is recommended that a copy of the final report be included as an appendix.)</label>
            <textarea id="propQ1" class="form-control"></textarea>
        </div>
        <div class="form-group">
            <label for="propQ2">2. What other sources of funding have you sought for this project?</label>
            <textarea id="propQ2" class="form-control"></textarea>
        </div>
        <div class="form-group">
            <label for="propQ3">3. Have you checked with the Office of <a href="http://weber.edu/osp/" target="_blank">Sponsored Projects</a>
                to determine if this office is an appropriate place to seek additional funding? Please explain.</label>
            <textarea id="propQ3" class="form-control"></textarea>
        </div>
        <div class="form-group">
            <label for="propQ4">4. Is the type of project your department or college would normally fund? Please explain?</label>
            <textarea id="propQ4" class="form-control"></textarea>
        </div>
        <div class="form-group">
            <label for="propQ5">5. Would completion of this project create opportunities for external funding (for example, is this proposal
                a request for a pilot study or seed money that may lead to a larger project)?</label>
            <textarea id="propQ5" class="form-control"></textarea>
        </div>
        <div class="form-group">
            <label for="propQ6">6. If you are applying for release time or a stipend, please list what your course load would be if you
                received the reassigned time. You <em>MUST</em> include any overload courses which you plan on teaching.</label>
            <textarea id="propQ6" class="form-control"></textarea>
        </div>
        <div class="form-group">
            <label for="propQ7">7. For instructional improvement proposals, are course fees an appropriate place to seek additional funding?
                Please explain.</label>
            <textarea id="propQ7" class="form-control"></textarea>
        </div>
        <div>
            <button type="submit" class="button-block pull-right">Next</button>
        </div>
    </form>
</div>