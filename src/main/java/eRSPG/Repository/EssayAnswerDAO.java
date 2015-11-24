package eRSPG.Repository;

import java.util.List;

import eRSPG.model.EssayAnswer;

public interface EssayAnswerDAO {

	List<EssayAnswer> findAllEssayAnswer();

	EssayAnswer findEssayAnswer(int aid);
	
	void addNewOrUpdateEssayAnswer(EssayAnswer a);

	void deleteEssayAnswer(EssayAnswer a);

}