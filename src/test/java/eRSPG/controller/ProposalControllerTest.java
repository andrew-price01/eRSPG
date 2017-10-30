package eRSPG.controller;

import com.google.common.collect.ImmutableList;
import eRSPG.Repository.DepartmentDAO;
import eRSPG.Repository.ProposalDAO;
import eRSPG.Repository.UserDAO;
import eRSPG.model.Department;
import eRSPG.model.Proposal;
import eRSPG.model.ProposalDTO;
import eRSPG.model.User;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProposalControllerTest {
    private ProposalController proposalController = new ProposalController();
    private ProposalDAO proposalDAOMock;
    private DepartmentDAO departmentDAOMock;
    private UserDAO userDAOMock;
    private static final Integer TEST_USER_ID = 1;
    private static final User TEST_USER = new User(TEST_USER_ID, "email","testFirst","testLast");
    private static final Proposal TEST_PROPOSAL =
            new Proposal(
                    "title",1,2017,1, LocalDateTime.now(),
                    "director",1,"email","mailCode","extension",
                    Boolean.FALSE,Boolean.TRUE,LocalDateTime.now(),
                    null,TEST_USER_ID);
    private static final Department TEST_DEPARTMENT = new Department(1,"department");

    @Test
    public void list_proposal_user_empty() {
        proposalDAOMock = mock(ProposalDAO.class);
        departmentDAOMock = mock(DepartmentDAO.class);
        userDAOMock = mock(UserDAO.class);
        proposalController.departmentDAO = departmentDAOMock;
        proposalController.proposalDao = proposalDAOMock;
        proposalController.userDAO = userDAOMock;
        when(userDAOMock.findUserById(anyInt())).thenReturn(TEST_USER);
        when(departmentDAOMock.findDepartment(anyInt())).thenReturn(TEST_DEPARTMENT);
        when(proposalDAOMock.findAllProposals()).thenReturn(ImmutableList.of(TEST_PROPOSAL, TEST_PROPOSAL));
        List<ProposalDTO> proposals = proposalController.proposalListByUserId("");
        assert proposals.size() == 2;
    }

    @Test
    public void list_proposal_user_null() {
        proposalDAOMock = mock(ProposalDAO.class);
        departmentDAOMock = mock(DepartmentDAO.class);
        userDAOMock = mock(UserDAO.class);
        proposalController.userDAO = userDAOMock;
        proposalController.departmentDAO = departmentDAOMock;
        proposalController.proposalDao = proposalDAOMock;
        when(userDAOMock.findUserById(anyInt())).thenReturn(TEST_USER);
        when(departmentDAOMock.findDepartment(anyInt())).thenReturn(TEST_DEPARTMENT);
        when(proposalDAOMock.findAllProposals()).thenReturn(ImmutableList.of(TEST_PROPOSAL, TEST_PROPOSAL));
        List<ProposalDTO> proposals = proposalController.proposalListByUserId(null);
        assert proposals.size() == 2;
    }

    @Test
    public void list_proposal_user() {
        proposalDAOMock = mock(ProposalDAO.class);
        departmentDAOMock = mock(DepartmentDAO.class);
        proposalController.departmentDAO = departmentDAOMock;
        proposalController.proposalDao = proposalDAOMock;
        userDAOMock = mock(UserDAO.class);
        proposalController.userDAO = userDAOMock;
        when(userDAOMock.findUserById(anyInt())).thenReturn(TEST_USER);
        when(departmentDAOMock.findDepartment(anyInt())).thenReturn(TEST_DEPARTMENT);
        when(proposalDAOMock.findProposalByUserId(TEST_USER_ID))
                .thenReturn(ImmutableList.of(TEST_PROPOSAL,TEST_PROPOSAL,TEST_PROPOSAL));
        List<ProposalDTO> proposals = proposalController.proposalListByUserId(TEST_USER_ID.toString());
        assert proposals.size() == 3;
    }
}