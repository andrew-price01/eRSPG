package eRSPG.util;

import com.fasterxml.jackson.databind.ser.Serializers;
import eRSPG.Repository.FundDAO;
import eRSPG.model.Fund;
import eRSPG.model.Proposal;
import eRSPG.model.User;
import eRSPG.model.form.BaseForm;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by iNaS2 on 11/20/2017.
 */
public class PersistProposal {




    public static User getDummyUser(){
        User user = new User();
        user.setFirstName("NoName");
        user.setLastName("NaName");
        user.setEmail("po@man.do");
        user.setUserId(1);
        return user;
    }


    public static Proposal getDummyProposal()
    {
        LocalDateTime time = LocalDateTime.now();
        Proposal proposal = new Proposal();
        proposal.setProposalStatus(1);
        proposal.setProjectDirector("");
        proposal.setProposalMailCode("");
        proposal.setProposalExtension("");
        proposal.setProposalEmail("");
        proposal.setProposalReqStdAsst(false);
        proposal.setProposalTitle("");
        proposal.setSemesterId(1);
        proposal.setProjectTypeId(1);
        proposal.setDepartmentId(1);
        proposal.setProposalYear(time.getYear());
        proposal.setSubmissionDate(time);
        proposal.setUpdatedDate(time);
        return proposal;
    }

    public static void SaveFunds(List<Fund> funds, FundDAO fundDao) {
        for (Fund fund:
                funds) {
            fundDao.addNewOrUpdateFund(fund);
        }
    }
}
