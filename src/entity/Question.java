package entity;

import java.io.Serializable;

public class Question implements Serializable {
	
	private static final long serialVersionUID = -147128355351943618L;
	public String question, answer;
	boolean answeredCorrectly;

	/**
	 * @param question
	 * @param answer
	 */
	public Question(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}

	/**
	 * @param question
	 */
	public Question(String question) {
		this.question = question;
	}
	
	public boolean isCorrect(String answerToQuestion){
		if(answer.equals(answerToQuestion))
			return true;
		return false;
	}
	
}
