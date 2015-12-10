package eRSPG.model.form;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import eRSPG.model.EssayAnswer;

/**
 * Models the form inputs for the proposal body.
 */
public class BodyForm {

    @NotEmpty(message="Please enter proposal summary (abstract)")
    private String summary;
    @NotEmpty(message="Please enter proposal background and objectives")
    private String background;
    private String hemmingwayExcellence;
    private String hemmingwayCollaboration;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getHemmingwayExcellence() {
        return hemmingwayExcellence;
    }

    public void setHemmingwayExcellence(String hemmingwayExcellence) {
        this.hemmingwayExcellence = hemmingwayExcellence;
    }

    public String getHemmingwayCollaboration() {
        return hemmingwayCollaboration;
    }

    public void setHemmingwayCollaboration(String hemmingwayCollaboration) {
        this.hemmingwayCollaboration = hemmingwayCollaboration;
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
    	
    	if(!(summary == null) && !(summary.isEmpty()))
    	{
    		EssayAnswer answer = generateAnswer(summary,1);
    		
    		answerList.add(answer);
    	}
    	
    	if(!(background == null) && !(background.isEmpty()))
    	{
    		EssayAnswer answer = generateAnswer(background,2);
    		
    		answerList.add(answer);
    	}
    	if(!(hemmingwayCollaboration == null) && !(hemmingwayCollaboration .isEmpty()))
    	{
    		EssayAnswer answer = generateAnswer(hemmingwayCollaboration,4);
    		
    		answerList.add(answer);
    	}
    	if(!(hemmingwayExcellence == null) && !(hemmingwayExcellence .isEmpty()))
    	{
    		EssayAnswer answer = generateAnswer(hemmingwayExcellence,3);
    		
    		answerList.add(answer);
    		
    	}
    	
    	
    	return answerList;
    }
}
