<jsp:useBean id="budgetForm" scope="session" type="eRSPG.model.form.BudgetForm"/>
<jsp:useBean id="uploadForm" scope="request" type="eRSPG.model.form.UploadForm"/>
<jsp:useBean id="bodyQuestionsForm" scope="session" type="eRSPG.model.form.BodyQuestionsForm"/>
<jsp:useBean id="bodyDetailsForm" scope="session" type="eRSPG.model.form.BodyDetailsForm"/>
<jsp:useBean id="bodyForm" scope="session" type="eRSPG.model.form.BodyForm"/>
<jsp:useBean id="awardTypeForm" scope="session" type="eRSPG.model.form.AwardTypeForm"/>
<jsp:useBean id="departmentForm" scope="session" type="eRSPG.model.form.DepartmentForm"/>
<jsp:useBean id="detailForm" scope="session" type="eRSPG.model.form.DetailForm"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/proposalReview.css"/>"/>
</head>
<body>
<div class="container">
    <div align="center">
            <legend>
            <h2 style="text-align: center;">Review Proposal</h2>
        </legend>
        <div>
            <p>Please review your proposal before submitting it.</p>
        </div>
        <div class="card">
            <div class="card-title">
                <h3>Details</h3>
            </div>
            <div class="card-text">
                <p>Title: ${detailForm.proposalTitle}</p>
                <p>Director: ${detailForm.projectDirector}</p>
                <p>Proposal Email: ${detailForm.proposalEmail}</p>
                <p>Mail Code: ${detailForm.proposalMailCode}</p>
                <p>Extension: ${detailForm.proposalExtension}</p>
            </div>
        </div>
        <div class="card">
            <div class="card-title">
                <h3>Department</h3>
            </div>
            <div class="card-text">
                <p>Department: ${departmentName}</p>
                <p>Semester: ${semesterName}</p>
                <p>Year: ${departmentForm.year}</p>
            </div>
        </div>
        <div class="card">
            <div class="card-title">
                <h3>Award Type</h3>
            </div>
            <div class="card-text">
                <p>Award Types: ${String.join(", ", awardTypeList)}</p>
                <p>Project Type: ${projectTypeName}</p>
            </div>
        </div>
        <div class="card">
            <div class="card-title">
                <h3>Budget</h3>
            </div>
            <div class="card-text">
                <p>Require student assistance: ${budgetForm.studentAssistants ? "Yes" : "No"}</p>
                <div>
                    <h4>Personnel Resources</h4>
                    <p>Total Committed: $<span>${
                            String.format("%,.2f",budgetForm.source1_a_1 + budgetForm.source2_a_1 + budgetForm.source3_a_1 +
                                    budgetForm.source1_b_1 + budgetForm.source2_b_1 + budgetForm.source3_b_1 +
                                    budgetForm.source1_c_1 + budgetForm.source2_c_1 + budgetForm.source3_c_1)}</span></p>
                    <p>Total Requested: $<span>${String.format("%,.2f",budgetForm.requested_a_1 + budgetForm.requested_b_1+ budgetForm.requested_c_1)}</span></p>
                </div>
                <div>
                    <h4>Benefits for Personnel Resources</h4>
                    <p>Total Committed: $<span>${
                        String.format("%,.2f",budgetForm.source1_a_ben + budgetForm.source2_a_ben + budgetForm.source3_a_1 +
                        budgetForm.source1_b_ben + budgetForm.source2_b_ben + budgetForm.source3_b_ben +
                        budgetForm.source1_c_ben + budgetForm.source2_c_ben + budgetForm.source3_c_ben)}</span></p>
                    <p>Total Requested: $<span>${String.format("%,.2f",budgetForm.requested_a_ben + budgetForm.requested_b_ben + budgetForm.requested_c_ben)}</span></p>
                </div>
                <div>
                    <h4>Equipment & Materials</h4>
                    <p>Total Committed: $<span>${
                            String.format("%,.2f",budgetForm.source1_a_2 + budgetForm.source2_a_2 + budgetForm.source3_a_2 +
                                    budgetForm.source1_b_2 + budgetForm.source2_b_2 + budgetForm.source3_b_2 +
                                    budgetForm.source1_c_2 + budgetForm.source2_c_2 + budgetForm.source3_c_2)}</span></p>
                    <p>Total Requested: $<span>${String.format("%,.2f",budgetForm.requested_a_2 + budgetForm.requested_b_2 + budgetForm.requested_c_2)}</span></p>
                </div>
                <div>
                    <h4>Travel</h4>
                    <p>Total Committed: $<span>${
                            String.format("%,.2f",budgetForm.source1_a_3 + budgetForm.source2_a_3 + budgetForm.source3_a_3 +
                                    budgetForm.source1_b_3 + budgetForm.source2_b_3 + budgetForm.source3_b_3 +
                                    budgetForm.source1_c_3 + budgetForm.source2_c_3 + budgetForm.source3_c_3)}</span></p>
                    <p>Total Requested: $<span>${String.format("%,.2f",budgetForm.requested_a_3 + budgetForm.requested_b_3 + budgetForm.requested_c_3)}</span></p>
                </div>
                <div>
                    <h4>Other</h4>
                    <p>Total Committed: $<span>${
                            String.format("%,.2f",budgetForm.source1_a_4 + budgetForm.source2_a_4 + budgetForm.source3_a_4 +
                                    budgetForm.source1_b_4 + budgetForm.source2_b_4 + budgetForm.source3_b_4 +
                                    budgetForm.source1_c_4 + budgetForm.source2_c_4 + budgetForm.source3_c_4)}</span></p>
                    <p>Total Requested: $<span>${String.format("%,.2f",budgetForm.requested_a_4 + budgetForm.requested_b_4 + budgetForm.requested_c_4)}</span></p>
                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-title">
                <h3>Body</h3>
            </div>
            <div class="card-text">
                <p>
                    <span class="question">Project Summary/Abstract</span>
                    <span class="answer">${bodyAnswers.get("1")}</span>
                </p>
                <p>
                    <span class="question">Background</span>
                    <span class="answer">${bodyAnswers.get("2")}</span>
                </p>
                <p>
                    <span class="question">Hemmingway Faculty Excellence</span>
                    <span class="answer">${bodyAnswers.get("3")}</span>
                </p>
                <p>
                    <span class="question">Hemmingway Collaborative Award</span>
                    <span class="answer">${bodyAnswers.get("4")}</span>
                </p>
            </div>
        </div>
        <div class="card">
            <div class="card-title">
                <h3>Body Details</h3>
            </div>
            <div class="card-text">
                <p>
                    <span class="question">Procedures and Methods</span>
                    <span class="answer">${bodyAnswers.get("5")}</span>
                </p>
                <p>
                    <span class="question">Timeline</span>
                    <span class="answer">${bodyAnswers.get("6")}</span>
                </p>
                <p>
                    <span class="question">Evalutation and Dissemination</span>
                    <span class="answer">${bodyAnswers.get("7")}</span>
                </p>
                <p>
                    <span class="question">Budget Narrative</span>
                    <span class="answer">${bodyAnswers.get("8")}</span>
                </p>
            </div>
            <div class="card">
                <div class="card-title">
                    <h3>Questions</h3>
                </div>
                <div class="card-text">
                    <div>
                        <p class="question">1. What RSPG funding have you applied for or have been awarded in the past 5
                            years. For awarded projects, please provide information regarding these projects including
                            (1) the project title, (2) the status of the project, and (3) the outcome(s) of the project.
                            Please indicate whether a final report has been submitted for each RSPG award.</p>
                        <p class="answer">${bodyAnswers.get("9")}</p>
                    </div>
                    <div>
                        <p class="question">2. What other sources of funding have you sought for this project?</p>
                        <p class="answer">${bodyAnswers.get("10")}</p>
                    </div>
                    <div>
                        <p class="question">3. Have you checked with the Office of Sponsored Projects to determine if
                            this office is an appropriate place to seek additional funding? Please explain.</p>
                        <p class="answer">${bodyAnswers.get("11")}</p>
                    </div>
                    <div>
                        <p class="question">4. Is this the type of project your department or college would normally
                            fund? Please explain?</p>
                        <p class="answer">${bodyAnswers.get("12")}</p>
                    </div>
                    <div>
                        <p class="question">5. Would completion of this project create opportunities for external
                            funding (for example, is this proposal a request for a pilot study or seed money that may
                            lead to a larger project)?</p>
                        <p class="answer">${bodyAnswers.get("13")}</p>
                    </div>
                    <div>
                        <p class="question">6. If you are applying for release time or a stipend, please list what your
                            course load would be if you received the reassigned time. You MUST include any overload
                            courses which you plan on teaching.</p>
                        <p class="answer">${bodyAnswers.get("14")}</p>
                    </div>
                    <div>
                        <p class="question">7. For instructional improvement proposals, are course fees an appropriate
                            place to seek additional funding? Please explain.</p>
                        <p class="answer">${bodyAnswers.get("15")}</p>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-title">
                    <h3>File Upload</h3>
                </div>
                <div class="card-text">
                    <p>File Name: ${uploadForm.name.isEmpty() ? uploadForm.name : "None"}</p>
                </div>
            </div>

            <div class="button-row">
                <button type="button" class="btn my-btn pull-left"
                        onclick='window.location.href="<s:url value="/eRSPG/proposal/upload"/>"'>Back
                </button>
                <%--<button type="button" class="btn my-btn pull-center" onclick='window.location.href="<s:url value="/proposal/review" />"'>Save</button>--%>
                <button type="button" class="btn my-btn pull-right"
                        onclick='window.location.href="<s:url value="/eRSPG/proposal/submit"/>"'>Submit
                </button>
            </div>
        </div>
    </div>
</div>
</body>
</html>