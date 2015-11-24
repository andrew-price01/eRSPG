package eRSPG.Repository;

import java.util.List;

import eRSPG.model.FundCategory;

public interface FundCategoryDAO {

	List<FundCategory> findAllFundCategory();

	FundCategory findFundCategory(int fid);

	void addNewOrUpdateFundCategory(FundCategory f);

	void deleteFundCategory(FundCategory fc);

}