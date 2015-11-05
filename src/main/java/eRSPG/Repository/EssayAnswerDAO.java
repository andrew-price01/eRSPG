package eRSPG.Repository;

import java.util.List;

import eRSPG.model.EssayAnswer;

public interface EssayAnswerDAO {

	List<EssayAnswer> findAllEssayAnswer();

	EssayAnswer findEssayAnswer(int aid);

	int addEssayAnswer(EssayAnswer a);

	boolean updateEssayAnswer(EssayAnswer a);

	boolean deleteEssayAnswer(EssayAnswer a);

}