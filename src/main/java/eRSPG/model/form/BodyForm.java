package eRSPG.model.form;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Models the form inputs for the proposal body.
 */
public class BodyForm {

    @NotEmpty(message="Please enter proposal summary (abstract)")
    private String summary;
    @NotEmpty(message="Please enter proposal background and objectives")
    private String background;
    private String hemmingwayExcellence;
    private String hemmingwayCollaboration;
    @NotEmpty(message="Please enter proposal procedures and methods")
    private String procedures;
    @NotEmpty(message="Please enter proposal time-line")
    private String timeLine;
    @NotEmpty(message="Please enter proposal evaluation and dissemination")
    private String evaluation;
    @NotEmpty(message="Please enter proposal budget narrative")
    private String budgetNarrative;
    @NotEmpty(message="Please enter your answer to the question")
    private String q1;
    @NotEmpty(message="Please enter your answer to the question")
    private String q2;
    @NotEmpty(message="Please enter your answer to the question")
    private String q3;
    @NotEmpty(message="Please enter your answer to the question")
    private String q4;
    @NotEmpty(message="Please enter your answer to the question")
    private String q5;
    @NotEmpty(message="Please enter your answer to the question")
    private String q6;
    @NotEmpty(message="Please enter your answer to the question")
    private String q7;
}
