package eRSPG.Repository;

import java.util.List;

import eRSPG.model.Fund;

public interface FundDAO {

	List<Fund> findAllFund();

	Fund findFund(int fid);

	int addNewFund(Fund f);

	boolean updateFund(Fund f);

	boolean deleteFund(Fund f);

}