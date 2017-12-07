package eRSPG.model.form;


public class BudgetDetails {
    private int proposalID;
    private String proposalTitle;
    private String description;
    private String fundCategoryName;
    private double fundAmount;

    public void setProposalID(int proposalID) { this.proposalID = proposalID; }

    public int getProposalID() { return proposalID; }

    public void setProposalTitle(String proposalTitle) { this.proposalTitle = proposalTitle; }

    public String getProposalTitle() { return proposalTitle; }

    public void setDescription(String description) { this.description = description; }

    public String getDescription() { return description; }

    public void setFundCategoryName(String fundCategoryName) { this.fundCategoryName = fundCategoryName; }

    public String getFundCategoryName() { return fundCategoryName; }

    public void setFundAmount(double fundAmount) { this.fundAmount = fundAmount; }

    public double getFundAmount() { return fundAmount; }
}
