package eRSPG.Repository;

import java.util.List;

import eRSPG.model.EssayQuestion;

public interface EssayQuestionDAO {

	List<EssayQuestion> findAllEssayQuestion();

	EssayQuestion findEssayQuestion(int aid);

	int addNewEssayQuestion(EssayQuestion q);

	boolean updateEssayQuestion(EssayQuestion a);

	boolean deleteEssayQuestion(EssayQuestion a);

}