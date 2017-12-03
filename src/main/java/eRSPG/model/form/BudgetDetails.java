package eRSPG.model.form;


public class BudgetDetails {
    private double fundAmount;
    private String description;
    private String comments;
    private String proposalDescription;

    public String getDescription() {
        return description;
    }

    public String getProposalDescription() {
        return proposalDescription;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public double getFundAmount() {
        return fundAmount;
    }

    public void setFundAmount(double fundAmount) {
        this.fundAmount = fundAmount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProposalDescription(String proposalDescription) {
        this.proposalDescription = proposalDescription;
    }
}
