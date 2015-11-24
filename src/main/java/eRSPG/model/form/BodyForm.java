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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getHemmingwayExcellence() {
        return hemmingwayExcellence;
    }

    public void setHemmingwayExcellence(String hemmingwayExcellence) {
        this.hemmingwayExcellence = hemmingwayExcellence;
    }

    public String getHemmingwayCollaboration() {
        return hemmingwayCollaboration;
    }

    public void setHemmingwayCollaboration(String hemmingwayCollaboration) {
        this.hemmingwayCollaboration = hemmingwayCollaboration;
    }
}
