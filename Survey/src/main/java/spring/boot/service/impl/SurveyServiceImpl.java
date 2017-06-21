package spring.boot.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import spring.boot.domain.QuestionEntity;
import spring.boot.domain.SurveyEntity;
import spring.boot.service.SurveyService;

@Component
public class SurveyServiceImpl implements SurveyService {

	private static List<SurveyEntity> surveys = new ArrayList<SurveyEntity>();
	private static List<QuestionEntity> questions;
	private static final Logger LOG = LoggerFactory.getLogger(SurveyServiceImpl.class);

	static {
		QuestionEntity question1 = new QuestionEntity("Question1", "Largest Country in the World", "Russia",
				Arrays.asList("India", "Russia", "United States", "China"));
		QuestionEntity question2 = new QuestionEntity("Question2", "Most Populus Country in the World", "China",
				Arrays.asList("India", "Russia", "United States", "China"));
		QuestionEntity question3 = new QuestionEntity("Question3", "Highest GDP in the World", "United States",
				Arrays.asList("India", "Russia", "United States", "China"));
		QuestionEntity question4 = new QuestionEntity("Question4", "Second largest english speaking country", "India",
				Arrays.asList("India", "Russia", "United States", "China"));

		questions = new ArrayList<QuestionEntity>(Arrays.asList(question1, question2, question3, question4));

		SurveyEntity survey = new SurveyEntity("Survey1", "Collected Survey", "description of the survey1", questions);

		surveys.add(survey);
	}

	@Override
	public List<SurveyEntity> retrieveAllSurveys() {
		return surveys;
	}

	@Override
	public SurveyEntity retrieveSurveyById(String surveyId) {

		if (surveyId != null) {
			for (SurveyEntity survey : surveys)
				if (surveyId.equals(survey.getSurveyId()))
					return survey;
		} else {
			LOG.error("Provided SurveyId is null");
			return null;
		}

		LOG.debug("Survey Not found");
		return null;
	}

	@Override
	public List<QuestionEntity> retrieveQuestions(String surveyId) {
		
		List<QuestionEntity> questions = retrieveSurveyById(surveyId).getQuestions();

		if (surveyId != null)
			return questions;
		else {
			LOG.error("Survey Id is null");
			return null;
		}
	}

	@Override
	public QuestionEntity retrieveQuestionById(String surveyId, String questionId) {

		List<QuestionEntity> questions = retrieveQuestions(surveyId);

		if (surveyId != null && questionId != null) {
			for (QuestionEntity question : questions)
				if (questionId.equals(question.getQuestionId()))
					return question;
		} else {
			LOG.error("Either Survey id or question id is null");
			return null;
		}

		return null;
	}

	@Override
	public QuestionEntity addQuestion(String surveyId, QuestionEntity question) {

		if (surveyId != null && question != null)
			if (retrieveQuestions(surveyId).add(question))
				return question;
			else {
				LOG.debug("Failed to add question in list");
				return null;
			}
		else {
			LOG.error("Either survey or quesiton id is null");
			return null;
		}
	}
}
