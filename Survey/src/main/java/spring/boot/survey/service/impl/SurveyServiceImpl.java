package spring.boot.survey.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import spring.boot.survey.domain.QuestionEntity;
import spring.boot.survey.domain.SurveyEntity;
import spring.boot.survey.repository.SurveyRepo;
import spring.boot.survey.service.SurveyService;

@Service
public class SurveyServiceImpl implements SurveyService {

	private SurveyRepo surveyRepo;

	private static final Logger LOG = LoggerFactory.getLogger(SurveyServiceImpl.class);

	@Autowired
	public SurveyServiceImpl(SurveyRepo surveyRepo) {
		super();
		this.surveyRepo = surveyRepo;
	}

	@Override
	public List<SurveyEntity> retrieveAllSurveys() {

		List<SurveyEntity> surveyList = Lists.newArrayList(surveyRepo.findAll());

		if (surveyList.isEmpty()) {
			LOG.debug("Survey list is empty");
			return null;
		} else
			return surveyList;
	}

	@Override
	public SurveyEntity retrieveSurveyById(Integer id) {

		if (id != null) {
			SurveyEntity survey = surveyRepo.findOne(id);
			if (survey != null)
				return survey;
			else
				LOG.debug("Survey not found");
			return null;
		} else {
			LOG.error("Provided id is null");
			return null;
		}
	}

	@Override
	public List<QuestionEntity> retrieveAllQuestionsBySurveyId(Integer surveyId) {

		if (surveyId != null) {
			SurveyEntity survey = surveyRepo.findOne(surveyId);
			if (survey != null)
				return survey.getQuestions();
			else {
				LOG.debug("Survey is not found");
				return null;
			}
		} else {
			LOG.debug("Survey id is null");
			return null;
		}
	}
}
