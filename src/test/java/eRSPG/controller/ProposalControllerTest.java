package eRSPG.controller;

import com.google.common.collect.ImmutableList;
import eRSPG.Repository.ProposalDAO;
import eRSPG.model.Proposal;
import org.testng.annotations.Test;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

public class ProposalControllerTest {
    private ProposalController proposalController = new ProposalController();
    private ProposalDAO proposalDAOMock;

//    @Test
//    public void list_proposal_user_empty() {
//        proposalDAOMock = mock(ProposalDAO.class);
//        proposalController.proposalDao = proposalDAOMock;
//        when(proposalDAOMock.findAllProposals()).thenReturn(ImmutableList.of(new Proposal(),new Proposal()));
//        List<Proposal> proposals = proposalController.proposalList("");
//        assert proposals.size() == 2;
//    }
//
//    @Test
//    public void list_proposal_user_null() {
//        proposalDAOMock = mock(ProposalDAO.class);
//        proposalController.proposalDao = proposalDAOMock;
//        when(proposalDAOMock.findAllProposals()).thenReturn(ImmutableList.of(new Proposal(),new Proposal()));
//        List<Proposal> proposals = proposalController.proposalList(null);
//        assert proposals.size() == 2;
//    }
//
//    @Test
//    public void list_proposal_user() {
//        proposalDAOMock = mock(ProposalDAO.class);
//        proposalController.proposalDao = proposalDAOMock;
//        final String TEST_USER = "testUser";
//        when(proposalDAOMock.findProposalByUserId(TEST_USER)).thenReturn(ImmutableList.of(new Proposal(), new Proposal(), new Proposal()));
//        List<Proposal> proposals = proposalController.proposalList(TEST_USER);
//        assert proposals.size() == 3;
//    }
}