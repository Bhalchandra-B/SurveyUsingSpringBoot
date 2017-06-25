package spring.boot.survey.service;

import java.util.List;
import org.springframework.stereotype.Service;
import spring.boot.survey.domain.QuestionEntity;

@Service
public interface QuestionService {
	
	public List<QuestionEntity> retrieveAllQuestions();
	
	public QuestionEntity retrieveQuestionById(Integer questionId);
	
	public QuestionEntity addQuestion(QuestionEntity question);

}
