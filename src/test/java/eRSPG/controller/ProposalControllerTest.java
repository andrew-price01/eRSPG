package eRSPG.controller;

import com.google.common.collect.ImmutableList;
import eRSPG.Repository.DepartmentDAO;
import eRSPG.Repository.ProposalDAO;
import eRSPG.model.Department;
import eRSPG.model.Proposal;
import eRSPG.model.ProposalDTO;
import org.apache.bcel.generic.NEW;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

public class ProposalControllerTest {
    private ProposalController proposalController = new ProposalController();
    private ProposalDAO proposalDAOMock;
    private DepartmentDAO departmentDAOMock;
    private static final Integer TEST_USER = 1;
    private static final Proposal TEST_PROPOSAL =
            new Proposal(
                    "title",1,2017,1, LocalDateTime.now(),
                    "director",1,"email","mailCode","extension",
                    Boolean.FALSE,Boolean.TRUE,LocalDateTime.now(),
                    null,TEST_USER);
    private static final Department TEST_DEPARTMENT = new Department(1,"department");

    @Test
    public void list_proposal_user_empty() {
        proposalDAOMock = mock(ProposalDAO.class);
        departmentDAOMock = mock(DepartmentDAO.class);
        proposalController.departmentDAO = departmentDAOMock;
        proposalController.proposalDao = proposalDAOMock;
        when(departmentDAOMock.findDepartment(anyInt())).thenReturn(TEST_DEPARTMENT);
        when(proposalDAOMock.findAllProposals()).thenReturn(ImmutableList.of(new Proposal(),new Proposal()));
        List<ProposalDTO> proposals = proposalController.proposalListByUserId("");
        assert proposals.size() == 2;
    }

    @Test
    public void list_proposal_user_null() {
        proposalDAOMock = mock(ProposalDAO.class);
        departmentDAOMock = mock(DepartmentDAO.class);
        proposalController.departmentDAO = departmentDAOMock;
        proposalController.proposalDao = proposalDAOMock;
        when(departmentDAOMock.findDepartment(anyInt())).thenReturn(TEST_DEPARTMENT);
        when(proposalDAOMock.findAllProposals()).thenReturn(ImmutableList.of(new Proposal(),new Proposal()));
        List<ProposalDTO> proposals = proposalController.proposalListByUserId(null);
        assert proposals.size() == 2;
    }

    @Test
    public void list_proposal_user() {
        proposalDAOMock = mock(ProposalDAO.class);
        departmentDAOMock = mock(DepartmentDAO.class);
        proposalController.departmentDAO = departmentDAOMock;
        proposalController.proposalDao = proposalDAOMock;
        when(departmentDAOMock.findDepartment(anyInt())).thenReturn(TEST_DEPARTMENT);
        when(proposalDAOMock.findProposalByUserId(TEST_USER))
                .thenReturn(ImmutableList.of(TEST_PROPOSAL,TEST_PROPOSAL,TEST_PROPOSAL));
        List<ProposalDTO> proposals = proposalController.proposalListByUserId(TEST_USER.toString());
        assert proposals.size() == 3;
    }
}