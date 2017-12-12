package eRSPG.model.form;

import java.math.BigDecimal;

public class ManageBudgetForm {
    private double totalBudget;
    private double remainingBudget;
    private double budgetYear;

    public void setTotalBudget(double totalBudget){
        this.totalBudget = totalBudget;
    }

    public double getTotalBudget() {
        return this.totalBudget;
    }

    public void setRemainingBudget(double remainingBudget) {
        this.remainingBudget = remainingBudget;
    }

    public double getRemainingBudget() {
        return this.remainingBudget;
    }

    public void setBudgetYear(int budgetYear) { this.budgetYear = budgetYear; }

    public double getBudgetYear() { return this.budgetYear; }


}
