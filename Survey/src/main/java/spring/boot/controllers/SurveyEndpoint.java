package spring.boot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.domain.SurveyEntity;
import spring.boot.service.impl.SurveyServiceImpl;

@RestController
public class SurveyEndpoint {

	@Autowired
	private SurveyServiceImpl surveyService;
	
	@RequestMapping(value="/surveys", method=RequestMethod.GET, produces="application/json")
	public List<SurveyEntity> getAllSurveys(){
		return surveyService.retrieveAllSurveys();
	}
}
