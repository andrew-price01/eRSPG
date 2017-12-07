package eRSPG.Repository;

import java.util.List;

import eRSPG.model.AwardType;

public interface AwardTypeDAO {

	List<AwardType> findAllAwardTyps();

	AwardType findAwardType(int aid);

	int addNewAwardType(AwardType a);

	boolean deleteAwardType(AwardType a);

	List<AwardType> findAwardTypesById(List<Integer> awardTypeIds);

}