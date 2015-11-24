package eRSPG.model.form;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Models the form inputs for the proposal body.
 */
public class BodyDetailsForm {

    @NotEmpty(message="Please enter proposal procedures and methods")
    private String procedures;
    @NotEmpty(message="Please enter proposal time-line")
    private String timeLine;
    @NotEmpty(message="Please enter proposal evaluation and dissemination")
    private String evaluation;
    @NotEmpty(message="Please enter proposal budget narrative")
    private String budgetNarrative;

    public String getProcedures() {
        return procedures;
    }

    public void setProcedures(String procedures) {
        this.procedures = procedures;
    }

    public String getTimeLine() {
        return timeLine;
    }

    public void setTimeLine(String timeLine) {
        this.timeLine = timeLine;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public String getBudgetNarrative() {
        return budgetNarrative;
    }

    public void setBudgetNarrative(String budgetNarrative) {
        this.budgetNarrative = budgetNarrative;
    }
}
