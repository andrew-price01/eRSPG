package eRSPG.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="Budget")
public class Budget implements Serializable {

    public Budget(){
    }


    @Column(name="budgetID")
    private int budgetID;

    @Id
    @Column(name="budgetYear")
    private int budgetYear;

    @Column(name="totalBudget")
    private int totalBudget;


    public void setBudgetID(int budgetID){
        this.budgetID = budgetID;
    }

    public int getBudgetID() {
        return this.budgetID;
    }

    public int getBudgetYear() {
        return this.budgetYear;
    }

    public void setBudgetYear(int budgetYear) {
        this.budgetYear = budgetYear;
    }

    public int getTotalBudget() {
        return this.totalBudget;
    }

    public void setTotalBudget(int totalBudget) {
        this.totalBudget = totalBudget;
    }
}
