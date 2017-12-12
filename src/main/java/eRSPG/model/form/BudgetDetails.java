package eRSPG.model.form;


public class BudgetDetails {
    private String submittedBy;
    private String projectTitle;
    private String projectDirector;
    private String department;
    private String fundCategoryName;
    private double fundAmount;

    public String getDepartment() {
        return department;
    }

    public String getProjectDirector() {
        return projectDirector;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setProjectDirector(String projectDirector) {
        this.projectDirector = projectDirector;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public void setFundCategoryName(String fundCategoryName) { this.fundCategoryName = fundCategoryName; }

    public String getFundCategoryName() { return fundCategoryName; }

    public void setFundAmount(double fundAmount) { this.fundAmount = fundAmount; }

    public double getFundAmount() { return fundAmount; }
}
