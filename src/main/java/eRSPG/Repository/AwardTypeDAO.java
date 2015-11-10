package eRSPG.Repository;

import java.util.List;

public interface AwardTypeDAO {

	List<AwardTypeImpl> findAllAwardTyps();

	AwardTypeDAO findAwardType(int aid);

	int addNewAwardType(AwardTypeImpl a);

	boolean updateAwardType(AwardTypeImpl a);

	boolean deleteAwardType(AwardTypeImpl a);

}