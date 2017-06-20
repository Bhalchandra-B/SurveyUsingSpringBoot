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
@EqualsAndHashCode(of = "questionId")
@ToString
public class QuestionEntity {
	private String questionId;
	private String desciption;
	private String correctAns;
	private List<String> options;
}
