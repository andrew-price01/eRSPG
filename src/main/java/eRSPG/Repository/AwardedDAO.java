package eRSPG.Repository;

import java.util.List;

import eRSPG.model.Awarded;
import org.springframework.stereotype.Repository;

public interface AwardedDAO {

	List<Awarded> findAllAwardeds();

	Awarded findAwarded(int aid);

	int addNewOrUpdateAwarded(Awarded a);

	boolean deleteAwarded(Awarded a);

}