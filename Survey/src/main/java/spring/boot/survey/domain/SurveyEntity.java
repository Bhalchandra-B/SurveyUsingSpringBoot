package spring.boot.survey.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Survey")
public class SurveyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String title;

	private String description;
	
	@OneToMany
	private List<QuestionEntity> questions;

	public SurveyEntity() {}
	
	public SurveyEntity(Integer id, String title, String description, List<QuestionEntity> questions) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.questions = questions;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<QuestionEntity> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionEntity> questions) {
		this.questions = questions;
	}
}
