package eRSPG.Repository;

import java.util.ArrayList;
import java.util.List;

import eRSPG.model.FundCategory;

public class FundCategoryImpl implements FundCategoryDAO {
	public List<FundCategory> findAllFundCategory(){
		//TODO: query and return a list of Proposal
		List<FundCategory> fcList = new ArrayList();
		return fcList;
	}
	
	public FundCategory findFundCategory(int fid){
		FundCategory fc = new FundCategory();
		//TODO: query for a proposal using the pid
		return fc;
	}
	
	public int addFundCategory(FundCategory f){
		//TODO: 
		return 0;
	}
	
	public boolean updateFundCategory(FundCategory fc){
		//TODO: update record query
		boolean success = false;
		return success;
	}
	
	public boolean deleteFundCategory(FundCategory fc){
		//TODO: delete record query
		boolean success = false;
		return success;
	}
}
