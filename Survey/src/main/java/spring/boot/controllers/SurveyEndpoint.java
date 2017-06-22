package spring.boot.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import spring.boot.domain.QuestionEntity;
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
	
	@RequestMapping(value="surveys/{surveyId}", method=RequestMethod.GET)
	public SurveyEntity getSurveyById(@PathVariable String surveyId){
		return surveyService.retrieveSurveyById(surveyId);
	}
	
	@RequestMapping(value="surveys/{surveyId}/questions")
	public List<QuestionEntity> getQuestions(@PathVariable String surveyId){
		return surveyService.retrieveQuestions(surveyId);
	}
	
	@RequestMapping(value="surveys/{surveyId}/questions/{questionId}", method=RequestMethod.GET)
	public QuestionEntity getQuestions(@PathVariable String surveyId, @PathVariable String questionId){
		return surveyService.retrieveQuestionById(surveyId, questionId);
	}
	
	@RequestMapping(value="surveys/{surveyId}/question", method = RequestMethod.POST)
	public ResponseEntity<Void> addQuestion(@PathVariable String surveyId, @RequestBody QuestionEntity question){
		
		QuestionEntity que = surveyService.addQuestion(surveyId, question);
		
		if(que == null)
			return ResponseEntity.noContent().build();
		else {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(que.getQuestionId()).toUri();
			return ResponseEntity.created(location).build();
		}
	}
}
