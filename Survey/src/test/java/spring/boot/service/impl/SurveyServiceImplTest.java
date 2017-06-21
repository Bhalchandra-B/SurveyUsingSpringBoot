package spring.boot.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import spring.boot.domain.QuestionEntity;
import spring.boot.domain.SurveyEntity;
import spring.boot.service.SurveyService;

public class SurveyServiceImplTest {

	// @Autowired
	SurveyService surveyService = new SurveyServiceImpl();

	@Test
	public void testRetrieveAllSurveys() {

		List<SurveyEntity> surveys = surveyService.retrieveAllSurveys();

		assertEquals("Collected Survey", surveys.get(0).getTitle());
	}

	@Test
	public void testRetrieveSurveyById() {

		SurveyEntity surveys = surveyService.retrieveSurveyById("Survey1");

		assertEquals("Survey1", surveys.getSurveyId());
	}

	@Test
	public void testRetrieveQuestions() {

		List<QuestionEntity> questions = surveyService.retrieveQuestions("Survey1");

		assertTrue(questions.size() >= 2);
		assertEquals("Question1", questions.get(0).getQuestionId());
	}

	@Test
	public void testRetrieveQuestion() {

		List<QuestionEntity> questions = surveyService.retrieveQuestions("Survey1");

		assertTrue(questions.size() >= 2);
		assertEquals("Question1", questions.get(0).getQuestionId());
	}
}