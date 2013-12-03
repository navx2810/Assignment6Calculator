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

	
	/** This method will check if the answer the user entered matches the answer found in the question
	 * @param answerToQuestion - the answer the user entered
	 * @return - true if the answer entered matches the answer inside the question || false if the answer does not match
	 */
	public boolean isCorrect(String answerToQuestion){
		if(answer.equals(answerToQuestion))
			return true;
		return false;
	}
	
}
