package eRSPG.Repository;

import java.util.List;

import eRSPG.model.EssayAnswer;
import eRSPG.model.EssayQuestion;

public interface EssayAnswerDAO {

	List<EssayAnswer> findAllEssayAnswer();

	EssayAnswer findEssayAnswer(int aid);
	
	EssayAnswer findEssayAnswerByQuestion(EssayQuestion eq);

	int addNewEssayAnswer(EssayAnswer a);

	boolean updateEssayAnswer(EssayAnswer a);

	boolean deleteEssayAnswer(EssayAnswer a);

}