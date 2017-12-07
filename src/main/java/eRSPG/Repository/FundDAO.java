package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import eRSPG.model.Fund;

public interface FundDAO {

	List<Fund> findAllFund();

	Fund findFund(int fid);

	void addNewOrUpdateFund(Fund f);

	void deleteFund(Fund f);

	void addFundList(List<Fund> fundList);

    ArrayList<Fund> findFundsByProposalId(int proposalID);
}