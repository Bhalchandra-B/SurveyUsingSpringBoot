package spring.boot.domain;

import java.util.List;

import lombok.Data;

@Data
public class SurveyEntity {
	private String surveyId;
	private String title;
	private String description;
	private List<QuestionEntity> questions; 
}
