package spring.boot.survey.controllers;

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

import spring.boot.survey.domain.QuestionEntity;
import spring.boot.survey.domain.SurveyEntity;
import spring.boot.survey.service.QuestionService;
import spring.boot.survey.service.SurveyService;

@RestController
public class SurveyEndpoint {

	@Autowired
	private SurveyService surveyService;
	
	@Autowired
	private QuestionService questionService;

	@RequestMapping(value = "/surveys", method = RequestMethod.GET, produces = "application/json")
	public List<SurveyEntity> getAllSurveys() {
		return surveyService.retrieveAllSurveys();
	}

	@RequestMapping(value = "/surveys/{id}", method = RequestMethod.GET)
	public SurveyEntity getSurveyById(@PathVariable Integer id) {
		return surveyService.retrieveSurveyById(id);
	}

	@RequestMapping(value = "/surveys/{id}/questions",method = RequestMethod.GET)
	public List<QuestionEntity> getAllQuestionsFromSurvey(@PathVariable Integer id) {
		return surveyService.retrieveAllQuestionsBySurveyId(id);
	}

	@RequestMapping(value = "/questions/{questionId}", method = RequestMethod.GET)
	public QuestionEntity getQuestions(@PathVariable Integer questionId) {
		return questionService.retrieveQuestionById(questionId);
	}
	
	@RequestMapping(value = "/questions", method = RequestMethod.GET)
	public List<QuestionEntity> getAllQuestions() {
		return questionService.retrieveAllQuestions();
	}

	@RequestMapping(value = "/questions", method = RequestMethod.POST)
	public ResponseEntity<Void> addQuestion(@PathVariable Integer id, @RequestBody QuestionEntity question) {

		QuestionEntity que = questionService.addQuestion(question);

		if (que == null)
			return ResponseEntity.noContent().build();
		else {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(que.getId()).toUri();
			return ResponseEntity.created(location).build();
		}
	}
}
