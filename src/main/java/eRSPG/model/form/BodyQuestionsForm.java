package eRSPG.model.form;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Models the form inputs for the proposal body.
 */
public class BodyQuestionsForm {

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

    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public String getQ3() {
        return q3;
    }

    public void setQ3(String q3) {
        this.q3 = q3;
    }

    public String getQ4() {
        return q4;
    }

    public void setQ4(String q4) {
        this.q4 = q4;
    }

    public String getQ5() {
        return q5;
    }

    public void setQ5(String q5) {
        this.q5 = q5;
    }

    public String getQ6() {
        return q6;
    }

    public void setQ6(String q6) {
        this.q6 = q6;
    }

    public String getQ7() {
        return q7;
    }

    public void setQ7(String q7) {
        this.q7 = q7;
    }
}
