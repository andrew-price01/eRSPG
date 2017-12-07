package eRSPG.Repository;

import eRSPG.model.Budget;
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
    public Budget getBudgetForYear(int budgetYear){
        Budget budget = sessionFactory.getCurrentSession().get(Budget.class, budgetYear);

        return budget;
    }

    @Transactional
    public void updateBudget(Budget budget){
        sessionFactory.getCurrentSession().update(budget);
    }

    @Transactional
    public ArrayList<BudgetDetails> getBudgetDetails() {
        final String sql = "select p.proposalID, p.proposalTitle, fc.fundCategoryName, sum(f.fundAmount) as fundAmount\n" +
                "                from fund f join proposal p \n" +
                "\t\t\t\t\ton f.proposalID = p.proposalID \n" +
                "                join proposalstatus ps \n" +
                "\t\t\t\t\ton ps.proposalStatusID = p.proposalStatusID\n" +
                "\t\t\t\tjoin FundCategory fc\n" +
                "\t\t\t\t\ton f.fundCategoryID = fc.fundCategoryID\n" +
                "group by p.proposalID, p.proposalTitle, fc.fundCategoryName\n" +
                "order by p.proposalID";


        ArrayList<BudgetDetails> budgetDetailsList = (ArrayList<BudgetDetails>) sessionFactory.getCurrentSession().createSQLQuery(sql)
                .setResultTransformer(Transformers.aliasToBean(BudgetDetails.class)).list();

        return budgetDetailsList;
    }
}
