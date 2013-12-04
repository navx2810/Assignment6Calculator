package entity;

import java.io.Serializable;
import java.util.ArrayList;

/** This class will be used to hold the current and completed questions
 * and how many questions the player has answered correctly and incorrectly. 
 * @author Matt
 * 
 */
public class QuestionManager implements Serializable {
	
	private static final long serialVersionUID = 7812867479079348517L;
	public ArrayList<Question> completedSimpleQuestions, remainingSimpleQuestions, completedFractionQuestions, remainingFractionQuestions;
	public Question currentQuestion;
	public StringBuilder currentUserAnswer;
	public int questionsRight, totalQuestions;
	public boolean isFractionMode = false;
	
	public QuestionManager(){
		completedSimpleQuestions = new ArrayList<Question>();
		remainingSimpleQuestions = new ArrayList<Question>();
		completedFractionQuestions = new ArrayList<Question>();
		remainingFractionQuestions = new ArrayList<Question>();
		loadQuestions();
		totalQuestions = remainingSimpleQuestions.size();
		currentQuestion = remainingSimpleQuestions.get(0);
		remainingSimpleQuestions.remove(0);
		currentUserAnswer = new StringBuilder();
	}
	
	/** This method will load the next question from the remainingQuestions array list 
	 * @return - the next question from the remainingQuestions array list
	 */
	public void  loadNextQuestion(){
		if (!isFractionMode)
			if(remainingSimpleQuestions.size() != 0){
			currentQuestion = remainingSimpleQuestions.get(0);
			remainingSimpleQuestions.remove(0);
			}
			else 
				GameManager.completeGame();
		else
			if(remainingFractionQuestions.size() != 0){
				currentQuestion = remainingFractionQuestions.get(0);
				remainingFractionQuestions.remove(0);
			}
			else
				GameManager.completeGame();
	}
	

	/** This method will load all of the questions from a file and build the remainingQuestions ArrayList
	 * 
	 */
	private void loadQuestions() {
		remainingSimpleQuestions.add(new Question("16 + 3","19"));
		remainingSimpleQuestions.add(new Question("12 + 3","15"));
		remainingSimpleQuestions.add(new Question("9 + 2","11"));
		remainingSimpleQuestions.add(new Question("12 + 3","15"));
	}

	/** This method will check if the answer the player has entered equals the current questions answer variable
	 * @see GameManager
	 */
	public void checkAnswer() {
		//TODO remove this debug sysout
		System.out.println("User answer: "+ currentUserAnswer.toString() + " || Answer to question: "+currentQuestion.answer);
		if(currentUserAnswer.toString().equals(currentQuestion.answer)){
			questionsRight++;
			currentQuestion.answeredCorrectly = true;
		}
		completedSimpleQuestions.add(currentQuestion);
		System.out.println("You've answered: "+questionsRight+"/"+totalQuestions+" right");
		currentUserAnswer.delete(0, currentUserAnswer.length());
		
	}
	
}
