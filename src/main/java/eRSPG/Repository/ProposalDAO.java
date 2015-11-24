package eRSPG.Repository;

import java.util.List;

import eRSPG.model.Proposal;
import eRSPG.model.User;

public interface ProposalDAO {

	List<Proposal> findAllProposals();

	Proposal findProposal(int pid);

	List<Proposal> findProposalsByUser(User user);

	void addNewOrUpdateProposal(Proposal p);

	void deleteProposal(Proposal p);

}