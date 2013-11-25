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
	
	public static void createNewQuestionManager(){
		completedQuestions = new ArrayList<Question>();
		remainingQuestions = new ArrayList<Question>();
		loadQuestions();
	}

	private static void loadQuestions() {
		
	}
	
}
