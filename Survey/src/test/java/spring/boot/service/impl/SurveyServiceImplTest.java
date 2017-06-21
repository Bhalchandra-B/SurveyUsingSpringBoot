package spring.boot.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import spring.boot.domain.SurveyEntity;
import spring.boot.service.SurveyService;



public class SurveyServiceImplTest {

	//@Autowired
	SurveyService surveyService = new SurveyServiceImpl();

	@Test
	public void testRetrieveAllSurveys() {

		List<SurveyEntity> surveys = surveyService.retrieveAllSurveys();
		
		assertEquals("Collected Survey", surveys.get(0).getTitle());
	}
}
