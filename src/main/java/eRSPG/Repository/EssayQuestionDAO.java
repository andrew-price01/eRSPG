package eRSPG.Repository;

import java.util.List;

import eRSPG.model.EssayQuestion;

public interface EssayQuestionDAO {

	List<EssayQuestion> findAllEssayQuestion();

	EssayQuestion findEssayQuestion(int aid);

	void addNewOrUpdateEssayQuestion(EssayQuestion q);

	void deleteEssayQuestion(EssayQuestion a);

}