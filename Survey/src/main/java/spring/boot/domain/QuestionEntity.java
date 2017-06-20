package spring.boot.domain;

import java.util.List;

import lombok.Data;

@Data
public class QuestionEntity {
	private String questionId;
	private String desciption;
	private String correctAns;
	private List<String> options;
}
