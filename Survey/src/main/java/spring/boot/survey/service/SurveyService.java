package spring.boot.survey.service;

import java.util.List;

import org.springframework.stereotype.Component;

import spring.boot.survey.domain.QuestionEntity;
import spring.boot.survey.domain.SurveyEntity;

@Component
public interface SurveyService {

	public List<SurveyEntity> retrieveAllSurveys();

	public SurveyEntity retrieveSurveyById(Integer surveyId);
	
	public List<QuestionEntity>	retrieveAllQuestionsBySurveyId(Integer surveyId);
	
}
