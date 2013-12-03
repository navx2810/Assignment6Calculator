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
	public static ArrayList<Question> completedQuestions, remainingQuestions;
	public static Question currentQuestion;
	public static StringBuilder currentUserAnswer;
	public static int questionsRight, totalQuestions;
	
	/** This method will load the next question from the remainingQuestions array list 
	 * @return - the next question from the remainingQuestions array list
	 */
	public static void  loadNextQuestion(){
		if(remainingQuestions.size() != 0)
		currentQuestion = remainingQuestions.get(0);
		else 
			GameManager.completeGame();
	}
	
	/** This method will initialize the QuestionManager and call the function to load the questions from a file
	 * 
	 */
	public static void createNewQuestionManager(){
		completedQuestions = new ArrayList<Question>();
		remainingQuestions = new ArrayList<Question>();
		loadQuestions();
		totalQuestions = remainingQuestions.size();
		currentQuestion = remainingQuestions.get(0);
		remainingQuestions.remove(0);
		currentUserAnswer = new StringBuilder();
	}

	/** This method will load all of the questions from a file and build the remainingQuestions ArrayList
	 * 
	 */
	private static void loadQuestions() {
		remainingQuestions.add(new Question("16 + 3","19"));
		remainingQuestions.add(new Question("12 + 3","15"));
	}

	/** This method will check if the answer the player has entered equals the current questions answer variable
	 * @see GameManager
	 */
	public static void checkAnswer() {
		if(GameManager.currentAnswer.toString().equals(currentQuestion.answer)){
			questionsRight++;
			currentQuestion.answeredCorrectly = true;
			
		}
		completedQuestions.add(currentQuestion);
		System.out.println("You've answered: "+questionsRight+"/"+totalQuestions+" right");
		
	}
	
}
