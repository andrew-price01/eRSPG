package eRSPG.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EssayQuestion")
public class EssayQuestion {
	
	@Id
	@Column(name="questionID")
	private int questionId;
	
	@Column(name="question")
	private String question;
	
	public EssayQuestion(){
		
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
}
