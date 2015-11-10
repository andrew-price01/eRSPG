package eRSPG.Repository;

import java.util.List;

import eRSPG.model.FundCategory;

public interface FundCategoryDAO {

	List<FundCategory> findAllFundCategory();

	FundCategory findFundCategory(int fid);

	int addFundCategory(FundCategory f);

	boolean updateFundCategory(FundCategory fc);

	boolean deleteFundCategory(FundCategory fc);

}