package br.gusehr.neo4j.ogmmappingtest;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

	@Query("match (p:Person) return p.name as name, p.age as age, p.weight as weight, p.height as height, p.nick as nick, p.phoneNumber as phoneNumber, p.email as email")
	public Iterable<PersonQueryResult> findAllByQuery();

}
