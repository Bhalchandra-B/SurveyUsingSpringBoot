package spring.boot.service;

import java.util.List;

import org.springframework.stereotype.Component;

import spring.boot.domain.QuestionEntity;
import spring.boot.domain.SurveyEntity;

@Component
public interface SurveyService {

	public List<SurveyEntity> retrieveAllSurveys();
	public SurveyEntity retrieveSurvey(String surveyId);
	public List<QuestionEntity>	retrieveQuestions(String surveyId);
	public QuestionEntity retrieveQuestion(String surveyId, String questionId);
	public QuestionEntity addQuestion(String surveyId, QuestionEntity question);
}