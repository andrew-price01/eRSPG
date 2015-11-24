package eRSPG.Repository;

import java.util.List;

import eRSPG.model.Fund;

public interface FundDAO {

	List<Fund> findAllFund();

	Fund findFund(int fid);

	void addNewOrUpdateFund(Fund f);

	void deleteFund(Fund f);

}