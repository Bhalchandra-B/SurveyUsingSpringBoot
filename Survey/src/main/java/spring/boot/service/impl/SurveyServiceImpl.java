package spring.boot.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import spring.boot.domain.QuestionEntity;
import spring.boot.domain.SurveyEntity;
import spring.boot.service.SurveyService;

public class SurveyServiceImpl implements SurveyService {

	private static List<SurveyEntity> surveys = new ArrayList<SurveyEntity>();

	static {
		QuestionEntity question1 = new QuestionEntity("Question1", "Largest Country in the World", "Russia",
				Arrays.asList("India", "Russia", "United States", "China"));
		QuestionEntity question2 = new QuestionEntity("Question2", "Most Populus Country in the World", "China",
				Arrays.asList("India", "Russia", "United States", "China"));
		QuestionEntity question3 = new QuestionEntity("Question3", "Highest GDP in the World", "United States",
				Arrays.asList("India", "Russia", "United States", "China"));
		QuestionEntity question4 = new QuestionEntity("Question4", "Second largest english speaking country", "India",
				Arrays.asList("India", "Russia", "United States", "China"));
		
		List<QuestionEntity> questions = new ArrayList<QuestionEntity>(Arrays.asList(question1, question2, question3, question4));
		
		SurveyEntity survey = new SurveyEntity("Survey1", "Collected Survey", "description of the survey1", questions);
		surveys.add(survey);
	}

	public List<SurveyEntity> retrieveAllSurveys() {
		return surveys;
	}

	public SurveyEntity retrieveSurvey(String surveyId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<QuestionEntity> retrieveQuestions(String surveyId) {
		// TODO Auto-generated method stub
		return null;
	}

	public QuestionEntity retrieveQuestion(String surveyId, String questionId) {
		// TODO Auto-generated method stub
		return null;
	}

	public QuestionEntity addQuestion(String surveyId, QuestionEntity question) {
		// TODO Auto-generated method stub
		return null;
	}

}
