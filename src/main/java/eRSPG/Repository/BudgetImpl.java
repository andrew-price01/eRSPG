package eRSPG.Repository;

import eRSPG.model.Budget;
import eRSPG.model.BudgetAmount;
import eRSPG.model.form.BudgetDetails;
import eRSPG.model.form.ManageBudgetForm;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.ArrayList;


public class BudgetImpl implements BudgetDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public BudgetImpl(){

    }

    public BudgetImpl(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Transactional
    public BudgetAmount getBudgetForYear(int budgetYear){

        final String sql = "\n" +
                "select b.totalBudget as totalFunds,\n" +
                "           sum(f.fundAmount) as remainingFunds\n" +
                "                from fund f join proposal p \n" +
                "\t\t\t\t\ton f.proposalID = p.proposalID \n" +
                "                join proposalstatus ps \n" +
                "\t\t\t\t\ton ps.proposalStatusID = p.proposalStatusID\n" +
                "\t\t\t\tjoin FundCategory fc\n" +
                "\t\t\t\t\ton f.fundCategoryID = fc.fundCategoryID\n" +
                "\t\t\t\tjoin User u\n" +
                "\t\t\t\t\ton p.userID = u.userID\n" +
                "\t\t\t\tjoin Department d \n" +
                "\t\t\t\t\ton d.departmentID = p.departmentID,\n" +
                "\t\t\t\tBudget b\n" +
                "group by p.proposalTitle, p.projectDirector, d.departmentName, \n" +
                "\t\t\t\tu.userFirstName, u.userLastName, fc.fundCategoryName, b.totalBudget";


        BudgetAmount budgetAmount = (BudgetAmount) sessionFactory.getCurrentSession().createSQLQuery(sql)
                .setResultTransformer(Transformers.aliasToBean(BudgetAmount.class)).list().get(0);

        return budgetAmount;
    }

    @Transactional
    public void updateBudget(Budget budget){
        sessionFactory.getCurrentSession().update(budget);
    }

    @Transactional
    public ArrayList<BudgetDetails> getBudgetDetails() {
        final String sql = "select concat(u.userFirstName, ' ', u.userLastName) as  submittedBy, \n" +
                "\t\t   p.proposalTitle as projectTitle, \n" +
                "           p.projectDirector, \n" +
                "           d.departmentName as department, \n" +
                "           fc.fundCategoryName, \n" +
                "           sum(f.fundAmount) as fundAmount\n" +
                "                from fund f join proposal p \n" +
                "\t\t\t\t\ton f.proposalID = p.proposalID \n" +
                "                join proposalstatus ps \n" +
                "\t\t\t\t\ton ps.proposalStatusID = p.proposalStatusID\n" +
                "\t\t\t\tjoin FundCategory fc\n" +
                "\t\t\t\t\ton f.fundCategoryID = fc.fundCategoryID\n" +
                "\t\t\t\tjoin User u\n" +
                "\t\t\t\t\ton p.userID = u.userID\n" +
                "\t\t\t\tjoin Department d \n" +
                "\t\t\t\t\ton d.departmentID = p.departmentID\n" +
                "group by p.proposalTitle, p.projectDirector, d.departmentName, \n" +
                "\t\t\t\tu.userFirstName, u.userLastName, fc.fundCategoryName";


        ArrayList<BudgetDetails> budgetDetailsList = (ArrayList<BudgetDetails>) sessionFactory.getCurrentSession().createSQLQuery(sql)
                .setResultTransformer(Transformers.aliasToBean(BudgetDetails.class)).list();

        return budgetDetailsList;
    }
}
