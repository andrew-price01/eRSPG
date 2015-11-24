package eRSPG.Repository;

import java.util.List;

import eRSPG.model.RequestAward;

public interface RequestAwardDAO {

	List<RequestAward> findAllRequestAward();

	RequestAward findRequestRewardById(int raid);

	void addNewOrUpdateRequestAward(RequestAward ra);

	void deleteRequestAward(RequestAward ra);

}