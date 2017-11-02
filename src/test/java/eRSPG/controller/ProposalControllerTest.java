package eRSPG.controller;

import com.google.common.collect.ImmutableList;
import eRSPG.Repository.DepartmentDAO;
import eRSPG.Repository.ProposalDAO;
import eRSPG.Repository.ProposalStatusDAO;
import eRSPG.Repository.UserDAO;
import eRSPG.model.*;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProposalControllerTest {
    private ProposalController proposalController = new ProposalController();
    private ProposalDAO proposalDAOMock;
    private DepartmentDAO departmentDAOMock;
    private UserDAO userDAOMock;
    private ProposalStatusDAO proposalStatusDAOMock;

    private static final Integer TEST_USER_ID = 1;
    private static final User TEST_USER = new User(TEST_USER_ID, "email","testFirst","testLast");
    private static final Proposal TEST_PROPOSAL =
            new Proposal(
                    "title",1,2017,1, LocalDateTime.now(),
                    "director",1,"email","mailCode","extension",
                    Boolean.FALSE,1,LocalDateTime.now(),
                    null,TEST_USER_ID);
    private static final Department TEST_DEPARTMENT = new Department(1,"department");
    private static final ProposalStatus TEST_PROPOSAL_STATUS = new ProposalStatus(2,"DRAFT");


    @Test
    public void list_proposal_user_empty() {
        proposalDAOMock = mock(ProposalDAO.class);
        departmentDAOMock = mock(DepartmentDAO.class);
        userDAOMock = mock(UserDAO.class);
        proposalStatusDAOMock = mock(ProposalStatusDAO.class);
        proposalController.proposalStatusDAO = proposalStatusDAOMock;
        proposalController.departmentDAO = departmentDAOMock;
        proposalController.proposalDao = proposalDAOMock;
        proposalController.userDAO = userDAOMock;

        when(proposalStatusDAOMock.findProposalStatus(anyInt())).thenReturn(TEST_PROPOSAL_STATUS);
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
        proposalStatusDAOMock = mock(ProposalStatusDAO.class);
        proposalController.userDAO = userDAOMock;
        proposalController.departmentDAO = departmentDAOMock;
        proposalController.proposalDao = proposalDAOMock;
        proposalController.proposalStatusDAO = proposalStatusDAOMock;
        when(userDAOMock.findUserById(anyInt())).thenReturn(TEST_USER);
        when(proposalStatusDAOMock.findProposalStatus(any())).thenReturn(TEST_PROPOSAL_STATUS);
        when(departmentDAOMock.findDepartment(anyInt())).thenReturn(TEST_DEPARTMENT);
        when(proposalDAOMock.findAllProposals()).thenReturn(ImmutableList.of(TEST_PROPOSAL, TEST_PROPOSAL));
        List<ProposalDTO> proposals = proposalController.proposalListByUserId(null);
        assert proposals.size() == 2;
    }

    @Test
    public void list_proposal_user() {
        proposalDAOMock = mock(ProposalDAO.class);
        departmentDAOMock = mock(DepartmentDAO.class);
        proposalStatusDAOMock = mock(ProposalStatusDAO.class);
        proposalController.departmentDAO = departmentDAOMock;
        proposalController.proposalDao = proposalDAOMock;
        proposalController.proposalStatusDAO = proposalStatusDAOMock;
        userDAOMock = mock(UserDAO.class);
        proposalController.userDAO = userDAOMock;
        when(proposalStatusDAOMock.findProposalStatus(anyInt())).thenReturn(TEST_PROPOSAL_STATUS);
        when(userDAOMock.findUserById(anyInt())).thenReturn(TEST_USER);
        when(departmentDAOMock.findDepartment(anyInt())).thenReturn(TEST_DEPARTMENT);
        when(proposalDAOMock.findProposalByUserId(TEST_USER_ID))
                .thenReturn(ImmutableList.of(TEST_PROPOSAL,TEST_PROPOSAL,TEST_PROPOSAL));
        List<ProposalDTO> proposals = proposalController.proposalListByUserId(TEST_USER_ID.toString());
        assert proposals.size() == 3;
    }

    @Test
    public void list_proposal_status_empty() {
        proposalStatusDAOMock = mock(ProposalStatusDAO.class);
        proposalController.proposalStatusDAO = proposalStatusDAOMock;
        when(proposalStatusDAOMock.findAllProposalStatuses()).thenReturn(ImmutableList.of(TEST_PROPOSAL_STATUS,TEST_PROPOSAL_STATUS));
        List<ProposalStatus> statuses = proposalController.proposalStatusList("");
        assert statuses.size() == 2;
    }

    @Test
    public void list_proposal_status_null() {
        proposalStatusDAOMock = mock(ProposalStatusDAO.class);
        proposalController.proposalStatusDAO = proposalStatusDAOMock;
        when(proposalStatusDAOMock.findAllProposalStatuses()).thenReturn(ImmutableList.of(TEST_PROPOSAL_STATUS,TEST_PROPOSAL_STATUS));
        List<ProposalStatus> statuses = proposalController.proposalStatusList(null);
        assert statuses.size() == 2;
    }

    @Test
    public void list_proposal_status_name() {
        proposalStatusDAOMock = mock(ProposalStatusDAO.class);
        proposalController.proposalStatusDAO = proposalStatusDAOMock;
        when(proposalStatusDAOMock.findProposalStatusByName(anyString())).thenReturn(TEST_PROPOSAL_STATUS);
        List<ProposalStatus> statuses = proposalController.proposalStatusList("Draft");
        assert statuses.size() == 1;
    }

    @Test
    public void update_proposal_status_id_null() {
        proposalStatusDAOMock = mock(ProposalStatusDAO.class);
        proposalDAOMock = mock(ProposalDAO.class);
        when(proposalStatusDAOMock.findProposalStatusByName(anyString())).thenReturn(TEST_PROPOSAL_STATUS);
        proposalController.proposalStatusDAO = proposalStatusDAOMock;
        Proposal proposal = proposalController.updateProposalStatus(null,"DRAFT");
        assert proposal == null;
    }

    @Test
    public void update_proposal_status_name_null() {
        proposalStatusDAOMock = mock(ProposalStatusDAO.class);
        proposalDAOMock = mock(ProposalDAO.class);
        when(proposalStatusDAOMock.findProposalStatusByName(anyString())).thenReturn(null);
        proposalController.proposalStatusDAO = proposalStatusDAOMock;
        Proposal proposal = proposalController.updateProposalStatus("1",null);
        assert proposal == null;
    }

    @Test
    public void update_proposal_status_id_null_name_null() {
        proposalStatusDAOMock = mock(ProposalStatusDAO.class);
        proposalDAOMock = mock(ProposalDAO.class);
        when(proposalStatusDAOMock.findProposalStatusByName(anyString())).thenReturn(null);
        proposalController.proposalStatusDAO = proposalStatusDAOMock;
        Proposal proposal = proposalController.updateProposalStatus(null,null);
        assert proposal == null;
    }

    @Test
    public void update_proposal_status_id_valid_name_valid() {
        proposalStatusDAOMock = mock(ProposalStatusDAO.class);
        proposalDAOMock = mock(ProposalDAO.class);
        when(proposalStatusDAOMock.findProposalStatusByName(anyString())).thenReturn(TEST_PROPOSAL_STATUS);
        when(proposalDAOMock.findProposal(anyInt())).thenReturn(TEST_PROPOSAL);
        proposalController.proposalStatusDAO = proposalStatusDAOMock;
        proposalController.proposalDao = proposalDAOMock;
        Proposal proposal = proposalController.updateProposalStatus("1","DRAFT");
        assert proposal.getProposalStatus() == 2;
    }
}