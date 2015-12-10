package eRSPG.model.form;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import eRSPG.model.EssayAnswer;

/**
 * Models the form inputs for the proposal body.
 */
public class BodyDetailsForm {

    @NotEmpty(message="Please enter proposal procedures and methods")
    private String procedures;
    @NotEmpty(message="Please enter proposal time-line")
    private String timeLine;
    @NotEmpty(message="Please enter proposal evaluation and dissemination")
    private String evaluation;
    @NotEmpty(message="Please enter proposal budget narrative")
    private String budgetNarrative;

    public String getProcedures() {
        return procedures;
    }

    public void setProcedures(String procedures) {
        this.procedures = procedures;
    }

    public String getTimeLine() {
        return timeLine;
    }

    public void setTimeLine(String timeLine) {
        this.timeLine = timeLine;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public String getBudgetNarrative() {
        return budgetNarrative;
    }

    public void setBudgetNarrative(String budgetNarrative) {
        this.budgetNarrative = budgetNarrative;
    }
    
    private EssayAnswer generateAnswer(String response, int essayQuestionID)
    {
    	EssayAnswer answer = new EssayAnswer();
    	answer.setAnswer(response);
    	answer.setQuestionId(essayQuestionID);
    	
    	return answer;
    }
    
    public List<EssayAnswer> generateEssayAnswers()
    {
    	List<EssayAnswer> answerList = new ArrayList<>();
    	
    	if(!(procedures == null) && !(procedures.isEmpty()))
    	{
    		EssayAnswer answer = generateAnswer(procedures,5);
    		
    		answerList.add(answer);
    	}
    	
    	if(!(timeLine == null) && !(timeLine.isEmpty()))
    	{
    		EssayAnswer answer = generateAnswer(timeLine,6);
    		
    		answerList.add(answer);
    	}
    	
    	if(!(evaluation == null) && !(evaluation.isEmpty()))
    	{
    		EssayAnswer answer = generateAnswer(evaluation,7);
    		
    		answerList.add(answer);
    	}
    	
    	if(!(budgetNarrative == null) && !(budgetNarrative.isEmpty()))
    	{
    		EssayAnswer answer = generateAnswer(budgetNarrative,8);
    		
    		answerList.add(answer);
    	}
    	
    	
    	return answerList;
    }
}
