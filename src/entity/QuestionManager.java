package entity;

import java.io.Serializable;
import java.util.ArrayList;

public class QuestionManager implements Serializable {
	
	private static final long serialVersionUID = 7812867479079348517L;
	public static ArrayList<Question> completedQuestions, remainingQuestions;
	public static Question currentQuestion;
	public static int questionsRight, totalQuestions;
	
	public static Question loadNextQuestion(){
		currentQuestion = remainingQuestions.get(0);
		return currentQuestion;
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
	}

	/** This method will load all of the questions from a file and build the remainingQuestions ArrayList
	 * 
	 */
	private static void loadQuestions() {
		remainingQuestions.add(new Question("16 + 3","19"));
		remainingQuestions.add(new Question("12 + 3","15"));
	}

	public static void checkAnswer() {
		if(GameManager.currentAnswer.toString().equals(currentQuestion.answer)){
			questionsRight++;
			currentQuestion.answeredCorrectly = true;
		}
		completedQuestions.add(currentQuestion);
		System.out.println("You've answered: "+questionsRight+"/"+totalQuestions+" right");
		
	}
	
}
