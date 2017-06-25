package spring.boot.survey.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import spring.boot.survey.domain.QuestionEntity;
import spring.boot.survey.repository.QuestionRepo;
import spring.boot.survey.repository.SurveyRepo;
import spring.boot.survey.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	private QuestionRepo questionRepo;

	private static final Logger LOG = LoggerFactory.getLogger(QuestionServiceImpl.class);

	@Autowired
	public QuestionServiceImpl(SurveyRepo surveyRepo, QuestionRepo questionRepo) {
		super();
		this.questionRepo = questionRepo;
	}

	@Override
	public List<QuestionEntity> retrieveAllQuestions() {
		return Lists.newArrayList(questionRepo.findAll());
	}

	@Override
	public QuestionEntity retrieveQuestionById(Integer questionId) {

		if (questionId != null) {
			List<QuestionEntity> listQue = Lists.newArrayList(questionRepo.findAll());
			if (!listQue.isEmpty()) {
				for (QuestionEntity q : listQue) {
					if (questionId == q.getId())
						return q;
				}
				LOG.debug("Question not found");
				return null;
			} else {
				LOG.debug("Question list is empy");
				return null;
			}
		} else {
			LOG.debug("Question id is null");
			return null;
		}
	}

	@Override
	public QuestionEntity addQuestion(QuestionEntity question) {

		if (question != null)
			if (questionRepo.save(question) != null)
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
