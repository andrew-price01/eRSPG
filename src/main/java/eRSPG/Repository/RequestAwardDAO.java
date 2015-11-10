package eRSPG.Repository;

import java.util.List;

import eRSPG.model.RequestAward;

public interface RequestAwardDAO {

	List<RequestAward> findAllRequestAward();

	RequestAward findRequestRewardById(int raid);

	RequestAward findRequestRewardByProposalId(int pid);

	int addRequestAward(RequestAward ra);

	boolean updateRequestAward(RequestAward ra);

	boolean deleteRequestAward(RequestAward ra);

}