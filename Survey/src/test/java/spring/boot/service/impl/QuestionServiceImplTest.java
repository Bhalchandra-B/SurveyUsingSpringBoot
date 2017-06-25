package spring.boot.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import spring.boot.survey.domain.QuestionEntity;
import spring.boot.survey.repository.QuestionRepo;

public class QuestionServiceImplTest {

	QuestionRepo queRepo = Mockito.mock(QuestionRepo.class);

	QuestionEntity queEntity1, queEntity2;
	List<QuestionEntity> listOfQuestion = new ArrayList<QuestionEntity>();

	@Before
	public void prepareData() {
		queEntity1 = new QuestionEntity(1, "que1", "ans1", Arrays.asList("a", "b", "c", "d"));
		queEntity2 = new QuestionEntity(2, "que2", "ans2", Arrays.asList("a", "b", "c", "d"));
		listOfQuestion.addAll(Arrays.asList(queEntity1, queEntity2));
	}

	@Test
	public void testRetrieveAllQuestions() {

		Mockito.when(queRepo.findAll()).thenReturn(Lists.newArrayList(listOfQuestion));

		List<QuestionEntity> listOfQue = Lists.newArrayList(queRepo.findAll());

		assertTrue(listOfQue.size() >= 2);
		assertEquals((Integer) 2, listOfQue.get(1).getId());
	}

	@Test
	public void testRetrieveQuestionById() {

		Mockito.when(queRepo.findOne(Mockito.anyInt())).thenReturn(queEntity2);

		QuestionEntity questions = queRepo.findOne(2);

		assertEquals((Integer) 2, questions.getId());
	}

	@Test
	public void testAddQuestionById() {

		QuestionEntity question = new QuestionEntity(10, "Largest Continent in the World", "Asia",
				Arrays.asList("Asia", "Africa", "North America", "Antartica"));

		Mockito.when(queRepo.save(Mockito.any(QuestionEntity.class))).thenReturn(question);

		QuestionEntity questions = queRepo.save(question);

		assertEquals((Integer)10, questions.getId());
	}
}
