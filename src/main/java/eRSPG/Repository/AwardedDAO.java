package eRSPG.Repository;

import java.util.List;

import eRSPG.model.Awarded;
import eRSPG.model.User;

public interface AwardedDAO {

	List<Awarded> findAllAwardeds();

	Awarded findAwarded(int aid);

	List<Awarded> findAwardedByUser(User user);

	void createAwarded(Awarded a);

	boolean updateAwarded(Awarded a);

	boolean deleteAwarded(Awarded a);

}