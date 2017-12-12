package eRSPG.Repository;

import eRSPG.model.Budget;
import eRSPG.model.BudgetAmount;
import eRSPG.model.form.BudgetDetails;

import java.util.ArrayList;

public interface BudgetDAO {
    BudgetAmount getBudgetForYear(int budgetYear);

    void updateBudget(Budget budget);

    ArrayList<BudgetDetails> getBudgetDetails();

}
