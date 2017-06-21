package spring.boot.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor 
@Setter
@Getter
@EqualsAndHashCode(of = "surveyId")
@ToString
public class SurveyEntity {
	private String surveyId;
	private String title;
	private String description;
	private List<QuestionEntity> questions; 
}
