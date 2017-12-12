package eRSPG.model;

public class BudgetAmount {
    private double totalFunds;
    private double remainingFunds;

    public double getTotalFunds() {
        return totalFunds;
    }

    public double getRemainingFunds() {
        return remainingFunds;
    }

    public void setRemainingFunds(double remainingFunds) {
        this.remainingFunds = remainingFunds;
    }

    public void setTotalFunds(double totalFunds) {
        this.totalFunds = totalFunds;
    }
}
