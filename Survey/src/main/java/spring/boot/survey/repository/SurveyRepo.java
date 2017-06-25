package spring.boot.survey.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import spring.boot.survey.domain.SurveyEntity;

//@RepositoryRestResource(collectionResourceRel="SurveyRepoRest", path="SurveyRepoRest")
@Repository
public interface SurveyRepo extends PagingAndSortingRepository<SurveyEntity, Integer> {
	
	//public SurveyEntity findByid(@Param("id") String id);

}
