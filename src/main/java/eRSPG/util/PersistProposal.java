package eRSPG.util;

import com.fasterxml.jackson.databind.ser.Serializers;
import eRSPG.model.Proposal;
import eRSPG.model.User;
import eRSPG.model.form.BaseForm;
import org.joda.time.DateTime;
import java.time.LocalDateTime;

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
        proposal.setProjectDirector("megaDum");
        proposal.setProposalMailCode("4888");
        proposal.setProposalExtension("ext");
        proposal.setProposalEmail("Dum@mail.com");
        proposal.setProposalReqStdAsst(false);
        proposal.setProposalTitle("dummy");
        proposal.setSemesterId(1);
        proposal.setProjectTypeId(1);
        proposal.setDepartmentId(1);
        proposal.setProposalYear(2020);
        proposal.setSubmissionDate(time);
        proposal.setUpdatedDate(time);
        return proposal;
    }
}
