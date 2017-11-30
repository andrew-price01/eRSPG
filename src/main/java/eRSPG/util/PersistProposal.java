package eRSPG.util;

import com.fasterxml.jackson.databind.ser.Serializers;
import eRSPG.model.Proposal;
import eRSPG.model.User;
import eRSPG.model.form.BaseForm;
import org.joda.time.DateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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


    public static Proposal getDummyProposal(Integer userId)
    {
        LocalDateTime time = LocalDateTime.now();
        Proposal proposal = new Proposal();
        proposal.setProposalStatus(1);
        proposal.setUserId(userId);
        proposal.setProjectDirector("");
        proposal.setProposalMailCode("");
        proposal.setProposalExtension("");
        proposal.setProposalEmail("");
        proposal.setProposalReqStdAsst(false);
        proposal.setProposalTitle("");
        proposal.setSemesterId(1);
        proposal.setProjectTypeId(1);
        proposal.setDepartmentId(1);
        proposal.setProposalYear(LocalDate.now().getYear());
        proposal.setSubmissionDate(time);
        proposal.setUpdatedDate(time);
        return proposal;
    }
}
