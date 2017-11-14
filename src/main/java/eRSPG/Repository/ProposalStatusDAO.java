package eRSPG.Repository;

import eRSPG.model.ProposalStatus;

import java.util.List;

public interface ProposalStatusDAO {

	List<ProposalStatus> findAllProposalStatuses();

	ProposalStatus findProposalStatus(Integer id);

	void addNewOrUpdateProposalStatus(ProposalStatus ps);

	void deleteProposalStatus(ProposalStatus ps);

	ProposalStatus findProposalStatusByName(String name);
}