package spring.boot.survey.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import spring.boot.survey.domain.QuestionEntity;

//@RepositoryRestResource(path = "Questions", collectionResourceRel = "Questions")
@Repository
public interface QuestionRepo extends PagingAndSortingRepository<QuestionEntity, Integer> {

}
