package eRSPG.model.form;

import java.math.BigDecimal;

public class ManageBudgetForm {
    private int totalBudget;
    private int remainingBudget;
    private int budgetYear;

    public void setTotalBudget(int totalBudget){
        this.totalBudget = totalBudget;
    }

    public int getTotalBudget() {
        return this.totalBudget;
    }

    public void setRemainingBudget(int remainingBudget) {
        this.remainingBudget = remainingBudget;
    }

    public int getRemainingBudget() {
        return this.remainingBudget;
    }

    public void setBudgetYear(int budgetYear) { this.budgetYear = budgetYear; }

    public int getBudgetYear() { return this.budgetYear; }


}
