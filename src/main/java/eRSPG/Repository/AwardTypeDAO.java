package eRSPG.Repository;

import java.util.List;

public interface AwardTypeDAO {

	List<AwardType> findAllAwardTyps();

	AwardTypeDAO findAwardType(int aid);

	int addAwardType(AwardType a);

	boolean updateAwardType(AwardType a);

	boolean deleteAwardType(AwardType a);

}