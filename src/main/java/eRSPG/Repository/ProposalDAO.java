package eRSPG.Repository;

import java.util.List;

import eRSPG.model.Proposal;

public interface ProposalDAO {

	List<Proposal> findAllProposals();

	Proposal findProposal(int pid);

	void addNewOrUpdateProposal(Proposal p);

	void deleteProposal(Proposal p);

	List<Proposal> findProposalByUserId(String userId);

}