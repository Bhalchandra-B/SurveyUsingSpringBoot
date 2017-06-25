package spring.boot.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import spring.boot.survey.domain.QuestionEntity;
import spring.boot.survey.domain.SurveyEntity;
import spring.boot.survey.repository.SurveyRepo;
import spring.boot.survey.service.SurveyService;
import spring.boot.survey.service.impl.SurveyServiceImpl;

public class SurveyServiceImplTest {

	SurveyRepo surveyRepo = Mockito.mock(SurveyRepo.class);
	SurveyService surveyService = new SurveyServiceImpl(surveyRepo);
	
	QuestionEntity queEntity1, queEntity2;
	List<QuestionEntity> listOfQuestion = new ArrayList<QuestionEntity>();

	SurveyEntity surveyEntity;
	List<SurveyEntity> listOfSurvey;
	
	@Before
	public void prepareData(){
		queEntity1 = new QuestionEntity(1, "que1", "ans1", Arrays.asList("a", "b", "c", "d"));
		queEntity2 = new QuestionEntity(2, "que2", "ans2", Arrays.asList("a", "b", "c", "d"));
		listOfQuestion.addAll(Arrays.asList(queEntity1, queEntity2));
		
		surveyEntity = new SurveyEntity(1, "Title", "description", Arrays.asList(queEntity1, queEntity2));
		listOfSurvey = new ArrayList<SurveyEntity>(Arrays.asList(surveyEntity));
	}

	@Test
	public void testRetrieveAllSurveys() {
		
		Mockito.when(surveyRepo.findAll()).thenReturn(listOfSurvey);

		List<SurveyEntity> surveys = Lists.newArrayList(surveyService.retrieveAllSurveys());//surveyService.retrieveAllSurveys();

		assertEquals("Title", surveys.get(0).getTitle());
	}

	@Test
	public void testRetrieveSurveyById() {
		
		Mockito.when(surveyRepo.findOne(Mockito.anyInt())).thenReturn(surveyEntity);

		SurveyEntity surveys = surveyService.retrieveSurveyById(1);

		assertEquals((Integer) 1, surveys.getId());
	}
	
	@Test
	public void retrieveAllQuestionsBySurveyId(){
		
		Mockito.when(surveyRepo.findOne(Mockito.anyInt())).thenReturn(surveyEntity);
		
		SurveyEntity survey = surveyRepo.findOne(1);
		
		assertTrue(survey.getQuestions().size() >= 2);
	}
}
